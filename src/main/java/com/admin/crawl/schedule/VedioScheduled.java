package com.admin.crawl.schedule;

import com.admin.crawl.pipeline.VedioPipeline;
import com.admin.crawl.processor.VedioProcessor;
import com.admin.crawl.repository.VedioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * @author: wugang
 * @version: 1.0
 */
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VedioScheduled {

    private final VedioPipeline vedioPipeline;

    @Scheduled(cron = "0 0 0/2 * * ? ")//从0点开始,每2个小时执行一次
    public void jianShuScheduled() {
        System.out.println("----开始执行简书定时任务");
        Spider spider = Spider.create(new VedioProcessor());
        spider.addUrl("http://www.jianshu.com");
        spider.addPipeline(vedioPipeline);
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
    }
}
