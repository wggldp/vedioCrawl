package com.admin.crawl.service;

import com.admin.crawl.bean.VedioBean;
import com.admin.crawl.dao.VedioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CrawlServiceImpl implements CrawlService {

    @Autowired
    private VedioRepository vedioRepository;

    @Override
    public VedioBean queryByName(String name) {
        if(vedioRepository.chechKey(name)==0){
            int i =vedioRepository.insertBatch(name);
            if(i>0){
                log.info("此关键词 key={},插入成功",name);
            }
        }
        return vedioRepository.queryByName(name);
    }

    @Override
    public List<VedioBean> queryAllPage() {
        return vedioRepository.queryAllPage();
    }

    @Override
    public List<String> queryAllKey() {
        return vedioRepository.getAllKeys();
    }
}
