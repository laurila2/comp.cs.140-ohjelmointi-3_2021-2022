

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dates {

    public static DateDiff[] dateDiffs(String... dateStrs) {
        ArrayList<LocalDate> dates = new ArrayList<>();
        Dates.DateDiff[] diffArray = new DateDiff[]{};

        for (String date : dateStrs) {
            LocalDate new_date = null;
            try {
                new_date = LocalDate.parse(date);
            }
            catch (DateTimeParseException k) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.uuuu").withResolverStyle(ResolverStyle.STRICT);
                    new_date = LocalDate.parse(date, formatter);
                }
                catch (DateTimeParseException e) {
                    System.out.format("The date \"%s\" is illegal!\n", date);
                }
            }
            if (new_date != null) {
                dates.add(new_date);
            }
        }

        // dates vanhimmasta uusimpaan
        Collections.sort(dates);

        if (dateStrs.length < 2) {
            return diffArray;
        }
        // poimii 2 ja laskee erotuksen
        for(int i = 0, j = i+1; (i < dates.size() && j < dates.size()); i++, j++) {
            LocalDate date1 = dates.get(i);
            LocalDate date2 = dates.get(j);

            // Format LocalDate to ISO-date-string
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            String date1_str = date1.format(formatter);
            String date2_str = date2.format(formatter);

            DateDiff diff = new DateDiff(date1_str, date2_str);

            // Add diff to array
            diffArray = Arrays.copyOf(diffArray, diffArray.length+1);
            int length = diffArray.length;
            diffArray[length-1] = diff;

        }
        return diffArray;
    }

    public static class DateDiff {
        private LocalDate start;
        private LocalDate end;
        private int diff;

        private DateDiff(String start, String end) {

            if ((LocalDate.parse(start) != null) && (LocalDate.parse(end) != null)) {
                this.start = LocalDate.parse(start);
                this.end = LocalDate.parse(end);

                long diffrence = ChronoUnit.DAYS.between(this.start, this.end);
                this.diff = (int) diffrence;
            }
        }

        public LocalDate getStart() {
            return start;
        }

        public LocalDate getEnd() {
            return end;
        }

        public int getDiff() {
            return diff;
        }

        private static String capitalize(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }

        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String start_str = start.format(formatter);
            String end_str = end.format(formatter);

            String start_day = capitalize(String.valueOf(start.getDayOfWeek()).toLowerCase());
            String end_day = capitalize(String.valueOf(end.getDayOfWeek()).toLowerCase());

            return String.format("%s %s --> %s %s: %d days", start_day,
                    start_str, end_day, end_str, diff);
        }
    }
}
