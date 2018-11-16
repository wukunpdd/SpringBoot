package cn.wukun.web;

import cn.wukun.dao.UserExtDao;
import cn.wukun.domain.UserExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userExt")
public class UserExtController {

    @Autowired
    private UserExtDao userExtDao;

    @RequestMapping("/add")
    public int add(){
        UserExt userExt = new UserExt();
        userExt.setExtName("王尼玛");
        userExt.setExtAge(45);
        return userExtDao.add(userExt);
    }

    @RequestMapping("/update")
    public int update(){
        UserExt userExt = new UserExt();
        userExt.setExtName("曹操");
        userExt.setExtAge(1024);
        userExt.setExtId(4);
        return userExtDao.update(userExt);
    }

    @RequestMapping("/delete")
    public int delete(){
        return userExtDao.delete(2);
    }

    @RequestMapping("/findOne")
    public UserExt findOne(){
        return userExtDao.findUserExtByExtId(4);
    }

    @RequestMapping("/findList")
    public List<UserExt> findList(){
        return userExtDao.findUserExtList();
    }
}
