package com.wsy.firstdemo;

import ch.qos.logback.core.db.DBHelper;
import com.wsy.firstdemo.bean.Pet;
import com.wsy.firstdemo.bean.TestUser;
import com.wsy.firstdemo.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 *
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 *
 */


@SpringBootApplication
public class FirstdemoApplication {

    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(FirstdemoApplication.class, args);
        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println(name);

        }

        //3、从容器中获取组件

        Pet tom01 = run.getBean("cat", Pet.class);

        Pet tom02 = run.getBean("cat", Pet.class);

        System.out.println("组件："+(tom01 == tom02));


        //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        TestUser user = bean.user01();
        TestUser user1 = bean.user01();
        System.out.println(user == user1);

        TestUser user2 = run.getBean("user01",TestUser.class);
        Pet cat = run.getBean("cat",Pet.class);
        System.out.println("用户的宠物"+(user2.getPet()==cat));


        String[] beanNamesForType = run.getBeanNamesForType(TestUser.class);
        System.out.println("===========");
        for(String s :beanNamesForType){
            System.out.println(s);
        }

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);

    }

}
