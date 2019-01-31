package com.admin.crawl.schedule;

import com.admin.crawl.pipeline.SeedPipeline;
import com.admin.crawl.processor.SeedProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
public class SeedScheduled {

    @Autowired
    private SeedPipeline seedPipeline;

    @Scheduled(cron = "* * /20 * * * ? ")//从0点开始,每2个小时执行一次
    public void seedScheduled() {
        Spider spider = Spider.create(new SeedProcessor());
        spider.addUrl("http://www.bteat.com/search/刘涛-first-asc-1");
        spider.addPipeline(seedPipeline);
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
    }
}
