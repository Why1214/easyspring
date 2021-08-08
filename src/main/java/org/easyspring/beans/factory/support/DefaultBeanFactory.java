package org.easyspring.beans.factory.support;

import org.easyspring.beans.BeanDefinition;
import org.easyspring.beans.factory.BeanCreationException;
import org.easyspring.beans.factory.config.ConfigurableBeanFactory;
import org.easyspring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * bean工厂默认实现
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/2 21:59
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry
        implements ConfigurableBeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);
    private ClassLoader beanClassLoader;

    public DefaultBeanFactory() {
    }

    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    public void registerBeanDefinition(String beanId, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanId, bd);
    }

    public Object getBean(String beanId) {
        BeanDefinition bd = this.getBeanDefinition(beanId);
        if (bd == null) {
            return null;
        }

        if (bd.isSingleton()) {
            Object bean = this.getSingleton(beanId);
            if (bean == null) {
                bean = createBean(bd);
                this.registerSingleton(beanId, bean);
            }
            return bean;
        }
        return createBean(bd);
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }

    private Object createBean(BeanDefinition bd) {

        ClassLoader cl = this.getBeanClassLoader();
        String beanClassName = bd.getBeanClassName();

        try {
            Class<?> clz = cl.loadClass(beanClassName); //默认存在无参的构造函数
            return clz.newInstance();
        } catch (Exception ex) {
            throw new BeanCreationException("create bean for " + beanClassName + "failed", ex);
        }
    }
}
