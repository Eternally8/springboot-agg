package com.robben.dao;

import com.robben.model.UserVoEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    @Insert("insert into user_info (`age`,`name`,`sex`,`create_time`,`update_time`) values (#{age},#{name},#{sex},now(),now())")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertUser(UserVoEntity vo);

//    驼峰命名需要设置
    @Select("select `id`,`age`,`name`,`sex`,`create_time` as createTime,`update_time` from user_info where id = #{id}")
    UserVoEntity getUserById(int id);

    @Update("update user_info set `name` = #{name} where sex = #{id}")
    int updateUser(UserVoEntity vo);

    @Delete("delete from user_info where id = #{id}")
    int delUserById(int id);

}
