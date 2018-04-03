package com.effectconnect.Helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

final public class ECFormatter {

    static public String formatPrice(Double price) {
        DecimalFormatSymbols decimalSymbols = DecimalFormatSymbols.getInstance();
        decimalSymbols.setDecimalSeparator('.');

        return new DecimalFormat("0.0000", decimalSymbols).format(price);
    }

    static public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ") {
            public StringBuffer format(Date date, StringBuffer toAppendTo, java.text.FieldPosition pos) {
                StringBuffer toFix = super.format(date, toAppendTo, pos);
                return toFix.insert(toFix.length()-2, ':');
            };
        };
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Amsterdam"));

        return formatter.format(date);
    }
}
