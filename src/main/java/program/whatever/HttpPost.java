package program.whatever;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.sun.net.httpserver.HttpContext;
import sun.net.www.http.HttpClient;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yanxinming on 2019/11/29
 */
public class HttpPost {


    public static void main(String[] args) {

        getConfigVenderDept();
    }


    public static void getConfigVenderExtent() {

        String cookie = "shshshfpa=6672939e-277b-a68f-fb90-e1a67ef6252b-1588132619; shshshfpb=iGBXKBwRWVR4CxkK33Rsn1w%3D%3D; __jdu=1588132244620735462412; session.ticket=710181cdfa3343428b4378cbc8263e51; user-key=8fdb275f-e4b0-4885-af93-81678b42f7f0; pinId=leezDa8HLsFxDsXBs92oD7V9-x-f3wj7; pin=jd_441b953062b44; unick=sara753951; ceshi3.com=203; _tp=KLM5Wz84frSwgGqqtWNauV%2BauEzb6Cbs5b7vo29xAyk%3D; _pst=jd_441b953062b44; cn=25; areaId=1; 3AB9D23F7A4B3C9B=VNTA4C3246LYPLYUV6IWZPQAT7HYT3U5JRK6JHGZMPJMTBDVKJECJSENM7UU75O62HKQJLBGZAWJFYV4C3P5XADJLU; ipLoc-djd=1-2809-51231-0; yl_pcpc=yGx99nAK6yNVQaGdMTArhG2KIZqwxGMcNTfylYaXFUeR_0CBHnJ83uoe8EydH16GNydNh9gQmpff4Eb07OnrsA%3D%3D; jd.erp.lang=zh_CN; sso.jd.com=BJ.b980a4e9e3e94b4ab802767ee0e3a1a3; erp1.jd.com=A8CFD9B79F406F551AF277F68319C6F24E10F1527AC81156FEF94BBA077EED788D60384EB5675FB78BB3DCCC64CDD210E1B42DD993025ABCCED63827A334DB31936294999F0A149705F2EBD829E252CA; wlfstk_smdl=zujsxemp5exms513kg6rocq6wyjtjj4j; TrackID=1VXAhwh_ys5FBg0uH9BnK5Pe7yf4w4jfhKfwOEiRcsqx5-GYZgoKmHoG2tPNKNNv0bUW1JhxM0pgzxRjS1YQheZQ-mDAsC2peGuB1HJnZjtZ-QqGbrhL69OlInJ6FMgVt; xz_auth_dev=\"gTZVMGDQHeCOgIXMHEj3H0UE3MP3IWZWmqT20VPvP85m9D/T4kBmdS/bbhUiyGczVEanp/sw6Wq9cln9FMhhgQBGK8zfFUPzjdSUgE2bJ7PF9Wx+R+cTGUQ75/NqJNiLiAaranOrqbGtxg3uz+q7Vx8/FUJBmEMomH32dwjB95U=\"; __jdv=122270672|direct|-|none|-|1604485499085; shshshfp=2dfd93775c71a25e78ed6a21a5586180; mba_muid=1588132244620735462412; xz_auth=\"TSrPjPPWEhM3k9RRGDRBfHhyuHwO20gMxiA4loPjJEIFZDfyb/c7Z1kAF0qN8dGkTKxJKDvzMxo84KxmEhgXJYCO1mr+iPVTQYuK0grRf98lRnTm6beUDpVFjQ68gFus4E2F1peZ/UaBWi3HbWhV1vwW3f/Ni3vv5+K8xyacuNI=\"; username=yanxinming; name=%E9%97%AB%E6%AC%A3%E9%B8%A3; __jda=248777169.1588132244620735462412.1588132245.1595498729.1599458486.15; __jdc=248777169; __jdb=248777169.12.1588132244620735462412|15.1599458486";
        String url = "http://jimi-robot.jd.com/xiaozhiScreenData/configVenderExtent?key=electronic_vender_set&value=";

        FileReader fileReader = new FileReader("/Users/yanxinming/Project/javaProject/HelloWorld/src/main/resources/venderIds");
        List<String> venderIdList  = fileReader.readLines();

        String re = "";
        for (String venderId : venderIdList) {

            re = HttpRequest.get(url + venderId).cookie(cookie).execute().body();
            System.out.println(re);
        }

    }



