package com.meteor.demo.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created  bhy on 2020/3/12
 *  利用spring bean的生命周期注册 到spring容器中
 *   可是实现接口
 *      BeanNameAware setBeanName();
 *      BeanFactoryAware  setBeanFactory()
 *     BeforePostPecoess   beforePecoessInitialization 及afterPecoessInitalizaiton
 *     ApplicationContextAware  setAppcaltionContext
 *    InitializingBean 接口  存在 initMethod 及afterPropertiesset() 配置获取
 *
 *    DisposableBean接口 destory()
 *
 *
 *
 *
 *
 **/
public class SpringContextRegistered  implements BeanNameAware,BeanFactoryAware,BeanPostProcessor,ApplicationContextAware,InitializingBean,DisposableBean {

    @Override
    public void setBeanName(String name) {
        System.err.println("1、BeanNameAware ");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("2.BeanFactoryAware ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.err.println("4. ApplicationContextAware ");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("3. beforeInitializAtion ");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("6、afterPecoess");
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("5.InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("最后销毁");
    }
}
