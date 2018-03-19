import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Ramim on 7/28/2017.
 * Intent of this class file is to generate human readable time events from milliseconds
 */

public class HumanReadableTimeDate {

    public static String getTimeDate(long millis, String DateFormat, Locale current){
        SimpleDateFormat formatter = new SimpleDateFormat(DateFormat,current);
        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return formatter.format(calendar.getTime());
    }
}
