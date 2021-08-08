# easyspring

### 01-BeanFactory

1. BeanFactory如何解析xml文件中的 bean 标签，并将其转化为 BeanDefinition 对象？
2. 如何通过 bean 标签的 id 属性获取 BeanDefinition？
3. 如何通过 bean 标签的 id 属性获取到真正的 bean 对象？

### 02-BeanFactory

1. BeanFactory 和 BeanDefinition 应该作为内部的实现，不应该暴露给调用者，如何实现？
2. 为了遵循类的单一职责原则，BeanFactory只需要负责获取bean的对象即可，BeanDefinition 的相关操作交给 BeanDefinitionRegistry
3. 解析 xml 的实现可以交给 XmlBeanDefinitionReader
4. ApplicationContext又是如何实现的呢？
5. 可以使用 @Before 注解将测试用例重复的代码提取
6. spring框架读取xml文件时，既可以读取classpath下的文件，也可以读取fileSystem下的文件，因此引入了Resource
7. Resource有两个不同的实现：ClassPathResource 和 FileSystemResource
8. AbstractApplicationContext, ClassPathXmlApplicationContext, FileSystemXmlApplicationContext
9. bean标签中的scope属性有两个值：singleton，prototype；针对这两个值如何实现单例或者多对象？


