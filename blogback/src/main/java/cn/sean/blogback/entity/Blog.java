package cn.sean.blogback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("blog")
@Data
public class Blog implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String uid;

    private String classify;

    private String title;

    private String content;

    private String image;

    private String video;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
