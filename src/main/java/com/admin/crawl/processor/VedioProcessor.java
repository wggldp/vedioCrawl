package com.admin.crawl.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @author: wugang
 * @version: 1.0
 */
public class VedioProcessor implements PageProcessor {
    private Site site = Site.me().setDomain("jianshu.com")
            .setSleepTime(100)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
    public static final String list = "http://www.jianshu.com";

    @Override
    public void process(Page page) {
        //TODO 待实现逻辑
    }

    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args) {

    }
}
