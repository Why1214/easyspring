package org.easyspring.test.v1;

import org.easyspring.beans.BeanDefinition;
import org.easyspring.beans.factory.BeanCreationException;
import org.easyspring.beans.factory.BeanDefinitionStoreException;
import org.easyspring.beans.factory.support.DefaultBeanFactory;
import org.easyspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.easyspring.core.io.ClassPathResource;
import org.easyspring.service.v1.ComputerService;
import org.easyspring.service.v1.PhoneService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeanFactoryTest {

    DefaultBeanFactory beanFactory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp() {
        beanFactory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(beanFactory);
    }

    @Test
    public void testGetBean() {
        reader.loadBeanDefinition(new ClassPathResource("phone-v1.xml"));

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("phoneService");

        Assert.assertTrue(beanDefinition.isSingleton());

        Assert.assertFalse(beanDefinition.isPrototype());

        Assert.assertEquals(BeanDefinition.SCOPE_DEFAULT, beanDefinition.getScope());

        Assert.assertEquals("org.easyspring.service.v1.PhoneService", beanDefinition.getBeanClassName());

        PhoneService phoneService = (PhoneService) beanFactory.getBean("phoneService");

        Assert.assertNotNull(phoneService);

        PhoneService phoneService2 = (PhoneService) beanFactory.getBean("phoneService");

        Assert.assertTrue(phoneService.equals(phoneService2));
    }

    @Test
    public void testGetPrototypeBean() {
        reader.loadBeanDefinition(new ClassPathResource("phone-v1.xml"));

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("computerService");

        Assert.assertFalse(beanDefinition.isSingleton());

        Assert.assertTrue(beanDefinition.isPrototype());

        Assert.assertEquals(BeanDefinition.SCOPE_PROTOTYPE, beanDefinition.getScope());

        Assert.assertEquals("org.easyspring.service.v1.ComputerService", beanDefinition.getBeanClassName());

        ComputerService computerService = (ComputerService) beanFactory.getBean("computerService");

        Assert.assertNotNull(computerService);

        ComputerService computerService2 = (ComputerService) beanFactory.getBean("computerService");

        Assert.assertFalse(computerService.equals(computerService2));
    }

    @Test
    public void testInvalidBean() {
        reader.loadBeanDefinition(new ClassPathResource("phone-v1.xml"));
        try {
            beanFactory.getBean("invalidBean");
        } catch (BeanCreationException ex) {
            return;
        }

        Assert.fail("expect BeanCreationException");
    }

    @Test
    public void testInvalidXML() {
        try {
            reader.loadBeanDefinition(new ClassPathResource("invalidXML.xml"));
        } catch (BeanDefinitionStoreException ex) {
            return;
        }

        Assert.fail("expect BeanDefinitionStoreException");
    }
}
