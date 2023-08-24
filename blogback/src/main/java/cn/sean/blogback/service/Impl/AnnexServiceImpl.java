package cn.sean.blogback.service.Impl;

import cn.sean.blogback.entity.Annex;
import cn.sean.blogback.mapper.AnnexMapper;
import cn.sean.blogback.service.AnnexService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AnnexServiceImpl extends ServiceImpl<AnnexMapper, Annex> implements AnnexService {
}
