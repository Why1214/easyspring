package org.easyspring.beans.factory.config;

/**
 * <p>
 * 单例bean注册
 * </p>
 *
 * @author Lenovo
 * @since 2021/8/8 15:42
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);
}
