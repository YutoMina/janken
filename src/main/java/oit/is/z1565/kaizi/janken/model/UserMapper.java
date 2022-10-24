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

  @Select("select * from users where userName = #{userName}")
  User selectByUserName(String userName);

}
