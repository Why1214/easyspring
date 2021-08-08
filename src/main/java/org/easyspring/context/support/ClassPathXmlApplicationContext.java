package org.easyspring.context.support;

import org.easyspring.core.io.ClassPathResource;
import org.easyspring.core.io.Resource;

/**
 * <p>
 * xml的ApplicationContext实现
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/16 21:22
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path, this.getBeanClassLoader());
    }
}
