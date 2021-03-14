package com.tlk.dao;

import com.tlk.pojo.Blog;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
    void addBlog(Blog blog);

    //动态sql if标签
    List<Blog> queryBlogIf(Map map);

    List<Blog> findActiveBlogLike(Map map);

    List<Blog> selectPostIn(Map map);
}
