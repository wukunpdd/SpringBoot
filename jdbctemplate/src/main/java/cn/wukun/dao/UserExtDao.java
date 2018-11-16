package cn.wukun.dao;

import cn.wukun.domain.UserExt;

import java.util.List;

public interface UserExtDao {
    int add(UserExt userExt);

    int update(UserExt userExt);

    int delete(int extId);

    UserExt findUserExtByExtId(int extId);

    List<UserExt> findUserExtList();
}
