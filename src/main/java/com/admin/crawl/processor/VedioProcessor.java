package com.admin.crawl.processor;

import com.admin.crawl.bean.VedioBean;
import com.admin.crawl.pipeline.VedioPipeline;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wugang
 * @version: 1.0
 */
@Slf4j
public class VedioProcessor implements PageProcessor {
    //    private Site site = Site.me().setDomain("jianshu.com")
//            .setSleepTime(100)
//            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static int count =0;
    private static String baseUrl="http://www.acfun.cn";

    @Override
    public void process(Page page) {
        List<Selectable> list = page.getHtml().xpath("//*[@id=\"main\"]/section[2]/div[2]/section").nodes();
        log.info("抓取的内容:{}",list);
        for (Selectable s : list) {
            List<Selectable> fig = s.xpath("//div[2]/figure").nodes();
            if(fig.size()>0){
                List<VedioBean> vb = new ArrayList<>();
                for (Selectable ss : fig) {
                    count++;
                    String vedUrl = ss.xpath("//figcaption/b/a").links().toString();
                    String title = ss.xpath("//figcaption/b/a/text()").toString();
                    vb.add(VedioBean.builder().title(title).torrent(vedUrl).des(title).build());
                }
                page.putField("vedioBean", vb);
            }else{
                break;
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        long startTime, endTime;
        log.info("开始爬取...视频");
        startTime = System.currentTimeMillis();
        Spider.create(new VedioProcessor()).addUrl("http://www.acfun.cn/v/list68/index.htm").
                addPipeline(new VedioPipeline()).thread(5).run();
        endTime = System.currentTimeMillis();
        log.info("爬取结束，耗时约{}秒，抓取了{}条记录", ((endTime - startTime) / 1000) ,count);
    }
}
