package org.easyspring.test.v1;

import org.easyspring.beans.BeanDefinition;
import org.easyspring.factory.BeanCreationException;
import org.easyspring.factory.BeanDefinitionStoreException;
import org.easyspring.factory.BeanFactory;
import org.easyspring.factory.support.DefaultBeanFactory;
import org.easyspring.service.v1.PhoneService;
import org.junit.Assert;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new DefaultBeanFactory("phone-v1.xml");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("phoneService");

        Assert.assertEquals("org.easyspring.service.v1.PhoneService", beanDefinition.getBeanClassName());

        PhoneService phoneService = (PhoneService) beanFactory.getBean("phoneService");

        Assert.assertNotNull(phoneService);
    }

    @Test
    public void testInvalidBean() {
        BeanFactory factory = new DefaultBeanFactory("phone-v1.xml");
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException ex) {
            return;
        }

        Assert.fail("expect BeanCreationException");
    }

    @Test
    public void testInvalidXML() {

        try {
            new DefaultBeanFactory("invalidXML.xml");
        } catch (BeanDefinitionStoreException ex) {
            return;
        }

        Assert.fail("expect BeanDefinitionStoreException");
    }
}
