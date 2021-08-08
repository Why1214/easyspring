package org.easyspring.beans.factory.support;

import org.easyspring.beans.BeanDefinition;

/**
 * BeanDefinition 处理类
 */
public interface BeanDefinitionRegistry {

    /**
     * 根据beanId获取bean的定义
     *
     * @param beanId bean标识
     * @return 返回bean的定义
     */
    BeanDefinition getBeanDefinition(String beanId);

    /**
     * 注册 bean的定义
     *
     * @param beanId bean标识
     * @param bd     bean的定义
     */
    void registerBeanDefinition(String beanId, BeanDefinition bd);
}
