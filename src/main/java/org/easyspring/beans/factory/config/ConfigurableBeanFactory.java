package org.easyspring.beans.factory.config;

import org.easyspring.beans.factory.BeanFactory;

/**
 * <p>
 * 可配置的BeanFactory：
 * 设置ClassLoader
 * </p>
 *
 * @author Lenovo
 * @since 2021/8/8 15:02
 */
public interface ConfigurableBeanFactory extends BeanFactory {

    void setBeanClassLoader(ClassLoader classLoader);

    ClassLoader getBeanClassLoader();
}
