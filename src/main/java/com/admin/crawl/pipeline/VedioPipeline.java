package com.admin.crawl.pipeline;

import com.admin.crawl.repository.VedioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * @author: wugang
 * @version: 1.0
 */
@Service
@Slf4j
public class VedioPipeline implements Pipeline {

    @Autowired
    private  VedioRepository vedioRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        log.info("test1");
        //TODO 待实现逻辑
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()){

        }
    }
}
