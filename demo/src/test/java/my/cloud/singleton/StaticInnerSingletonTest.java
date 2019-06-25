package my.cloud.singleton;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;

public class StaticInnerSingletonTest {


    /**
     * 线程安全
     */
    @Test
    public void test() {
        StaticInnerSingleton StaticInnerSingleton1 = StaticInnerSingleton.getInstance();
        StaticInnerSingleton StaticInnerSingleton2 = StaticInnerSingleton.getInstance();
        System.out.println(StaticInnerSingleton1.hashCode());
        System.out.println(StaticInnerSingleton2.hashCode());
    }

    /**
     * 反射不安全，通过反射，可以获取另一个实例。
     * 解决方案：修改构造函数，当默认实例不为空时，构造函数直接抛异常
     */
    @Test
    public void test2() {
        StaticInnerSingleton StaticInnerSingleton1 = StaticInnerSingleton.getInstance();
        Class<StaticInnerSingleton> clazz = StaticInnerSingleton.class;
        try {
            Constructor<StaticInnerSingleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            StaticInnerSingleton StaticInnerSingleton2 = constructor.newInstance();

            System.out.println(StaticInnerSingleton1.hashCode());
            System.out.println(StaticInnerSingleton2.hashCode());
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    /**
     * 序列化不安全，序列化、反序列化时，可以获取到其他实例
     * 解决方案：重写反序列化调用的readResolve()方法
     */
    @Test
    public void test3() {
        try {
            // 序列化
            StaticInnerSingleton StaticInnerSingleton1 = StaticInnerSingleton.getInstance();
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream("hungryDemo.ser"));
            output.writeObject(StaticInnerSingleton1);
            output.close();
            // 反序列化

            ObjectInput input = new ObjectInputStream(new FileInputStream("hungryDemo.ser"));
            StaticInnerSingleton StaticInnerSingleton2 = (StaticInnerSingleton)input.readObject();
            input.close();

            System.out.println(StaticInnerSingleton1.hashCode());
            System.out.println(StaticInnerSingleton2.hashCode());
        } catch (Exception e) {
            System.out.println("error");
        }
    }

}
