package org.easyspring.test.v1;

import org.easyspring.core.io.ClassPathResource;
import org.easyspring.core.io.FileSystemResource;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class ResourceTest {

    @Test
    public void testClassPathResource() throws Exception {
        ClassPathResource resource = new ClassPathResource("phone-v1.xml");

        InputStream is = null;
        try {
            is = resource.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @Test
    public void testFileSystemResource() throws Exception {
        FileSystemResource resource = new FileSystemResource("D:\\code\\easyspring\\src\\test\\resources\\phone-v1.xml");

        InputStream is = null;
        try {
            is = resource.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
