package com.admin.crawl.controller;

import com.admin.crawl.service.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crawl")
public class CrawlController {

    @Autowired
    private CrawlService crawlService;

    @RequestMapping("/queryAllPage")
    public Object queryAllPage(){
        return crawlService.queryAllPage();
    }

    @RequestMapping("/queryByName")
    public Object queryByName(String name){
        return crawlService.queryByName(name);
    }
}
