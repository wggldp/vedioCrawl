package com.admin.crawl.schedule;

import com.admin.crawl.pipeline.VedioPipeline;
import com.admin.crawl.processor.VedioProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * @author: wugang
 * @version: 1.0
 */
@Component
public class VedioScheduled {

    @Autowired
    private  VedioPipeline vedioPipeline;

    @Scheduled(cron = "0 1 17 * * ? ")//从0点开始,每2个小时执行一次
    public void vedioScheduled() {
        System.out.println("----开始执行简书定时任务");
        Spider spider = Spider.create(new VedioProcessor());
        spider.addUrl("http://www.acfun.cn/v/list68/index.htm");
        spider.addPipeline(vedioPipeline);
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
    }
}
