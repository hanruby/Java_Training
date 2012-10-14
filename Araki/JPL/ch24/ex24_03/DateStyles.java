package ch24.ex24_03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class DateStyles {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("usage: java DateStyles.class [date]");
            return;
        }
    }

    @SuppressWarnings("serial")
    public static Map<Integer, String> formatPattern = new HashMap<Integer, String>() {
        {
            this.put(DateFormat.FULL, "Full");
            this.put(DateFormat.LONG, "Long");
            this.put(DateFormat.MEDIUM, "Medium");
            this.put(DateFormat.SHORT, "Short");
        }
    };

    // public static Locale locale = new Locale("ja", "JP");
    public static Locale locale = new Locale("en", "US");

    public static void showDate(String source) {

        System.out.println(source);
        for (Entry<Integer, String> formatDate : formatPattern.entrySet()) {
            for (Entry<Integer, String> formatTime : formatPattern.entrySet()) {
                DateFormat fmt = DateFormat.getDateTimeInstance(
                        formatDate.getKey(), formatTime.getKey(), locale);
                Date date = parseDate(fmt, source);
                System.out.printf("  %sx%s\t", formatDate.getValue(), formatTime.getValue());
                if (date != null)
                    System.out.printf("%s", fmt.format(date));
                else
                    System.out.printf("Ignored");
                System.out.println();
            }
        }
    }

    public static Date parseDate(DateFormat fmt, String source) {
        Date date = null;
        try {
            date = fmt.parse(source);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return date;
    }
}
