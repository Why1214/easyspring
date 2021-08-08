package org.easyspring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.easyspring.beans.BeanDefinition;
import org.easyspring.beans.factory.BeanDefinitionStoreException;
import org.easyspring.beans.factory.support.BeanDefinitionRegistry;
import org.easyspring.beans.factory.support.GenericBeanDefinition;
import org.easyspring.core.io.Resource;
import org.easyspring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * <p>
 * xml解析类
 * </p>
 *
 * @author Lenovo
 * @since 2021/6/16 20:41
 */
public class XmlBeanDefinitionReader {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String SCOPE_ATTRIBUTE = "scope";

    private BeanDefinitionRegistry registry = null;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinition(Resource resource) {
        InputStream is = null;

        try {
            ClassLoader cl = ClassUtils.getDefaultClassLoader();
            is = resource.getInputStream();
            SAXReader reader = new SAXReader();

            Document doc = reader.read(is);
            Element root = doc.getRootElement(); // <beans>
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next(); // <bean>
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                if (ele.attribute(SCOPE_ATTRIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }
                this.registry.registerBeanDefinition(id, bd);
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
}
