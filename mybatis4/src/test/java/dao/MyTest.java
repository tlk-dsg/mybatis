package dao;

import com.tlk.dao.StudentMapper;
import com.tlk.dao.TeacherMapper;
import com.tlk.pojo.Student;
import com.tlk.pojo.Student2;
import com.tlk.pojo.Teacher;
import com.tlk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testgetuser(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student2> list = mapper.getstudent();

        for (Student2 student : list){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testgetuser2(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student2> list = mapper.getstudent2();

        for (Student2 student : list){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testteacher(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void testteacher2(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);

        System.out.println(teacher);
        sqlSession.close();
    }
}
