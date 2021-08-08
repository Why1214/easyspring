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

    private boolean singleton = true;
    private boolean prototype = false;
    private String scope = SCOPE_DEFAULT;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    public boolean isSingleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public String getBeanClassName() {
        return this.beanClassName;
    }
}
