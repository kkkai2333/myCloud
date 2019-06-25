package my.cloud.singleton;

import java.io.Serializable;

/**
 * 静态内部类方式
 */
public class StaticInnerSingleton implements Serializable {

    private StaticInnerSingleton() {
    }

    public static StaticInnerSingleton getInstance() {
        return StaticInnerSingletonHolder.staticInnerSingleton;
    }

    private static class StaticInnerSingletonHolder {
        private static StaticInnerSingleton staticInnerSingleton = new StaticInnerSingleton();
    }

    /**
     * 重写此方法，保证反序列化时单例
     * @return
     */
    protected Object readResolve() {
        return StaticInnerSingletonHolder.staticInnerSingleton;
    }
}
