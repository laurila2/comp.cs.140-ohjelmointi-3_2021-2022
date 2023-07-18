

import java.util.Date;

public class DateTime extends Date {
    private int hour;
    private int minute;
    private int second;

    public DateTime(int year, int month, int day, int hour, int minute, int second) throws DateException {
        super(year, month, day);
        this.hour = hour;
        this.minute = minute;
        this.second = second;

        if (!isLegalDateTime(hour, minute, second)) {
            throw new DateException(String.format("Illegal time %02d:%02d:%02d ", hour, minute, second));
        }
    }

    boolean isLegalDateTime(int hour, int minute, int second) {
        if (!(hour >= 0 && hour <= 23))
            return false;
        else if (!(minute >= 0 && minute <= 59))
            return false;
        else if (!(second >= 0 && second <= 59))
            return false;
        else
            return true;

    }

    @Override
    public String toString() {
        String datetime_str = String.format("%s %02d:%02d:%02d", super.toString(), hour, minute, second);
        return datetime_str;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getHour() {
        return hour;
    }

}
