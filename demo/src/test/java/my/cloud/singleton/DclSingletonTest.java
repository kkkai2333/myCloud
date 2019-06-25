package my.cloud.singleton;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;

public class DclSingletonTest {


    /**
     * 线程安全
     */
    @Test
    public void test() {
        DclSingleton DclSingleton1 = DclSingleton.getInstance();
        DclSingleton DclSingleton2 = DclSingleton.getInstance();
        System.out.println(DclSingleton1.hashCode());
        System.out.println(DclSingleton2.hashCode());
    }

    /**
     * 反射不安全，通过反射，可以获取另一个实例。
     * 解决方案：修改构造函数，当默认实例不为空时，构造函数直接抛异常
     */
    @Test
    public void test2() {
        DclSingleton DclSingleton1 = DclSingleton.getInstance();
        Class<DclSingleton> clazz = DclSingleton.class;
        try {
            Constructor<DclSingleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            DclSingleton DclSingleton2 = constructor.newInstance();

            System.out.println(DclSingleton1.hashCode());
            System.out.println(DclSingleton2.hashCode());
        }catch (Exception e) {
            e.printStackTrace();
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
            DclSingleton DclSingleton1 = DclSingleton.getInstance();
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream("hungryDemo.ser"));
            output.writeObject(DclSingleton1);
            output.close();
            // 反序列化

            ObjectInput input = new ObjectInputStream(new FileInputStream("hungryDemo.ser"));
            DclSingleton DclSingleton2 = (DclSingleton)input.readObject();
            input.close();

            System.out.println(DclSingleton1.hashCode());
            System.out.println(DclSingleton2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

}
