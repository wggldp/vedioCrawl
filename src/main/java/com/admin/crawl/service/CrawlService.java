package com.admin.crawl.service;

import com.admin.crawl.bean.VedioBean;

import java.util.List;

public interface CrawlService {
    VedioBean queryByName(String name);
    List<VedioBean> queryAllPage();

    List<String> queryAllKey();
}
