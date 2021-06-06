package org.easyspring.factory.support;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.easyspring.beans.BeanDefinition;
import org.easyspring.factory.BeanCreationException;
import org.easyspring.factory.BeanDefinitionStoreException;
import org.easyspring.factory.BeanFactory;
import org.easyspring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * bean工厂默认实现
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/2 21:59
 */
public class DefaultBeanFactory implements BeanFactory {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);

    public DefaultBeanFactory(String configFile) {
        loadBeanDefinition(configFile);
    }

    private void loadBeanDefinition(String configFile) {
        InputStream is = null;

        try {
            ClassLoader cl = ClassUtils.getDefaultClassLoader();
            is = cl.getResourceAsStream(configFile);
            SAXReader reader = new SAXReader();

            Document doc = reader.read(is);
            Element root = doc.getRootElement(); // <beans>
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next(); // <bean>
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                this.beanDefinitionMap.put(id, bd);
            }
        } catch (Exception ex) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from ", ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    public Object getBean(String beanId) {
        BeanDefinition bd = this.getBeanDefinition(beanId);
        if (bd == null) {
            throw new BeanCreationException("Bean Definition does not exist");
        }

        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();

        try {
            Class<?> clz = cl.loadClass(beanClassName); //默认存在无参的构造函数
            return clz.newInstance();
        } catch (Exception ex) {
            throw new BeanCreationException("create bean for " + beanClassName + "failed", ex);
        }
    }
}
