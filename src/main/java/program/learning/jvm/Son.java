package program.learning.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

import static java.lang.invoke.MethodHandles.lookup;

public class Son extends Father {

    void thinking() {
// 请读者在这里填入适当的代码（不能修改其他地方的代码）
// 实现调用祖父类的thinking()方法，打印"i am grandfather"
        try {
//            MethodType mt1 = MethodType.methodType(void.class);
//            MethodHandle mh1 = lookup().findSpecial(GrandFather.class,
//                    "thinking", mt1, getClass());
//            mh1.invoke(this);

            MethodType mt2 = MethodType.methodType(void.class);
            Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            lookupImpl.setAccessible(true);
            MethodHandle mh2 = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class,"thinking", mt2, getClass());
            mh2.invoke(this);
        } catch (Throwable e) {
        }
    }

    public static void main(String[] args) {
        new Son().thinking();
    }
}