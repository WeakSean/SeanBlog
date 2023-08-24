package cn.sean.blogback.controller;

import cn.sean.blogback.common.R;
import cn.sean.blogback.entity.User;
import cn.sean.blogback.service.UserService;
import cn.sean.blogback.utils.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //新增用户
    @PostMapping("/add")
    public R add(@RequestBody User user){
        //设置唯一uid
        String uid = UUID.randomUUID().toString().replaceAll("-", "");
        user.setUid(uid);
        //对密码进行md5加密
        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pwd);
        //记录当前时间
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        //调用save方法插入数据库
        userService.save(user);
        //报喜
        return R.success("新人注册成功");
    }
    //修改用户
    @PostMapping("/update")
    public R update(@RequestBody User user){
        //获取唯一id
        String uid = user.getUid();
        //创建条件构造器
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("uid",uid);
        //执行更新操作
        userService.update(user,updateWrapper);
        //报喜
        return R.success("信息修改成功");
    }
    //用户登录方法一
    @PostMapping("/login")
    public R login(HttpServletRequest request,@RequestBody User user){
        //将页面提交的password进行md5解密处理
        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        //创建条件构造器
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User result =userService.getOne(queryWrapper);
        //判定这个B是否存在，接着判断这个B是否密码正确，同时再看看这个b有没有被封号
        if(result == null){
            return R.error(500,"登陆失败了捏，该用户不存在捏");
        }
        if(!result.getPassword().equals(pwd)){
            return R.error(500,"是有这个人捏，但是密码错了捏");
        }
        if(result.getStatus() == 0){
            return R.error(500,"你被权限了捏");
        }
        //将id存储到session中，干嘛我也不知道
        //request.getSession().setAttribute("uid",result.getUid());
        //生成jwt,将token存入session中，干嘛的我也不知道
        String token = JwtUtils.generateToken(result);
        //request.getSession().setAttribute("token",token);

        return R.success("登录成功").put("data",result).put("token",token).put("username",result.getUsername());
    }
    //用户登录方法二
    @PostMapping ("/login2")
    public R login2(@RequestBody User user){
//    public R<?> login2(@RequestParam("username") String username,@RequestParam("password") String password){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername())
                .eq(User::getPassword,DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))
                .last("limit 1");
        User userInfo = userService.getOne(wrapper);
        if(userInfo != null){
            //生成jwt
            String token = JwtUtils.generateToken(userInfo);
            HashMap<Object,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("username",userInfo.getUsername());
            return R.success().put("userInfo",userInfo);
        }else {
            return R.error(500,"请检查用户名密码是否正确");
        }
    }
    //根据用户名查用户信息
    @PostMapping("/getInfoByUserName")
    public R getInfoByUserName(@RequestBody User user){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        User userInfo = userService.getOne(wrapper);
        if (userInfo != null){
            return R.success().put("data",userInfo);
        }
        return R.error(500,"没找到这个B");
    }
}
