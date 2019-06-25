package my.cloud.singleton;

import java.io.Serializable;

/**
 * 双重锁检查方式
 */
public class DclSingleton implements Serializable {

    private static DclSingleton dclSingleton = null;

    /**
     * 抛出此异常，保证无法通过反射获取新的实例
     */
    private DclSingleton() {
        if (null != dclSingleton) {
            throw new RuntimeException("无法构造");
        }
    }

    /**
     * 初始化加双重锁，保证只new一个实例
     * @return
     */
    public static DclSingleton getInstance() {
        if (null == dclSingleton) {
            synchronized (DclSingleton.class) {
                if (null == dclSingleton) {
                    dclSingleton = new DclSingleton();
                }
            }
        }
        return dclSingleton;
    }

    /**
     * 重写此方法，保证反序列化时单例
     * @return
     */
    protected Object readResolve() {
        return dclSingleton;
    }
}
