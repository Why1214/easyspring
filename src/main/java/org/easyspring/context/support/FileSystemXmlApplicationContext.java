package org.easyspring.context.support;

import org.easyspring.core.io.FileSystemResource;
import org.easyspring.core.io.Resource;

/**
 * <p>
 * xml的ApplicationContext实现
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/17 21:28
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String path) {
        super(path);
    }

    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
