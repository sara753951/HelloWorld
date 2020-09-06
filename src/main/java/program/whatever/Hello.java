package program.whatever;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.StringUtils;
import program.learning.leetcode.ListNode;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yanxinming on 2019/4/10
 */
public class Hello {


    public static void main(String[] args) throws ParseException {

        byte[] test = {9};
        System.out.println(new String(test));
        byte[] key = {49, 48, 46, 49, 55, 51, 46, 49, 49, 56, 46, 49, 57};
        System.out.println(new String(key));
        byte[] value = {50, 48, 50, 48, 45, 48, 56, 45, 50, 56, 32, 49, 49, 58, 51, 48, 58, 49, 56, 46, 49, 52, 50, 9, 120, 122, 45, 106, 105, 109, 105, 51, 45, 103, 119, 9, 49, 49, 46, 49, 56, 46, 49, 53, 57, 46, 49, 57, 50, 9, 50, 48, 50, 48, 45, 48, 56, 45, 50, 56, 32, 49, 49, 58, 51, 48, 58, 49, 56, 46, 50, 48, 51, 9, 50, 52, 54, 99, 99, 56, 98, 54, 54, 100, 53, 98, 100, 52, 100, 54, 48, 49, 102, 98, 53, 55, 50, 102, 101, 51, 48, 99, 53, 102, 100, 99, 9, 112, 99, 49, 53, 57, 56, 53, 56, 53, 52, 52, 49, 54, 49, 49, 49, 98, 51, 49, 56, 55, 57, 97, 101, 9, 9, 120, 105, 97, 111, 110, 101, 110, 103, 49, 9, 107, 102, 95, 57, 48, 48, 48, 49, 95, 116, 101, 109, 112, 108, 97, 116, 101, 95, 52, 95, 49, 53, 57, 56, 53, 55, 57, 49, 56, 52, 54, 52, 50, 53, 57, 50, 55, 54, 49, 9, 107, 102, 95, 57, 48, 48, 48, 49, 95, 116, 101, 109, 112, 108, 97, 116, 101, 95, 52, 9, 107, 102, 95, 57, 48, 48, 48, 49, 95, 55, 50, 56, 55, 101, 56, 55, 55, 45, 99, 97, 57, 55, 45, 52, 57, 97, 101, 45, 97, 99, 100, 101, 45, 56, 102, 57, 48, 55, 56, 51, 50, 99, 56, 54, 101, 9, 50, 56, 51, 50, 53, 57, 52, 53, 51, 52, 49, 9, 9, 49, 9, 9, 55, 57, 56, 56, 50, 53, 9, 50, 48, 50, 48, 45, 48, 56, 45, 50, 56, 32, 49, 49, 58, 51, 48, 58, 49, 56, 46, 49, 52, 50, 9, 113, 117, 97, 110, 122, 105, 98, 101, 110};
        System.out.println(new String(value));


//        final int MAXIMUM_CAPACITY = 1 << 30;
//
//        int n = 21 - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

//        List<String> list = new ArrayList<>();
//        list.add("Hello");
//        list.add("world");
//        String str = String.join(" ", list);
//        System.out.println(str);


//        String jsonstr = "{\"chatinfo\":{\"entry\":\"m_order_jd\",\"venderName\":\"南极人个护健康旗舰店\",\"orderId\":\"undefined\",\"venderId\":\"681837\",\"riskCode\":\"0\",\"behaviour\":\"5078123121188684390\",\"pid\":\"62174157757\",\"IMService\":false,\"customerAppId\":\"im.customer\",\"verification\":\"semantic\",\"sid\":\"5be102315d07d8b8357b2207f1de0995\"},\"content\":\"退换的改成退\",\"from\":{\"app\":\"im.customer\",\"clientType\":\"m\",\"pin\":\"jd_5a2d951db9b93\"},\"id\":\"2262b329-a115-0714-f900-6ab2412b39db\",\"mid\":189541893,\"sid\":\"5be102315d07d8b8357b2207f1de0995\",\"timestamp\":1578476809939,\"to\":{\"app\":\"im.waiter\",\"pin\":\"个护健康-小小美\"},\"type\":\"text\"}";
//        IMMessage message=JSONObject.parseObject(jsonstr, IMMessage.class);
//
//        chatMessageReceiveService.receive(message);



//        String s1 = "abc";
//        //↑ 在字符串池创建了一个对象  
//
//        String s2 = "abc";
//        //↑ 字符串pool已经存在对象“abc”(共享),所以创建0个对象，累计创建一个对象  
//
//        System.out.println("s1 == s2 : "+(s1==s2));
//        //↑ true 指向同一个对象，  
//
//        System.out.println("s1.equals(s2) : " + (s1.equals(s2)));
//
//
//
//        String s3 = new String("abc");
//        //↑ 在字符串池创建了一个对象  
//
//        String s4 = new String("abc");
//        //↑ 字符串pool已经存在对象“abc”(共享),所以创建0个对象，累计创建一个对象  
//
//        System.out.println("s3 == s4 : "+(s3==s4));
//        //↑ true 指向同一个对象，  
//
//        System.out.println("s3.equals(s4) : " + (s3.equals(s4)));






//        List<test> testList = new ArrayList<>();
//        testList.add(new test("2019-09-01", 1));
//        testList.add(new test("2019-09-02", 2));
//        testList.add(new test("2019-09-03", 3));
//        testList.add(new test("2019-09-04", 4));
//        Collections.sort(testList);
//        for (test te : testList) {
//            System.out.println(te.date + "\t" +te.t + "\n");
//        }
//
//

//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
////
//        String endDate = "2019-08-01";
//        Calendar cal = Calendar.getInstance();
//        String[] date = endDate.split("-");
//        cal.set((int)Integer.parseInt(date[0]), (int)Integer.parseInt(date[1]) - 1, (int)Integer.parseInt(date[2]));
//        System.out.println(sdf.format(cal.getTime()));

//        String beginTime=new String("2019-07-11");
//        String endTime=new String("2019-09-02");
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Date bt=sdf.parse(beginTime);
//        Date et=sdf.parse(endTime);
////        System.out.println(bt.before(et));
////
////
//        Calendar cal= Calendar.getInstance();
//        System.out.println(Calendar.DATE);//5
//        cal.add(Calendar.MONTH,-2);
//        Date date_1 = cal.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_1));
//        System.out.println(bt.getTime() > date_1.getTime());
//
//        cal.add(Calendar.DATE,-1);
//        Date date_2 = cal.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_2));
//
//        cal.add(Calendar.DATE,-5);
//        Date date_7=cal.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_7));
//
//        cal.add(Calendar.DATE,-1);
//        Date date_8=cal.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_8));
//
//        cal.add(Calendar.DATE,-1);
//        Date date_9=cal.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_9));
//
//        cal.add(Calendar.DATE,-5);
//        Date date_14=cal.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_14));
//
//        cal.add(Calendar.DATE,-1);
//        Date date_15=cal.getTime();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date_15));

//        int a = 47;
//        int b = 7;
//        double cc = a / b;
//        double ccc = (double) a / b;
//
//        System.out.println(cc);
//        System.out.println(ccc);
    }


    static class test implements Comparable<test>{

        public String date;
        public int t;

        public test(String date, int t) {
            this.date = date;
            this.t = t;
        }

        @Override
        public int compareTo(test o) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

            Date date1 = null;
            Date date2 = null;
            try {
                date1 = sdf.parse(this.date);
                date2 = sdf.parse(o.date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (date1.before(date2)){
                return 1;
            } else if (date1.equals(date2)) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
