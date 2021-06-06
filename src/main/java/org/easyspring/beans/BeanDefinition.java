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

    /**
     * 获取bean的全限定类名
     *
     * @return 返回
     */
    String getBeanClassName();
}
