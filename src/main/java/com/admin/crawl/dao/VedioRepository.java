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

    VedioBean findOne(VedioBean vedioBean);

    int insertBatch(List<VedioBean> vb);

    int insert(VedioBean vb);
}