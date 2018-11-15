package cn.wukun.web;

import cn.wukun.config.Teacher;
import cn.wukun.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({User.class, Teacher.class})
public class HelloController {

    @Value("${wukun.age}")
    private Integer age;
    @Value("${wukun.birthday}")
    private String birthday;
    @Value("${wukun.city}")
    private String city;

    @Autowired
    private User user;
    @Autowired
    private Teacher teacher;

    @RequestMapping("/hello")
    public String hello(){
        return "wukun = { age: " + age +", birthday: " + birthday + ", city: " + city + " }";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        return user;
    }

    @RequestMapping("/getTeacher")
    public Teacher getTeacher(){
        return teacher;
    }
}
