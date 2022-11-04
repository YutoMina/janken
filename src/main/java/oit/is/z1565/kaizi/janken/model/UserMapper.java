package oit.is.z1565.kaizi.janken.model;

import java.util.ArrayList;

//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("select * from users;")
  ArrayList<User> selectAllUser();

  @Select("select * from users where id = #{id}")
  User selectByUserId(int id);

  @Select("select * from users where userName = #{name}")
  User selectAllByUserName(String name);

  @Select("select id from users where userName = #{name}")
  int selectIdByUserName(String name);

}
