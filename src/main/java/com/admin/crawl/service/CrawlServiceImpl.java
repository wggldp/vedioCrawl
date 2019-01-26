package com.admin.crawl.service;

import com.admin.crawl.bean.VedioBean;
import com.admin.crawl.dao.VedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlServiceImpl implements CrawlService {

    @Autowired
    private VedioRepository vedioRepository;
    @Override
    public VedioBean queryByName(String name) {
        return vedioRepository.queryByName(name);
    }

    @Override
    public List<VedioBean> queryAllPage() {
        return vedioRepository.queryAllPage();
    }
}
