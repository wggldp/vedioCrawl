package com.admin.crawl;

import com.admin.crawl.pipeline.VedioPipeline;
import com.admin.crawl.processor.VedioProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlApplicationTests {

    @Test
    public void contextLoads() {

    }
    @Test
    public void test() {
        Spider spider = Spider.create(new VedioProcessor());
        spider.addUrl("http://www.jianshu.com");
        spider.addPipeline(new VedioPipeline());
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
    }

}

