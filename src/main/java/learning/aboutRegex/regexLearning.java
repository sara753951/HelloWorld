package learning.aboutRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanxinming on 2018/9/7
 */
public class regexLearning {

    private static String companyRex="(([\u4e00-\u9fa5]|[a-z0-9])*(\\(?)([\u4e00-\u9fa5]|[a-z0-9])+(\\)?|\\(?)[\u4e00-\u9fa5]+(\\)?)[\u4e00-\u9fa5]*)";


    public static void main(String[] args) {


        String string = "html,body,div,p{margin:0;padding:0}\n" +
                "          body{font-size:14px;font-family:Arial,Microsoft YaHei,'宋体';background-color:#ffffff}\n" +
                "          table{border-collapse:collapse;border-spacing:0;table-layout:fixed;}\n" +
                "\n" +
                "          th,td{font-size:13px;padding-left:0px}\n" +
                "          a{text-decoration:none}\n" +
                "          img{border:0 none}\n" +
                "          .blue{text-decoration:none;color:#3c3d5d}\n" +
                "          .column{width:702px;line-height:28px;}\n" +
                "          .column .gray{color:#999999;word-break:break-word;}\n" +
                "          .column .gray2{color:#666666}";
        String regex = "body,?.*?\\{.*?font-family:(.*?)[,;].*?}";
        findAll(regex, string, 1);

//        String string = "font-family:宋体;mso-ascii-font-family:Calibri;  mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:  minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin";
//        String regex = ".*?font-family:\\s*\"?(.*?)[\";].*";
//        findAll(regex, string, 1);

//        String string = "axxxbxxx1xxx2";
//        String regex = "x([ab]|[12])x";
//        findAll(regex, string, 1);

//        String string = "<abc>充不上电</abc>";
//        String regex = "<abc>(.+?)</abc>";
//        findAll(regex, string, 1);

//        String string = "主修课程:工科数学分析，线性代数，C 语言程序设计与实践，工科大学物理，电子科技大学,计算机软件技术基础与实践，机";
//        String regex = "(?<=，|\\s|\\,|#|:|：|\\[|\\]|\\d|\\r|\\n)([^工科|文科][\u4e00-\u9fa5]+?(中科院|学院|学校|大学|一中|高中|中学|小学|师范)\\s*(.{2,10}分\\s*校)?)";
//        findAll(regex, string, 1);

//        String string = "应聘职位： 广汽车后 市场-客户经理 智联招聘###应聘机构： 广京东 集团###工作地点： 广州###ID：ND8EfhQ962r0j1q6sIRxGA 　　　　　　　　 更新时间：2018.11.06###梁庆艺 手机：13726784235###男 26岁 (1992年8月) 3年工作经验 大专 现居住地：广州 | 户口：贵港###手机：13726784235 E-mail：1026852802@qq.com\n";
//        String regex = "(?<!(工作地点|应聘机构|应聘职位|期望从事职业|简历更新时间)(：|:))(^|#|\\s|\\ufeff)((广|梁)(\\s*[\\u4e00-\\u9fa5]){1,4})(#|[^:：\\u4e00-\\u9fa5]|\\s*$)";
//        findAll(regex, string, 4);

//        String tmpLine = "美国加州伯克利大学信息学院   (UC   Berkley   School   of   Information)      ###硕士学位，信息和数据科学(Master   of   Information   and   Data   Science)   ";
//        Pattern pattern = Pattern.compile("(^|\\s|[\\s\\p{Zs}]|#|\\||-|——|，|,|《|<|\\(|\\))([\u4e00-\u9fa5a-zA-Z]+)(?=($|\\s|[\\s\\p{Zs}]|#|\\||,|，|>|》|\\(|\\)))");
//        Matcher matcher = pattern.matcher(tmpLine);
//        while(matcher.find()) {
//            System.out.println(matcher.group(2));
//        }


//        String schoolStr = "本科/沈阳理工大学";
//        Pattern schoolPattern = Pattern.compile("(^|\\s+|[\\s\\p{Zs}]+|#|:|：|于|在|[0-9]|/)([^\\s(\\s\\p{Zs}):：#\ufeff\\r\\n\\,，\\d/]+(中科院|研究院|学院|学校|大学|中学|高中|一中|小学|⼤学|师范)\\s*(.{2,10}分\\s*校)?)($|#|\\s|[\\s\\p{Zs}]|[^\u4e00-\u9fa5])");
//        Matcher schoolMatcher = schoolPattern.matcher(schoolStr);
//        if (schoolMatcher.find()) {
//            System.out.println(schoolMatcher.group(2));
//        }

//        String htmlString = "<p class=MsoNormal><span style='font-family:宋体;mso-ascii-font-family:Calibri;  mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:  minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>简历名称：</span></p>  </td>  <td width=509 valign=top style='width:381.8pt;padding:0cm 5.4pt 0cm 5.4pt'>  <p class=MsoNormal><b style='mso-bidi-font-weight:normal'><span lang=EN-US></span></b><b  style='mso-bidi-font-weight:normal'><span style='font-family:宋体;mso-ascii-font-family:  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;";
//        String htmlRegex = "\\<span.*?\\>(.*?)(\\</span\\>)";
//        Pattern htmlPattern = Pattern.compile(htmlRegex);
//        Matcher htmlMatcher = htmlPattern.matcher(htmlString);
//        if (htmlMatcher.find()) {
//            System.out.println(htmlMatcher.group(1));
//        }
//
//        String nameLine = "陈奕奕 个人简历 \n" +
//                " \n" +
//                "女    23 岁(1995 年 12 月)    美国 纽约  应届毕业    本科   \n" +
//                "现居住地：广东 广州-海珠区逸景翠园碧桃居Ｃ座 1205 房  | 户口：广州   美国纽约 4 年工作/学习经验  \n" +
//                "手机：13725449629 \n" +
//                "E-mail：cyylily@163.com  \n" +
//                "个人作品网站：www.yiyichendesign.com \n" +
//                " \n" +
//                " \n" +
//                " ";
////        Pattern namePattern = Pattern.compile(".*(?<=简历名称)[:：#]+((((李|林)[\\u4e00-\\u9fa5]{1,3})\\s*(?=的简历))|(((李|林)[\\u4e00-\\u9fa5]{1,3})\\s*(?=简历))).*");
//        Pattern namePattern = Pattern.compile("((?<=简历名称)[:：#]+)?(((李|林|潘|刘|陈)[\\u4e00-\\u9fa5]{1,3}?)\\s*(?=(的简历)|((中文|个人)?简历)|\\s|#)).*");
//        Matcher nameMatcher = namePattern.matcher(nameLine);
//        if (nameMatcher.find()) {
//            System.out.println(nameMatcher.groupCount());
//            System.out.println(nameMatcher.group(2));
//        }
//
//        String string = "易一易二⼤一大二";
//        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
////        Pattern pattern = Pattern.compile("[\\u2f00-\\u2fdf]+");
//        Matcher matcher = pattern.matcher(string);
//        if (matcher.find()) {
//            System.out.println(matcher.group(0));
//        }
//
//        String linePositionSuffix = "###2016.09 - 2018.09   北京华宇泰聚科技有限公司   (2 年 1 个月)  ###java 开发工程师 | 10001-15000 元/月  ###互联网/电子商务  ###工作描述： 1、负责研发公司应用软件的模块设计、开发 ###2、负责编码，单元测试 ###3、按照功能组件的详细设计 ###4、参与新知识的学习和培训 ###5、完成上级交办的其他事宜 ";
//        Pattern patternPositionSuffix = Pattern.compile("( |:|：|^|#|\\s|)+\\s*([ \\u4e00-\\u9fa5a-z]+(项目执行|测试员|证券总监|信贷管理|资金专员|会计师|统计员|用户研究专员|保险代理|副行长|拍卖|质量工程师|老师|主任|CEO|投资服务|销售助理|融资总监|解决方案|flash设计|资金管理|首席财务官|综合业务经理|SEO|出纳员|契约管理|储备经理人|办公室职员|期货经纪人|移动互联网开发工程师|外汇经纪人|风险稽查|电信工程师|财务顾问|技术经理|资产评估|法务|iOS开发|研究员|电信网络工程师|计划管理|税务经理|银行经理|资信评估分析|电信交换工程师|维护经理|运维经理|项目经理|助理|实施顾问|财务经理|游戏开发|税务专员|硬件测试|首席技术官|财务分析员|会计助理|续期管理|维护工程师|系统测试|精算|风险管理|公司业务|财务总监|行长|架构师|财务规划师|专员|税务助理|技术总监|综合业务专员|国债经理人|保险受理|合规|中级会计师|信用卡销售|运营管理|资产管理|人力资源部|保险顾问|游戏界面设计师|理财服务|手机软件开发工程师|主管|数据挖掘工程师|人员|设计师|信用证结算|股票操盘手|审计经理|技术支持|测试工程师|研发工程师|保险经纪人|游戏策划|会计经理|财务助理|成本经理|经理|银行卡销售|机器学习工程师|游戏设计|顾问|高级会计师|高级客户经理|保险培训师|个人业务|组长|编辑|标准化工程师|技术助理|信审核查|特效设计师|车险核保岗|投资|信息技术专员|清算人员|文档工程师|银行柜员|项目总监|数据分析|初级会计师|通信电源工程师|保险项目策划|文案策划|经理人|精算师|工程师|融资经理|负责人|品质经理|银行主任|审计专员|高级硬件工程师|秘书|部长|融资专员|三维设计|操盘手|总账主管|涉税项目经理|客户经理|外汇交易经理人|稽核|典当业务|移动通信工程师|银行会计|财务主管|计量工程师|信息技术经理|数据通信工程师|算法工程师|保险内勤|通信技术工程师|文职|商务采购|有线传输工程师|helpdesk|投资银行业务|经纪人|担保|会计文员|财务分析经理|风险控制|分析师|外汇交易|成本会计|网络优化师|教师|店长|技术专员|会计|进出口结算|业务经理|无线通信工程师|安卓开发|运维工程师|保险产品开发|证券分析|核保理赔|金融研究|总经理|基金管理|客户服务|市场管理|硬件工程师|大堂经理|用户体验师|计算机硬件维护工程师|软件测试|射频通信工程师|总监|电子银行业务推广|通信工程师|基金经理人|CTO))($|#|\\s|)");
//        Matcher matcherPositionSuffix = patternPositionSuffix.matcher(linePositionSuffix);
//        if (matcherPositionSuffix.find()) {
//            System.out.println(matcherPositionSuffix.groupCount());
//            System.out.println(matcherPositionSuffix.group(2));
//        }


//        String lineT = "###2013/01—2017/05   旺旺集团 ###开心散装事业部全国业务负责人（年销售额：9亿；管理 500人） ###\uF0D8 负责拟定开心散装事业部年度战略规划 ###\uF0D8 负责开心散装事业部新品类的开发及老品类梳理淘汰 ###\uF0D8 负责开心散装事业部渠道建设及年度渠道促销活动规划 ###\uF0D8 推动一线销售团队完成开心散装事业部年度客户开发工作、客户分级管理 ###\uF0D8 负责规划开心散装事业部经营的品类年度主题促销活动 ###\uF0D8 负责开心散装事业部销售团队的建设、培训培养晋升体系管理 ###\uF0D8 完成开心散装事业部标杆门店打造、门店分级管理 ###\uF0D8 推动开心散装事业部专卖店项目 ###\uF0D8 完成开心散装事业部年度集团下达业绩指标 ###\uF0D8 按时完成事业部总经理临时安排工作 ###\uF0D8 走访市场，了解一线销售情况及竞品动态，及时调整销售策略 ###\uF0D8 定期拜访开心散装事业部 10 大经销商，并对其进生意回顾及客户业务团队培训 ###\uF0D8 优化 14、15 年散装事业部经销商合同政策 ###\uF0D8 14、15 年事业部业绩及费用预算、组织架构战力编制,制定全年两大全国渠道政策春夏果冰大作###战/旺季旺糖囤货案,14、15 年全年产品推广方案及渠道推广方案框架（以开心为主题 4 大主题###活动方案） ###\uF0D8 创新散装事业部第一次全国经销商集中签约会会议形式 ###\uF0D8 试点经营个别区域以消费者促销为导向的营销策略——独立制定了“清凉一夏、冰爽开心”主###题促销 ###\uF0D8 根据总经理的坦克车推动基础作业计思路,制定“种好责任田、开心马上旺”的渠道拓展主题活###动 ###\uF0D8 优化散装事业部直营 KA 的模式及流程 ###ZSFC - Recruitment Solutions              0571-87250369                    Yoko Cao ###16F Skyline Plaza, No.181 TIANMUSHAN Road, Hangzhou, China    ###\uF0D8 梳理事业部组织架构，健全战情稽核及战情督导体系 ###\uF0D8 制定市场作业的基础考核指标（品项上架率、城市铺货率、陈列达标率、导购在岗率、促销绩###效率） ###\uF0D8 完成总部 5 大区的拆分（完成 9 大区的统筹）及 30 个营业分公司的裂变（布局 64 个营业区）###大区、省区 KPI 考核管理优化、销售体系各层级人员的薪资考核优化 ###\uF0D8 优化糖果（新品香蕉牛奶糖）、果冻系列（新品吸吸冰、双色布丁）的口味拓展及休闲类产品升###级 ###\uF0D8 健全开心散装全国营销体系培训及会议机制 ###\uF0D8 优化全国开心散装经销客户分级管理 ###\uF0D8 开心散装专卖店运营模式启动 ###\uF0D8 优化产品包装及品牌新形象、重塑品牌内涵——“中国梦 享开心；乐生活，多滋味” ###\uF0D8 开心散装新的广告片创意提出及审核、制定 14 年媒体投放计划 ###\uF0D8 13 年带领事业部团队完成 10 亿大关，较 12 年同期增长 23%，达成年度目标 105%;完成 2014###年度业绩较 13 年同期成长 7%，达成年度目标 90% ###\uF0D8 连续两年事业部整体净利润高达 1.5 亿多（是集团净利润率第一的事业部） ###\uF0D8 丰富 2014 开心品类：OEM 主流品类、炒货坚果类、豆干类、蜜饯、果蔬类、烘培类，创新集###团散装现有产品，完善开心散装 10 年以来的品类大扩建行动 ###\uF0D8 全国 KA 系统管理：华东、华中大润发合作谈判+沃尔玛系统年度合作模式谈判+苏果直营系统###合作模式转变谈判+欧尚全国合作谈判(系统门店导购、陈列、资源、促销管理)统筹制定 2014###年 KA 系统制高点行动 （打造优质单点） ";
//        Pattern patternT = Pattern.compile("(#)+(([^\\s:：#\ufeff\\r\\n])+[\u4e00-\u9fa5]+)(#|$|\\s|\\|)");
//        Matcher matcherT = patternT.matcher(lineT);
//        if (matcherT.find()) {
//            System.out.println(matcherT.groupCount());
//            System.out.println(matcherT.group(2));
//        }
//
//        String city = "北京|天津|福建|成都";
//        String timeLineLeftStr = "蜡笔小新（福建）食品工业有限公司";
//        String timeLineLeftStrRegex = "([\\(（]\\s*(中国|" + city + ")\\s*[\\)）])";
//        Pattern timeLineLeftStrPattern = Pattern.compile(timeLineLeftStrRegex);
//        Matcher timeLineLeftStrMatcher = timeLineLeftStrPattern.matcher(timeLineLeftStr);
//        if (timeLineLeftStrMatcher.find()) {
//            timeLineLeftStr = timeLineLeftStr.replaceAll(timeLineLeftStrRegex,timeLineLeftStrMatcher.group(1).replaceAll("\\p{P}",""));
//        }
//        System.out.println(timeLineLeftStr);
//
//        String punctuationStr = "cnasi2.z,cmei;[(NC（。从不拿开";
//        Pattern punctuationPattern = Pattern.compile("\\p{P}");
//        Matcher punctuationMatcher = punctuationPattern.matcher(punctuationStr);
//        int count = 0;
//        while (punctuationMatcher.find()) {
//            count++;
//        }
//        System.out.println(count);
//
//
//        String endTime = "2006";
//        String companyName = "\\，通过带领和管理各级销售队伍，取得了良好的市场表现和销售指标的高度达成，业绩突出。";
//        companyName = companyName.replaceAll("\\\\", "\\\\\\\\");
//        System.out.println(companyName);
//        String lineBug = "###(2003－2006)，通过带领和管理各级销售队伍，取得了良好的市场表现和销售指标的高度达成，业绩突出。 ###\uF0D8 陕西：前期陕西为公海市场，推动百事可乐在陕西市场的业务发展，全面负责 KA渠道及 TT传统渠道；建###立各区域市场经销商管理体系。 ###\uF0D8 四川：当时百事可乐在四川经历 10年多的高速发展后，成都地区业务量较大，导致市场增长率、市场秩序###管理、价格体系等矛盾凸显；我接手后进行营销体系改革，精细过程化管理；在成都市场亲自领导和运作###了 WAT积极销售系统，包括超市、重售、特渠、餐饮、夜店及 TT食杂等全渠道售点网络。 ###工作成果 Achievements ###\uF0D8 陕西市场：陕西地区当时市场竞争对手为可口可乐。前期可口可乐在商超市场一家独大，百事可乐市场占###比为 0，后期上升为两乐在现代渠道 30:70市场份额，传统渠道百事从 0上升至占有率 20%；百事系统内部###竞争伙伴为上海百事、北京百事等，四川百事在陕西市场从可以忽略不计发展到上海百事、北京百事先后###退出市场，四川百事独挑大梁。 ###\uF0D8 西安地区建厂：在西安运营三年，由于陕西地区销售量增长迅猛，达到建厂标准，西安百事开始建厂。 ###\uF0D8 成都市场：重组团队架构，恢复价格体系，从前期业绩无法完成，半年后变成了良性发展，业绩稳定，从###前期的 60-70%左右提高到持续 100%以上。 ###\uF0D8 改革营销体系：亲自领导运作 WAT系统，发展 WAT客户 52家，餐饮夜店配送商 27家，郊区配送商 37家，###传统批发商 450余家，当时覆盖终端 20000余家。 ###\uF0D8 市场占有率：成功阻击了竞争对手几次大规模“红海计划”；当时所负责百事可乐在成都地区占有率 80%###以上。 ";
//        Pattern patternBug = Pattern.compile("(" + endTime + ")(\\s|\\||#)*"+companyRex+"(\\s|#)*" + companyName);
//        Matcher matcherBug = patternBug.matcher(lineBug);
//        if (matcherBug.find()) {
//            //如果在工作时间和公司名之间获取到句子 则表明该短句为职位
//            String positionBug = matcherBug.group(3);
//            System.out.println(positionBug);
//        }
//
//
//        String regGroupTest = ".*((你的)+(\\s+a)(人生)?)+([\u4e00-\u9fa5a-z]+)(\\d)?.*";    //提取字符串末尾的数字：封妖塔守卫71 == >> 71
//        String stringGroupTest = "vsv你的         a人生ab9";
//        Pattern patternGroupTest = Pattern.compile(regGroupTest);
//        Matcher matcherGroupTest = patternGroupTest.matcher(stringGroupTest);
//        if(matcherGroupTest.find()){
//            System.out.println(matcherGroupTest.groupCount());
//            System.out.println(matcherGroupTest.group(2));  // 组提取字符串
//        }
//
//
//        String positionCompany = "2017 年 -‐ 至今      西安交通大学研究生院       外聘专家 ";
//        Pattern patternCompany = Pattern.compile("(今)(\\s|#|\\|)*(([\u4e00-\u9fa5a-z0-9])+)(\\s|#|\\||[^\u4e00-\u9fa5a-z0-9])", Pattern.CASE_INSENSITIVE);
//        Matcher matcherCompany = patternCompany.matcher(positionCompany);
//        if (matcherCompany.find()) {
//            System.out.println(matcherCompany.group(3));
//        }
//
//        String positionString = "ancjscb公司 京东jd ivla";
//        Pattern patternPosition = Pattern.compile("(公\\s*司|企\\s*业|公\\s*司\\s*全\\s*称)\\s*(:|：)\\s*(([\u4e00-\u9fa5]|[a-z0-9])+)($|#|\\s|\\(|（)", Pattern.CASE_INSENSITIVE);
//        Matcher matcherPosition = patternPosition.matcher(positionString);
//        if (matcherPosition.find()) {
//            System.out.println(matcherPosition.group(3));
//        }
//
//        System.out.println("今".compareTo("2016年"));
//
//        String workExperience = "2017 年 -‐ 至今      西安交通大学研究生院       外聘专家 ";
//        Pattern patternData = Pattern.compile("(^|[^\u4e00-\u9fa5a\\*])(((19[89]|20[012])[0-9]\\s*(年|/|[\\.]|．|-)?)(\\s*\\d+\\s*(月|/|[\\.]|．|-)?)?(\\s*\\d+(\\s*日)?)?)\\s*(.){0,6}\\s*((((19[89]|20[012])[0-9]\\s*(年|/|[\\.]|．|-)?)(\\s*\\d+\\s*(月|/|[\\.]|．|-)?)?(\\s*\\d+(\\s*日)?)?)|至\\s*今|现\\s*在|\\s*今|当\\s*前)($|[^\u4e00-\u9fa5a])");
//        Matcher matcherData = patternData.matcher(workExperience);
//        if (matcherData.find()) {
//            System.out.println(matcherData.groupCount());
//            System.out.println(matcherData.group(2));
//            System.out.println(matcherData.group(11));
//        }
//
//        String trimLine = "李明宇，34 岁，电话/微信：15011316343，Email：li.mingyu@ostorage.com.cn";
//        Pattern patternTrimLine = Pattern.compile("([\u4e00-\u9fa5]+)($|\\s|：|:|\\||[^\u4e00-\u9fa5]*)");
//        Matcher matcherTrimLine = patternTrimLine.matcher(trimLine);
//        if (matcherTrimLine.find()) {
//            System.out.println(matcherTrimLine.groupCount());
//            System.out.println(matcherTrimLine.group(1));
//        }
//
//        String string = "美的-丽丽@im.waiter@158@10";
//        string = string.replaceAll("@.*", "");
//        System.out.println(string);
//
//        String sentence = "亲放心购买哦，京东保价30天，支持买贵补差 哦，早买早享受哦";
//        String regex = "((?![\\u4e00-\\u9fa5]+).)+";
//        String result = sentence.replaceAll(regex, "");
//        System.out.println(result);
//
//        String line = "(demonstrative)(keywords)(question)";
//        String reg = "(?<=\\()(\\w+)(?=\\))";
//        Pattern pattern = Pattern.compile(reg);
//        Matcher matcher = pattern.matcher(line);
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
////            System.out.println(matcher.group(2));
//        }
//
//        String regNum = "\\D+(\\d+)$";    //提取字符串末尾的数字：封妖塔守卫71 == >> 71
//        String s = "路何方ljm: 顾客 路何方ljm 加入咨询 商品11111编号：1293744";
//        Pattern p2 = Pattern.compile(regNum);
//        Matcher m2 = p2.matcher(s);
//        if(m2.find()){
//            System.out.println(m2.groupCount());
//            System.out.println(m2.group(1));  // 组提取字符串
//        }
//
//        String str = "y@jd.com";
//        System.out.println(isMatch(str));
    }

    private static void findAll(String regex, String str, int groupIndex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            System.out.println(matcher.group(groupIndex));
        }
    }

    private static boolean isMatch(String str) {

        String regex = "^\\d?[a-zA-Z0-9]@[a-zA-Z]{1,10}.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        boolean re = matcher.matches();

        return re;
    }
}
