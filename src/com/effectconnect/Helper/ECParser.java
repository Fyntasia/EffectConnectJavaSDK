package com.effectconnect.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

final public class ECParser {
    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        return formatter.parse(dateString);
    }
}
