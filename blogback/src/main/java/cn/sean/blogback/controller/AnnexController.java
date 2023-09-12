package cn.sean.blogback.controller;

import cn.sean.blogback.common.R;
import cn.sean.blogback.entity.Annex;
import cn.sean.blogback.service.AnnexService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/annex")
public class AnnexController {


    @Value("${uploadUrl}")
    private String uploadUrl;

    @Autowired
    private AnnexService annexService;

    @PostMapping("/upload")
    public Object upload(@RequestParam(value = "multipartFile")MultipartFile[] multipartFile) throws IllegalStateException, IOException, SQLException {
        String groupId = UUID.randomUUID().toString();
        Map<String,Object> map = new HashMap<String,Object>();
        List<Object> list = new ArrayList<>();
        Date date = new Date();//获取当前时间
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//定义日期格式
//        String dateString = dateFormat.format(date);//将时间格式化为字符串
        if( multipartFile != null && multipartFile.length > 0 ){
            for(int i = 0;i < multipartFile.length; i++){
                Annex annex = new Annex();
                //设置文件名称1
                map.put("fileOriginName",multipartFile[i].getOriginalFilename());
                //设置文件名称2
                map.put("fileType",multipartFile[i].getName());
                //设置文件类型
                map.put("contentType",multipartFile[i].getContentType());
                //设置文件大小
                map.put("fileSize",multipartFile[i].getSize());
                //重新设置文件名字（根据文件原名命名）
                String fileName = UUID.randomUUID() + "." +multipartFile[i].getContentType().substring(multipartFile[i].getContentType().lastIndexOf("/")+1);
                //设置文件保存的文件夹名
                String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String finalPath = uploadUrl+folderName;
                File file = new File(finalPath,fileName);
                if(!file.exists()){
                    //查看文件路径是否存在，不存在则创建文件夹
                    file.mkdirs();
                }
                String filePath = finalPath+"/"+fileName;
                multipartFile[i].transferTo(new File(filePath));
                //字节形式转二进制——妈的以后来搞
//                byte[] bytes = multipartFile[i].getBytes();
//                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                //录入数据库
                annex.setFormId(groupId);
//                annex.setAnnex(blob);
                annex.setCreateTime(date);
                annex.setAnnexName(multipartFile[i].getOriginalFilename());
                annex.setAnnexType(multipartFile[i].getContentType());
                annex.setAnnexSize(multipartFile[i].getSize());
                annex.setAnnexNickname(fileName);
                annex.setAnnexUrl(filePath);
                annexService.save(annex);
                list.add(map);
            }
            return R.success("上传成功").put("data",list);
        }else {
            return R.error(1,"上传失败，请联系管理员YY");
        }

    }

    /**
     * 近期添加
     * @return R
     */
    @PostMapping("/getPhotoByRecent")
    public R getPhotoByRecent(){
// TODO: 2023/8/25 分类 我最喜欢 近期添加 最近一个月点击次数最多
        QueryWrapper<Annex> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        wrapper.last("limit 6");
//        Map<String, Object> map = annexService.getMap(wrapper);
        List<Map<String, Object>> maps = annexService.listMaps(wrapper);
        return R.success().put("data",maps);
    }
}
