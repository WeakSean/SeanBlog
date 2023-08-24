package cn.sean.blogback.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@TableName("user")
@Data
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String uid;
    private Integer qqid;
    private Integer wxid;
    private String username;
    private String password;
    private String avatar;
    private String gender;
    private String profile;
    private String email;
    private Integer status;
    private Integer purview;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
