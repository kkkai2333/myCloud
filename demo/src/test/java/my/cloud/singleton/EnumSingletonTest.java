package my.cloud.singleton;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;

public class EnumSingletonTest {


    /**
     * 线程安全
     */
    @Test
    public void test() {
        EnumSingleton EnumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton EnumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println(EnumSingleton1.hashCode());
        System.out.println(EnumSingleton2.hashCode());
    }

    /**
     * 反射安全,
     * enum禁止通过反射创建对象
     */
    @Test
    public void test2() {
        EnumSingleton EnumSingleton1 = EnumSingleton.INSTANCE;
        Class<EnumSingleton> clazz = EnumSingleton.class;
        try {
            Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            EnumSingleton EnumSingleton2 = constructor.newInstance();

            System.out.println(EnumSingleton1.hashCode());
            System.out.println(EnumSingleton2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

    /**
     * 序列化安全
     */
    @Test
    public void test3() {
        try {
            // 序列化
            EnumSingleton EnumSingleton1 = EnumSingleton.INSTANCE;
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream("hungryDemo.ser"));
            output.writeObject(EnumSingleton1);
            output.close();
            // 反序列化

            ObjectInput input = new ObjectInputStream(new FileInputStream("hungryDemo.ser"));
            EnumSingleton EnumSingleton2 = (EnumSingleton)input.readObject();
            input.close();

            System.out.println(EnumSingleton1.hashCode());
            System.out.println(EnumSingleton2.hashCode());
        } catch (Exception e) {
            System.out.println("error");
        }
    }

}
