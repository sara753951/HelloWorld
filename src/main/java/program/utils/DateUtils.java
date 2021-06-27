package program.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yanxinming on 2020/3/17
 */
public class DateUtils {





    public static void main(String[] args) {
        String dateStr1 = "2020-03-17";
        String dateStr2 = "2020-03-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = sdf.parse(dateStr1);
            Date date2 = sdf.parse(dateStr2);

            System.out.println(date1.before(date2));
            System.out.println(date1.after(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
