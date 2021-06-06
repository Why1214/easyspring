package org.easyspring.util;

/**
 * <p>
 * 类加载器相关的工具类
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/6 21:22
 */
public abstract class ClassUtils {

    /**
     * 获取一个默认的类加载器
     *
     * @return 返回类加载器
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }

        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
            if (cl == null) {
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable ex) {

                }
            }
        }

        return cl;
    }
}
