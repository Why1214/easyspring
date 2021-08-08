package org.easyspring.test.v1;

import org.easyspring.context.ApplicationContext;
import org.easyspring.context.support.ClassPathXmlApplicationContext;
import org.easyspring.context.support.FileSystemXmlApplicationContext;
import org.easyspring.service.v1.PhoneService;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * ApplicationContext 相关测试用例
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/16 21:15
 */
public class ApplicationContextTest {

    @Test
    public void testGetBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("phone-v1.xml");
        PhoneService phoneService = (PhoneService) context.getBean("phoneService");
        Assert.assertNotNull(phoneService);
    }

    @Test
    public void testGetBeanFromSystemContext() {
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\code\\easyspring\\src\\test\\resources\\phone-v1.xml");
        PhoneService phoneService = (PhoneService) context.getBean("phoneService");
        Assert.assertNotNull(phoneService);
    }
}
