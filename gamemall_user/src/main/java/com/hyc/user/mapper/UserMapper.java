package com.hyc.user.mapper;

import com.hyc.user.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //登录
    @Select("select * from tb_user where username=#{username}")
    public User loginByName(String username);
    //注册
    @Insert("insert into tb_user(username,password,phone,email) value(#{username},#{password},#{phone},#{email})")
    public int insertUser(User user);


}
