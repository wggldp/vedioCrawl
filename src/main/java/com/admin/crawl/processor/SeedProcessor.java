package com.admin.crawl.processor;

import com.admin.crawl.bean.SeedVO;
import com.admin.crawl.pipeline.SeedPipeline;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SeedProcessor implements PageProcessor {
    private static  final String URL =  "http://www.bteat.com/";

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        List<SeedVO> vb = new ArrayList<>();
        if(page.getUrl().regex("http://www.bteat.com/search").match()){
            List<String> all = page.getHtml().xpath("//*[@id=\"wall\"]/div[@class ='search-item']/div[@class='item-title']/a/@href").all();
            List<String> urls = new ArrayList<>();
            for(String single : all){
                urls.add(URL+single);
            }
            page.addTargetRequests(urls);
        }else{
            Html html = page.getHtml();
            String title =  html.xpath("//*[@id=\"wall\"]/h1/text()").get();
            String desc =  html.xpath("//*[@id=\"wall\"]/div[@class='fileDetail']/p[1]/a/text()").get();
            String size =  html.xpath("//*[@id=\"wall\"]/div[@class='fileDetail']/p[2]/text()").get();////*[@id="wall"]/div[1]/p[2]
            String getDate =  html.xpath("//*[@id=\"wall\"]/div[@class='fileDetail']/p[3]/text()").get();//收录时间
            String lastDate =  html.xpath("//*[@id=\"wall\"]/div[@class='fileDetail']/p[4]/text()").get(); //最后活跃时间
            String hot =  html.xpath("//*[@id=\"wall\"]/div[@class='fileDetail']/p[5]/text()").get(); //热度
            String url =  html.xpath("//*[@id=\"wall\"]/div[@class='fileDetail']/p[7]/a/@href").get(); //迅雷链接
            System.out.println("抓取的内容："+title+desc+size+getDate+lastDate+hot+url);
            vb.add(SeedVO.builder().seed_title(title).seed_desc(desc).seed_size(size).seed_hot(hot).seed_link(url).build());
        }
        if(vb.size()>0){
            page.putField("seed", vb);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }


}
