package com.ecommit.orquestrador.job;

import com.ecommit.orquestrador.rest.constants.USDCoinKey;
import com.ecommit.orquestrador.rest.service.CotacaoDolarService;
import com.ecommit.orquestrador.rest.service.InfoOrquestradorJobService;
import com.ecommit.orquestrador.rest.utils.DateUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Component
public class CotacaoDolarJob implements Job {

    private final CotacaoDolarService cotacaoDolarService;
    private final InfoOrquestradorJobService infoOrquestradorJobService;

    public CotacaoDolarJob(CotacaoDolarService cotacaoDolarService, InfoOrquestradorJobService infoOrquestradorJobService) {
        this.cotacaoDolarService = cotacaoDolarService;
        this.infoOrquestradorJobService = infoOrquestradorJobService;
    }

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(CotacaoDolarJob.class)
                .storeDurably()
                .withIdentity("cotacao_dolar_job")
                .withDescription("Invoke Sample Job service...")
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("cotacao_dolar_job_trigger")
                .withDescription("Sample trigger")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(30))
                .build();
    }

    private void logger(Long jobId, Date startFireScheduleDate, Date previousFireScheduleDate, Date nextFireScheduleDate) {
        String nextFireSchedule = DateUtils.formatToString(nextFireScheduleDate);
        String previousFireSchedule = DateUtils.formatToString(previousFireScheduleDate);
        String startFireSchedule = DateUtils.formatToString(startFireScheduleDate);

        System.out.printf("job_id %s / created_at %s / started_at %s / finish_at %s", jobId, startFireSchedule, previousFireSchedule, nextFireSchedule);
    }

    final List<String> coinPairList = List.of(
            USDCoinKey.BRL,
            USDCoinKey.EUR
    );

    @Override
    public void execute(JobExecutionContext context) {
        final Date nextFireScheduleDate = context.getTrigger().getNextFireTime();
        final Date previousFireScheduleDate = context.getTrigger().getPreviousFireTime();
        final Date startFireScheduleDate = context.getTrigger().getStartTime();
        final String jobName = context.getJobDetail().getKey().getName();
        final Long jobId = infoOrquestradorJobService.save(startFireScheduleDate, previousFireScheduleDate, nextFireScheduleDate, jobName);

        coinPairList.forEach(coinPair -> {
            try {
                String price = cotacaoDolarService.getCurrentPrice(coinPair);
                cotacaoDolarService.saveCurrentPrice(jobId, price, coinPair);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        logger(jobId, startFireScheduleDate, previousFireScheduleDate, nextFireScheduleDate);
    }
}
