package org.easyspring.beans;

/**
 * <p>
 * bean相关异常
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/6 22:00
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
