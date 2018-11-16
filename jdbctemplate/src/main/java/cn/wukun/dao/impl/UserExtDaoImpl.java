package cn.wukun.dao.impl;

import cn.wukun.dao.UserExtDao;
import cn.wukun.domain.UserExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserExtDaoImpl implements UserExtDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(UserExt userExt) {
        return jdbcTemplate.update("insert into user_ext(ext_name, ext_age) values(?, ?)", userExt.getExtName(), userExt.getExtAge());
    }

    @Override
    public int update(UserExt userExt) {
        String qryHql = "update user_ext set ext_name = ?,ext_age = ? where ext_id = ?";
        return jdbcTemplate.update(qryHql, userExt.getExtName(), userExt.getExtAge(), userExt.getExtId());
    }

    @Override
    public int delete(int extId) {
        return jdbcTemplate.update("delete from user_ext where ext_id = ?", extId);
    }

    @Override
    public UserExt findUserExtByExtId(int extId) {
        List<UserExt> userExtList = jdbcTemplate.query("select * from user_ext where ext_id = ?", new Object[]{extId}, new BeanPropertyRowMapper(UserExt.class));
        if(userExtList != null && userExtList.size() > 0){
            if(userExtList.get(0) != null){
                return userExtList.get(0);
            }
        }
        return null;
    }

    @Override
    public List<UserExt> findUserExtList() {
        List<UserExt> userExtList = jdbcTemplate.query("select * from user_ext", new BeanPropertyRowMapper(UserExt.class));
        if(userExtList != null && userExtList.size() > 0){
            return userExtList;
        }
        return null;
    }
}
