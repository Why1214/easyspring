package org.easyspring.beans;

/**
 * <p>
 * bean的定义
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/3 8:46
 */
public interface BeanDefinition {

    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    boolean isSingleton();

    boolean isPrototype();

    String getScope();

    void setScope(String scope);

    /**
     * 获取bean的全限定类名
     *
     * @return 返回
     */
    String getBeanClassName();


}
