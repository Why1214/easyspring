package org.easyspring.beans.factory.support;

import org.easyspring.beans.BeanDefinition;

/**
 * <p>
 * bean定义的实现
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/6 21:07
 */
public class GenericBeanDefinition implements BeanDefinition {

    /**
     * bean属性id
     */
    private String id;

    /**
     * bean属性class
     */
    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    public String getBeanClassName() {
        return this.beanClassName;
    }
}
