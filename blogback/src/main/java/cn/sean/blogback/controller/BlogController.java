package cn.sean.blogback.controller;

import cn.sean.blogback.common.R;
import cn.sean.blogback.entity.Blog;
import cn.sean.blogback.service.BlogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/add")
    public R add(@RequestBody Blog blog) {
        blog.setImage("/");
        blog.setVideo("/");
        //记录当前时间
        blog.setCreateTime(LocalDateTime.now());
        blog.setUpdateTime(LocalDateTime.now());
        //调用save方法插入数据库
        blogService.save(blog);
        return R.success("博文新增成功！");
    }

    @GetMapping("/list")
    public R list() {
        List<Blog> list = blogService.list();
        Integer count = blogService.count();
        return R.success().put("data",list).put("count",count);
    }

    @PostMapping("/edit")
    public R edit(@RequestBody Blog blog){
        blogService.update();
        return R.success("博文更新成功！");
    }

    @PostMapping("/getDetailById")
    public R getDetailById(@RequestBody Blog blog){
//        Blog blog = new Blog();
//        blog.setId(id);
        Integer id = blog.getId();
        Blog blog1 = blogService.getById(id);
        return R.success().put("data",blog1);
    }

    @PostMapping("/delete")
    public R delete(@RequestBody long id){
        blogService.removeById(id);
        return R.success("删除成功！");
    }

    @PostMapping("/page")
    public R Page(@RequestBody Map<String,String> blogList){
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        int num = Integer.parseInt(blogList.get("pageNum")) ;
        int size = Integer.parseInt(blogList.get("pageSize")) ;
        String title = (String) blogList.get("title");
        String classify = (String) blogList.get("classify");
        if(title!=null&& !title.equals("")){
            queryWrapper.eq("title",title);
        }
        if(classify!=null&& !classify.equals("")){
            queryWrapper.eq("classify",classify);
        }
        queryWrapper.orderByDesc("create_time");
        Page<Blog> blogPage = blogService.page(new Page<>(num, size), queryWrapper);
        return R.success().put("data",blogPage);
    }
}
