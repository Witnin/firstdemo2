package com.wsy.firstdemo.config;

import ch.qos.logback.core.db.DBHelper;
import com.wsy.firstdemo.bean.Pet;
import com.wsy.firstdemo.bean.TestUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({TestUser.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean
    public TestUser user01(){
        TestUser zhansan = new TestUser();
        zhansan.setName("张三");
        zhansan.setPet(tomcatPet());
        return zhansan;
    }
    @Bean("cat")
    public Pet tomcatPet(){
        Pet pet = new Pet();
        pet.setAge(18);
        pet.setName("cat");

        return pet;
    }

//    @Bean("cat2")
//    public Pet tomcatPet2(){
//        return  new Pet("78",15);
//    }


}
