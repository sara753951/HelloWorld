package program.learning;

/**
 * Created by yanxinming on 2020/1/19
 */
public enum SecondDeptEnum {
    RW("冰洗"),
    KT("厨卫"),
    CH("厨房"),
    LL("生活"),
    BEF("黑电(平板)"),
    PC("个护"),
    AC("空调"),
    HY("健康"),
    BEV("黑电(影音)");

    private final String secondDept;
    SecondDeptEnum(String secondDept) {
        this.secondDept = secondDept;
    }
    public String value() {return secondDept;}
}
