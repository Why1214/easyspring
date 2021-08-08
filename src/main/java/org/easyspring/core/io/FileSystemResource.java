package org.easyspring.core.io;

import org.easyspring.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 文件系统相关的处理类
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/17 20:57
 */
public class FileSystemResource implements Resource {

    private final String path;
    private final File file;

    public FileSystemResource(String path) {
        Assert.notNull(path, "Path must be not null");
        this.path = path;
        this.file = new File(this.path);
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public String getDescription() {
        return "file [" + this.file.getAbsolutePath() + "]";
    }
}
