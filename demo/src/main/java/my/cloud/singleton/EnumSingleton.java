package my.cloud.singleton;

/**
 * 枚举单例
 * 通过反编译可知：
 * 1、类加载时在static块中初始化，所以是饿汉式加载方式
 * 2、
 */
public enum  EnumSingleton {

    INSTANCE

}
