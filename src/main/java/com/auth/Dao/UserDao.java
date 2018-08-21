package com.auth.Dao;

import com.auth.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserDao {
    @Select("select * from user u left join user_role ur  on ur.id = u.id left join role r on r.id= ur.id where username = #{username}")
    User findUserByName(String username);
}
