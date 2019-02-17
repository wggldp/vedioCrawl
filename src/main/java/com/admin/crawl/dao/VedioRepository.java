package com.admin.crawl.dao;

import com.admin.crawl.bean.VedioBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wugang
 * @version: 1.0
 */
@Repository
public interface VedioRepository {

    VedioBean queryByName(String name);

    int chechKey(String key);

    int insertBatch(String key);

    int insert(VedioBean vb);

    List<VedioBean> queryAllPage();

    List<String> getAllKeys();
}
