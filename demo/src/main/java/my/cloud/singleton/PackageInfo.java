package my.cloud.singleton;

/**
 * 单例模式（如果没有特别需求，一般保证线程安全即可）
 * 1、线程间单例
 * 2、反射时单例
 * 3、序列化、反序列化时单例
 *
 * 分别对应下述问题：
 *
 * 1、你的单例线程安全吗?
 * 2、你的单例反射安全吗？
 * 3、你的单例序列化安全吗？
 */