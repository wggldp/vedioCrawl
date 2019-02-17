package com.admin.crawl.filter;

import com.admin.crawl.service.CrawlService;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Component
public class KeyFilter implements ApplicationRunner {

    @Autowired
    private CrawlService crawlService;

    private static BloomFilter<String> key_bf= null;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> list = crawlService.queryAllKey();
        key_bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 1000,0.001);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            key_bf.put(key);
        }
        log.info("ListKey大小为 ={}",list.size()*3/1024/1024);
        log.info("使用布隆过滤器大小为：");
    }

    public BloomFilter<String> getKeyBf(){
        return key_bf;
    }
}
