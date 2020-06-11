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

        getSentiment();
    }


    public static void getConfigVenderExtent() {

//        String cookie = "shshshfpb=0ba94ddd72a1646259174c87ce03e7fda84a5ebbc822340295ba67a48d; shshshfpa=861a4326-09be-eb83-5c47-f954b38e3926-1563083029; user-key=269dfd1a-2eb6-4624-8e72-299d8f65f3f0; ipLocation=%u5317%u4eac; pinId=leezDa8HLsFxDsXBs92oD7V9-x-f3wj7; pin=jd_441b953062b44; unick=sara753951; _tp=KLM5Wz84frSwgGqqtWNauV%2BauEzb6Cbs5b7vo29xAyk%3D; _pst=jd_441b953062b44; ipLoc-djd=1-2809-51216-0; cn=19; jd.erp.lang=zh_CN; unpl=V2_bjNtbURQRx12WhQHLxFUVWJWFFsRABcTfFxEUisQXgJmBBsOclRCFX0URlRnGl0UZgsZWUNcQB1FCEdkexhdBWcBEFVKX3MVcgBPVn0aMgQJAnxfLFYtFEU4RVRLGV01ZwcVWEZQQRZxDEZUehlUA2EKEFRFV0ElRQhOU0spiITZ2rLdlf%2fIzMeEdlR%2fG1gBYQYaXkNnQiV0OA06elRcAWAGFlpAVEcRdQhHVHMfWgxlChVdQGdCJXY%3d; CCC_SE=ADC_U1DOyhG%2fECXR6EY8W1hwJEtLvO2avVVMjOjFFs%2b9By4TQGFrJB466sl%2fUgmPOCjCq0m4w%2bLVAwN0lD37VwYaPb8UC7bz7enKbEi9kGP3jzKCNVt96KdGydo%2f3JCF9XWJ8bx%2buCS%2f8pwE9OBEIavvo8WcDx7cigp3IlOPmm%2fh8x6FbHv9s4rf9nYb5qBoDZBusE8GdDppERxwd69IcZZ0nAx3S0KpJnPx0a8cxub8r%2fwvsJ%2bXtYdsRqHB%2fN6FN4uT8XxpFzh87TrKiflpwEW19ptEVmaUQ6bNaW%2b%2fZHTWU2%2fnVyF5zf8MzKBLGuZ%2fvENqAV0HBpJt3hk%2bpCHgCDStlJnD1RK%2bJqWMMrhzVbxrhT7Q6okEi3OGryc4QKqlqLoXRHSTqzyPyZONaAaXL833bUkUPE8sDJpLZwfVSpn6QgJk1FUJYTRs0klzPYl5TmIKLHkyNfnbCNrZjXBJkbITdL2pUFeLJ85pI8m8WuRbW9FIExJKy67uFkjd%2f467NuxkCUrf6esVTsJ3H78ExSXZ6aDAxO4lKXVYLhARa16csHEZkG8gmWM9p7rbrfHgbPt1v4TNVHrACFOXqUIEYXaD9w%3d%3d; __jdv=137720036%7Cforum.jd.com%7Ct_1001133999_1698372_0_0_3_0_0%7Cjingfen%7C76592ccbe99a4d77bfe78e37a836068b%7C1574214633545; mba_muid=15645632551101977838613; __jdu=15645632551101977838613; _cloudberry_login=B7M7RZHCOBUKWQBWSP4HHXUKRY563KSKTULTKCUVSMI7Y3CDCJK6LGY2EYRUJD4RPOFNA54D4BR4MK3SGPJMRL3VMKTHRQ47TVA6LSDCKLBJN652PRK2K2TI5CGZY2HV; shshshfp=7cf1dd9b96fc94c9dd3071a29ad76fb0; qd_uid=K3A5JH3Q-XQYM12X9U3N2IG30M94P; qd_fs=1574427597396; qd_ls=1574427597396; qd_ts=1574427597396; qd_sq=1; ceshi3.com=203; logining=1; session.ticket=825b6e09d89c4643878eb66223b8250c; RT=\"z=1&dm=jd.com&si=tq4xcj0n0f&ss=k3idy8io&sl=0&tt=0&ld=3q8&ul=17gqbp&hd=17gqcd\"; erp1.jd.com=18F1A76BD3C847007E4A696E33F9E4B4342E1B9A65B81D3AA75786FC049ED15553369294994FFCAE72609BAA262BB59473411172049D377FA6C794CDA85FC0AA1814D21AA7B753255AB92418C0F64267; sso.jd.com=BJ.b7ecf8e10bd74f2da4c9b9edb91edabf; 3AB9D23F7A4B3C9B=VNTA4C3246LYPLYUV6IWZPQAT7HYT3U5JRK6JHGZMPJMTBDVKJECJSENM7UU75O62HKQJLBGZAWJFYV4C3P5XADJLU; wlfstk_smdl=7uyjdbu08wontrjo62l4ivnwde4507w8; TrackID=1J-zRiDmS8_ZC5-L1Q6-zUgFc10ElFLT5UZw_gLqZoilUzsiKP7ZeaDZZs4UumOZEcyfcfisL1bVEO4ppsAtbJYCrIIIwroNKKi91cQOiXDn92QmTiK4SQaGVtgIDa2kF; thor=352A6C319B0D4185C12E3567C7C7C7DF0E9E5DFA707482CFCA31B627F3607F07B7DC4EA920CF22561CED88269472B3342A186FA2C50E6707302AC3D11047E5D000CDE621BA5252BD03DFF07EF3B47157AEE146FE4ED509236E1CDEB117A6431526C9D60866EF5F8C6FAA4625D966F09C304F2160A38D654F0DB3FCA44464D1BDAD73CFB8782F7D7158175A0A4F83072911784311EE14FCBB3438E64F9033B3E9; __jda=50436146.15645632551101977838613.1564563255.1575251978.1575257315.502; __jdc=50436146";
        String url = "http://jimi-robot.jd.com/xiaozhiScreenData/configVenderExtent?key=electronic_vender_set&value=";

        FileReader fileReader = new FileReader("/Users/yanxinming/Project/javaProject/HelloWorld/src/main/resources/mallIds");
        List<String> venderIdList  = fileReader.readLines();

        String re = "";
        for (String venderId : venderIdList) {

            re = HttpRequest.get(url + venderId).execute().body();
            System.out.println(re);
        }

    }



    public static void getConfigVenderDept() {


        String cookie = "shshshfpb=0ba94ddd72a1646259174c87ce03e7fda84a5ebbc822340295ba67a48d; shshshfpa=861a4326-09be-eb83-5c47-f954b38e3926-1563083029; pinId=leezDa8HLsFxDsXBs92oD7V9-x-f3wj7; pin=jd_441b953062b44; unick=sara753951; _tp=KLM5Wz84frSwgGqqtWNauV%2BauEzb6Cbs5b7vo29xAyk%3D; _pst=jd_441b953062b44; ceshi3.com=203; areaId=1; ipLoc-djd=1-2809-0-0; jd.erp.lang=zh_CN; __jdv=137720036|direct|-|none|-|1579229530738; __jdu=15645632551101977838613; 3AB9D23F7A4B3C9B=VNTA4C3246LYPLYUV6IWZPQAT7HYT3U5JRK6JHGZMPJMTBDVKJECJSENM7UU75O62HKQJLBGZAWJFYV4C3P5XADJLU; erp1.jd.com=3D2629D2CA54860D9AB1F12C97A925FECAD751CB23772F873B1DC94F4320A2A85EB9B5CF11F18954928C5EF72CAAC204BFB4E65AC39CCBFACA449431247C29036A0CFF58D059CF1C871BFA6CD0260EBE; sso.jd.com=BJ.e3ea506d99b04e9c8e9615a22e1bdd0b; __jda=254415881.15645632551101977838613.1564563255.1578388762.1579259436.503; __jdc=254415881; _pan_=012EFDA45CB0714755D359F5E350A581BA267441172B4423847056C34633BC115F4C157B92ACE98DA36D38256999FFB9C78820C3AEBB180253FAB4FF0C0B66B122C6FAED3B50E22D5D3870731A159E9F";
//        String url = "http://monitor-xiaozhi.jd.com/xiaozhiScreenData/configVenderDept?hKey=appliance_vender_dept_hash&field={field}&value={value}";
        String url = "http://11.36.13.55/xiaozhiScreenData/configVenderDept";

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
            re = HttpRequest.get(url).form(paramMap).execute().body();
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
