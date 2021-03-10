package dao;

import com.tlk.dao.UserMapper;
import com.tlk.pojo.User;
import com.tlk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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



}
