package org.easyspring.util;

/**
 * <p>
 * 断言工具
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/17 21:06
 */
public abstract class Assert {

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
