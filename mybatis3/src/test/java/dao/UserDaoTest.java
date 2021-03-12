package dao;

import com.tlk.dao.UserMapper;
import com.tlk.pojo.User;
import com.tlk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

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
    public void testLog4j(){
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
    }

    @Test
    public void testgetuserlimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex" , 2 );
        map.put("pageSize" , 2);
        List<User> list = mapper.getUserLimitList(map);

        for (User user : list){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testgetuserannotation(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserAnnotation();

        for (User user : list){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testgetuserbyidannotation(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getuserbyid(1);

        System.out.println(user);


        sqlSession.close();
    }
}
