package my.cloud.singleton;

import java.io.Serializable;

/**
 * 饿汉式
 */
public class HungrySingleton implements Serializable {

    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton() {
        if (null == HUNGRY_SINGLETON) {

        }
    }

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }

    protected Object readResolve() {
        return HUNGRY_SINGLETON;
    }


}
