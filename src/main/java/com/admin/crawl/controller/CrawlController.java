package com.admin.crawl.controller;

import com.admin.crawl.filter.KeyFilter;
import com.admin.crawl.pipeline.SeedPipeline;
import com.admin.crawl.processor.SeedProcessor;
import com.admin.crawl.service.CrawlService;
import com.google.common.hash.BloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

@RestController
@RequestMapping("/crawl")
public class CrawlController {

    @Autowired
    private CrawlService crawlService;
    @Autowired
    private SeedPipeline seedPipeline;

//    @RequestMapping("/queryAllPage")
    public Object queryAllPage(){
        return crawlService.queryAllPage();
    }

    @RequestMapping("/queryByName")
    public Object queryByName(String name) throws Exception{
        if(checkKeyExsit(name)){
            return crawlService.queryByName(name);
        }
        try {
            start(name);
        }catch (Exception e){
            throw new Exception("爬取内容失败");
        }
        return crawlService.queryByName(name);

    }

    private boolean checkKeyExsit(String name){
        KeyFilter keyFilter = new KeyFilter();
        BloomFilter<String> bf = keyFilter.getKeyBf();
        return bf.mightContain(name.trim());
    }

    private void start(String name){
        String url = "http://www.bteat.com/search/"+name+"-first-asc-1";
        Spider spider = Spider.create(new SeedProcessor());
        spider.addUrl(url);
        spider.addPipeline(seedPipeline);
        spider.thread(2);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
    }

}
