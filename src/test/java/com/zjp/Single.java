package com.zjp;

/**
 * 单例模式最优方案：优化后的懒汉式 * 线程安全 并且效率高
 *
 * @Author: zhujunpeng
 * @Date: 2018/11/24 14:24
 * @Version 1.0
 */
public class Single {

    // 定义一个私有构造方法
    private Single() {
    }

    // 定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时single变量的可见性，避免了single初始化时其他变量属性还没赋值完时，被另外线程调用)
    private static volatile Single single;

    // 定义一个共有的静态方法，返回该类型实例
    public static Single getInstance() {
        // 对象实例化时与否判断（不使用同步代码块，single不等于null时，直接返回对象，提高运行效率）
        if (single == null) {
            // 同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
            synchronized (Single.class) {
                // 未初始化，则初始single变量
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }
}