    public static void getConfigVenderDept() {


        String cookie = "shshshfpa=6672939e-277b-a68f-fb90-e1a67ef6252b-1588132619; shshshfpb=iGBXKBwRWVR4CxkK33Rsn1w%3D%3D; __jdu=1588132244620735462412; session.ticket=826961bc5f014e6f9b03828fdaecd756; user-key=8fdb275f-e4b0-4885-af93-81678b42f7f0; pinId=leezDa8HLsFxDsXBs92oD7V9-x-f3wj7; pin=jd_441b953062b44; unick=sara753951; ceshi3.com=203; _tp=KLM5Wz84frSwgGqqtWNauV%2BauEzb6Cbs5b7vo29xAyk%3D; _pst=jd_441b953062b44; cn=25; areaId=1; 3AB9D23F7A4B3C9B=VNTA4C3246LYPLYUV6IWZPQAT7HYT3U5JRK6JHGZMPJMTBDVKJECJSENM7UU75O62HKQJLBGZAWJFYV4C3P5XADJLU; ipLoc-djd=1-2809-51231-0; yl_pcpc=yGx99nAK6yNVQaGdMTArhG2KIZqwxGMcNTfylYaXFUeR_0CBHnJ83uoe8EydH16GNydNh9gQmpff4Eb07OnrsA%3D%3D; jd.erp.lang=zh_CN; sso.jd.com=BJ.b980a4e9e3e94b4ab802767ee0e3a1a3; erp1.jd.com=A8CFD9B79F406F551AF277F68319C6F24E10F1527AC81156FEF94BBA077EED788D60384EB5675FB78BB3DCCC64CDD210E1B42DD993025ABCCED63827A334DB31936294999F0A149705F2EBD829E252CA; wlfstk_smdl=zujsxemp5exms513kg6rocq6wyjtjj4j; TrackID=1VXAhwh_ys5FBg0uH9BnK5Pe7yf4w4jfhKfwOEiRcsqx5-GYZgoKmHoG2tPNKNNv0bUW1JhxM0pgzxRjS1YQheZQ-mDAsC2peGuB1HJnZjtZ-QqGbrhL69OlInJ6FMgVt; xz_auth_dev=\"gTZVMGDQHeCOgIXMHEj3H0UE3MP3IWZWmqT20VPvP85m9D/T4kBmdS/bbhUiyGczVEanp/sw6Wq9cln9FMhhgQBGK8zfFUPzjdSUgE2bJ7PF9Wx+R+cTGUQ75/NqJNiLiAaranOrqbGtxg3uz+q7Vx8/FUJBmEMomH32dwjB95U=\"; __jdv=122270672|direct|-|none|-|1604485499085; mba_muid=1588132244620735462412; xz_auth=\"TSrPjPPWEhM3k9RRGDRBfHhyuHwO20gMxiA4loPjJEIFZDfyb/c7Z1kAF0qN8dGkTKxJKDvzMxo84KxmEhgXJYCO1mr+iPVTQYuK0grRf98lRnTm6beUDpVFjQ68gFus4E2F1peZ/UaBWi3HbWhV1vwW3f/Ni3vv5+K8xyacuNI=\"; shshshfp=68965a41da95c2d60635d6ca4bbd904f; RT=\"z=1&dm=jd.com&si=f6p7txdn7fl&ss=kh5yp4cm&sl=2&tt=3ir&ld=8qvg&ul=9cn7&hd=9cng\"; __jda=124138652.1588132244620735462412.1588132245.1595498729.1599458486.15; __jdc=124138652";
//        String url = "http://monitor-xiaozhi.jd.com/xiaozhiScreenData/configVenderDept?hKey=appliance_vender_dept_hash&field={field}&value={value}";
        String url = "https://monitor-xiaozhi.jd.com/venderData/configVenderDept";

        FileReader fileReader = new FileReader("/Users/yanxinming/Project/javaProject/HelloWorld/src/main/resources/vender_dept");
        List<String> fileContent  = fileReader.readLines();

        String re = "";
        for (String line : fileContent) {
            String[] l = line.split("\t");

            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("hKey", "appliance_vender_dept_hash");
            paramMap.put("field", l[0]);
            paramMap.put("value", l[1]);

//            String real = url.replace("{field}", l[0]);
//            real = real.replace("{value}", l[1]);

//            System.out.println(real);
//            re = HttpRequest.get(real).cookie(cookie).execute().body();


            System.out.println(paramMap.entrySet());
            re = HttpRequest.get(url).form(paramMap).cookie(cookie).execute().body();
            System.out.println(re);
        }
    }

    private static void getSentiment() {
        String url = "http://g.jsf.jd.local/com.jd.jimi3.support.sdk.OpenSupportService/OPEN_JIMI3/getSentimentResult/43967/jsf/10000";

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("text", "我的快递怎么还没到~");
        paramMap.put("messageId", "api_test");

        String result2 = HttpRequest.post(url)
                .header("token", "JIMI3@supportApi")//头信息，多个头信息多次调用此方法即可
                .form(paramMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();


        System.out.println(result2);
    }
}
