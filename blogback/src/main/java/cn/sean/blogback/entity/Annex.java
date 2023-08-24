package cn.sean.blogback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@TableName("annex")
@Data
public class Annex implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String formId;

    private Date createTime;

    private Date updateTime;

    private Blob annex;

    private String annexName;

    private String annexNickname;

    private String annexType;

    private Long annexSize;

    private String annexUrl;

    private String userId;

    private String userIp;
}
