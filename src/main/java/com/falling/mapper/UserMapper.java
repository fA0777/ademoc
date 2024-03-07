package com.falling.mapper;

import com.falling.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param name
     * @return
     */
    @Select("select * from ademoc.user where name = #{name}")
    User select(String name);

    @Insert("insert into ademoc.user value(null,#{name},#{salt},#{password},#{trueName},#{gender},#{birthday},#{registrationDate},#{tel},#{profilePhoto},#{status})")
    void addUser(User user);
}
