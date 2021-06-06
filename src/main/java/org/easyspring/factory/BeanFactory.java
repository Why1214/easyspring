package org.easyspring.factory;

import org.easyspring.beans.BeanDefinition;

/**
 * <p>
 * bean工厂
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/2 21:57
 */
public interface BeanFactory {

    /**
     * 获取 bean 的定义
     *
     * @param beanId bean标识
     * @return 返回 bean定义
     */
    BeanDefinition getBeanDefinition(String beanId);

    /**
     * 获取 bean 对象
     *
     * @param beanId bean标识
     * @return 返回 bean对象
     */
    Object getBean(String beanId);
}
