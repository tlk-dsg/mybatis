package dao;

import com.tlk.dao.BlogMapper;
import com.tlk.pojo.Blog;
import com.tlk.utils.IdUtils;
import com.tlk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class UserDaoTest {

    @Test
    public void testaddblog(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtils.GetId());
        blog.setTitle("Mybatis");
        blog.setAuthor("tlk");
        blog.setCreateTime(new Date());
        blog.setViews(2000);

        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testqueryblogif(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, String> map = new HashMap();
        map.put("title" , "Mybatis");
        map.put("author" , "tlk");
        List<Blog> list = mapper.queryBlogIf(map);

        for (Blog blog : list){
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void testquerybloglike(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, String> map = new HashMap();
        map.put("title" , "Mybatis");
        map.put("author" , "tlk");
        List<Blog> list = mapper.findActiveBlogLike(map);

        for (Blog blog : list){
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void testselectPostIn(){
        //获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行SQL
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, List<Integer>> map = new HashMap();

        ArrayList<Integer> views = new ArrayList<>();
        views.add(20);
        views.add(200);
        map.put("views" , views);
        List<Blog> list = mapper.selectPostIn(map);

        for (Blog blog : list){
            System.out.println(blog);
        }

        sqlSession.close();
    }



}
