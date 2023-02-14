package com.ecommit.orquestrador.rest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {
    public static String formatToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
