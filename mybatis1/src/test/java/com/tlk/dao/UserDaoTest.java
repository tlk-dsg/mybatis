package com.tlk.dao;

import com.tlk.pojo.User;
import com.tlk.utils.MybatisUtils;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testgetuser(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserList();

        for (User user : list){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testgetuserbyid(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testadduser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.addUser(new User(2, "tlk2" , "123"));

        System.out.println(result);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testupdateuser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser(new User(2, "tlk3" , "123"));

        System.out.println(result);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testdeleteuser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUser(2);

        System.out.println(result);

        sqlSession.commit();
        sqlSession.close();
    }
}
