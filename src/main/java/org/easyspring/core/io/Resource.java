package org.easyspring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源文件相关的接口
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

    String getDescription();
}
