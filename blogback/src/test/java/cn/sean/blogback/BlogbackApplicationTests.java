package cn.sean.blogback;

import cn.sean.blogback.entity.Blog;
import cn.sean.blogback.entity.User;
import cn.sean.blogback.service.BlogService;
import cn.sean.blogback.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
class BlogbackApplicationTests {
    private BlogService blogService;

    @Test
    void contextLoads() {
    }

    @Test
    void testJwt() {
        User user = new User();
        user.setId(1);
        user.setUsername("supersean");
        System.out.println(JwtUtils.generateToken(user));
    }

    //eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2Nzk5NzI2OTMsInVzZXJJZCI6MSwiaWF0IjoxNjc5OTcwMTAxLCJqdGkiOiJ0b2tlbklkIiwidXNlcm5hbWUiOiJzdXBlcnNlYW4ifQ.NSOKxnnhx14wuizybK0-RrGGBaaw_fOQR0PZcfnd7ho

    @Test
    void testJwt2() {
        User user = new User();
        user.setId(1);
        user.setUsername("supersean");
        System.out.println(JwtUtils.generateToken(user));
        String str= "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2Nzk5NzI2OTMsInVzZXJJZCI6MSwiaWF0IjoxNjc5OTcwMTAxLCJqdGkiOiJ0b2tlbklkIiwidXNlcm5hbWUiOiJzdXBlcnNlYW4ifQ.NSOKxnnhx14wuizybK0-RrGGBaaw_fOQR0PZcfnd7ho";
        Claims claims = JwtUtils.verifyJwt(str);
    }
    @Test
    void test3() {
        Blog blog = new Blog();
        blog.setUid("wqddfqfqfqw1112e12112e");
        blog.setGroup("aa");
        blog.setContent("<p>qwdqwdqwfqwfqwfq</p>");
        blogService.save(blog);
    }


    @Test
    public String PIC(MultipartFile multipartFile){
        return null;
    }
}
