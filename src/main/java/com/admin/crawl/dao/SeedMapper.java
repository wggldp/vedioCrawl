package com.admin.crawl.dao;

import com.admin.crawl.bean.SeedVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeedMapper {
    int insert(SeedVO seedVO);
    List<SeedVO> queryByName(String name);
}
