package com.admin.crawl.pipeline;

import com.admin.crawl.bean.VedioBean;
import com.admin.crawl.dao.VedioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author: wugang
 * @version: 1.0
 */
@Service
@Slf4j
public class VedioPipeline implements Pipeline {

    @Autowired
    protected   VedioRepository vedioRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        log.info("开始入库处理");
        //TODO 待实现逻辑
        Set<Map.Entry<String, Object>> entrySet = resultItems.getAll().entrySet();
        for (Map.Entry<String, Object> ss : entrySet) {
            if (ss.getKey().contains("vedioBean")) {
                List<VedioBean> vbs = (List<VedioBean>) ss.getValue();
                vbs.forEach(item->{
                    item.setCjsj(LocalDateTime.now());
                    vedioRepository.insert(item);
                });
            }
        }
    }
}
