/**
 * @author: Hengo
 * @date: 2018/6/23 13:42
 */
public class Singleton {

    /**
     * 懒汉模式
     * 线程不安全: 因为类刚刚初始化时，instance对象还是null,
     * 如果两个线程同时访问getInstance方法，这样进行了两次new操作
     */
    public static class Singleton1 {

        private Singleton1() {
        }

        private static Singleton1 instance = null;

        public static Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    /**
     * 懒汉模式(改进1) 线程安全
     * 此改进方法存在缺陷, 涉及到JVM编译器的指令重排。
     * 线程A的instance对象有可能还未完成初始化, 但已经不指向null, 线程B执行if(instance == null)的结果会是false
     * 从而返回一个没有初始化完成的instance对象
     */

    public static class Singleton2 {

        private Singleton2() {
        }

        private static Singleton2 instance = null;

        public static Singleton2 getInstance() {
            // 双重检测机制
            if (instance == null) {
                // 同步锁
                synchronized (Singleton2.class) {
                    // 双重检测机制
                    if (instance == null) {
                        instance = new Singleton2();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 懒汉模式(改进3) 线程安全
     * 在改进2的基础上, 在单例对象上增加了一个 volatile 修饰
     * 作用是阻止了变量访问前后的指令重排，保证了指令的执行顺序
     */
    public static class Singleton3 {
        private Singleton3() {
        }

        private volatile static Singleton3 instance = null;

        public static Singleton3 getInstance() {
            if (instance == null) {
                synchronized (Singleton3.class) {
                    if (instance == null) {
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 静态内部类实现单例模式 线程安全
     * INSTANCE 对象初始化的时机并不是在单例类被加载的时候，而是在被调用 getInstance 的时候
     * 此方法时利用 classLoader 的加载机制来实现懒加载
     */
    public static class Singleton4 {
        // 静态内部类
        private static class LazyHolder {
            private static final Singleton4 INSTANCE = new Singleton4();
        }

        private Singleton4() {
        }

        public static Singleton4 getInstance() {
            return LazyHolder.INSTANCE;
        }
    }

    /**
     * 推荐使用枚举 参考《Effective Java》一书
     * 绝对防止多次实例化，即使面对复杂的序列化或者反射攻击的时候，防止反射构造对象
     * 缺点是没有使用懒加载
     * 单元素的枚举类型已经成为实现Singleton的最佳方法
     * 调用对象: SingletonEnum.INSTANCE;
     */
    public enum SingletonEnum {
        INSTANCE;
    }

}
