package org.easyspring.factory;

import org.easyspring.beans.BeansException;

/**
 * <p>
 * 解析XML出错时的异常
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/6 22:02
 */
public class BeanDefinitionStoreException extends BeansException {

    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }

}
