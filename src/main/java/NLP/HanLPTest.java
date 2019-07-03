package NLP;

import com.hankcs.hanlp.HanLP;

/**
 * Created by yanxinming on 2019/1/16
 */
public class HanLPTest {

    public static void main(String[] args) {
        String[] strings = {"国美在线联合咕咚发起“最后一公里”夜跑项目",
                "国美在线联合咕咚平台収起“国美夜跑,暖心在线”活劢,通过国美在线物流负责人和大家一起在双十一当天以",
                "夜跑送快件的形式,让大家体验一把快递小哥的辛苦,在为快递小哥送温暖的同时,让消费者感受到国美在线的",
                "“温度服务”。",
                "我主要负责:全程参与项目活动中,独立完成跨部门沟通,确保国美在线物流负责人的可参与规划,以及活劢结",
                "束后后期的传播报道。",
                "国美 Plus 4.13 媒体沟通会",
                "整场活劢以演讲+互劢提问+领导人专访的模式进行:邀请核心媒体逾 50 人,结合了线上収布、线下体验场景及",
                "互动环节;后续媒体报道持续升温,Plus 品牌结合代言人陈伟霆制造话题营销,为期 3 周。"};

        for(String text : strings) {
            System.out.println(HanLP.segment(text));
        }

//        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
    }
}
