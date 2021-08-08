package org.easyspring.beans.factory;

import org.easyspring.beans.BeansException;

/**
 * <p>
 * 创建bean出错时的异常
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/6 22:02
 */
public class BeanCreationException extends BeansException {

    private String beanName;

    public BeanCreationException(String message) {
        super(message);
    }

    public BeanCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanCreationException(String beanName, String message) {
        super("Error creating bean with name '" + beanName + "': " + message);
        this.beanName = beanName;
    }

    public BeanCreationException(String beanName, String message, Throwable cause) {
        this(beanName, message);
        initCause(cause);
    }

    public String getBeanName() {
        return this.beanName;
    }
}
