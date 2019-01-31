package com.admin.crawl.pipeline;

import com.admin.crawl.bean.SeedVO;
import com.admin.crawl.dao.SeedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class SeedPipeline implements Pipeline {

    @Autowired
    private SeedMapper seedMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
//        log.info("开始入库处理");
        Set<Map.Entry<String, Object>> entrySet = resultItems.getAll().entrySet();
        for (Map.Entry<String, Object> ss : entrySet) {
            if (ss.getKey().contains("seed")) {
                List<SeedVO> vbs = (List<SeedVO>) ss.getValue();
                vbs.forEach(item->{
                    seedMapper.insert(item);
                });
            }
        }
    }
}
