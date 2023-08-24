package cn.sean.blogback.service.Impl;

import cn.sean.blogback.entity.Blog;
import cn.sean.blogback.mapper.BlogMapper;
import cn.sean.blogback.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper,Blog> implements BlogService {
}
