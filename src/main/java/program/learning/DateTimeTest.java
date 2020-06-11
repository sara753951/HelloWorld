package program.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanxinming on 2018/11/14
 */
public class DateTimeTest {

    //86400000一天
    public static void main(String[] args) throws ParseException {
        long month4 = Long.parseLong("10368000000");

//        System.out.println(new Date().getTime());

        String dateStr1 = "2006年03月";
        String dateStr2 = "2006-03";
        System.out.println(getDate2("2006年03月").getTime());
        System.out.println(getDate2("2006-03").getTime());
        System.out.println(getDate2("06").getTime());
        System.out.println(getDate2("2006.3").getTime());
        System.out.println(getDate2("2006/3").getTime());

//        System.out.println(Long.MAX_VALUE);
        System.out.println(getDateBetween2(dateStr1, dateStr2) > month4);
    }

    private static long getDateBetween(String dateStr1, String dateStr2) {
        Date date1 = getDate(dateStr1);
        Date date2 = getDate(dateStr2);

        System.out.println(date1.getTime());
        System.out.println(date2.getTime());

        return date2.getTime() - date1.getTime();
    }


    private static Date getDate(String dateStr) {
        String dateRegex1 = "yyyy年MM月";
        String dateRegex2 = "yyyy-MM";
        SimpleDateFormat sdf = null;
        if (Pattern.compile("\\d+年\\d+月").matcher(dateStr).matches()) {
            sdf=new SimpleDateFormat(dateRegex1);
        }else if (Pattern.compile("\\d+-\\d+").matcher(dateStr).matches()) {
            sdf=new SimpleDateFormat(dateRegex2);
        }

        try {
            return sdf.parse(dateStr.replaceAll("\\s",""));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static long getDateBetween2(String dateStr1, String dateStr2) {
        Date date1 = getDate2(dateStr1);
        Date date2 = getDate2(dateStr2);
        if(date1 == null || date2 == null) {
            return 0;
        }

        return date2.getTime() - date1.getTime();
    }


    private static Date getDate2(String dateStr) {
        String dateRegex1 = "yyyy年MM月";
        String dateRegex2 = "yyyy-MM";
        String dateRegex3 = "yy";
        String dateRegex4 = "yyyy/MM";
        String dateRegex5 = "yyyy.MM";

        SimpleDateFormat sdf = null;
        if (Pattern.compile("\\d{4}年\\d{1,2}月").matcher(dateStr).matches()) {
            sdf=new SimpleDateFormat(dateRegex1);
        }else if (Pattern.compile("\\d{4}-\\d{1,2}").matcher(dateStr).matches()) {
            sdf=new SimpleDateFormat(dateRegex2);
        }else if (Pattern.compile("\\d{4}/\\d{1,2}").matcher(dateStr).matches()) {
            sdf = new SimpleDateFormat(dateRegex4);
        } else if (Pattern.compile("\\d{4}\\.\\d{1,2}").matcher(dateStr).matches()) {
            sdf = new SimpleDateFormat(dateRegex5);
        } else if (Pattern.compile("\\d{2}").matcher(dateStr).matches()){
            sdf = new SimpleDateFormat(dateRegex3);
        }

        try {
            if (sdf != null) {
                return sdf.parse(dateStr.replaceAll("\\s",""));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }
}
