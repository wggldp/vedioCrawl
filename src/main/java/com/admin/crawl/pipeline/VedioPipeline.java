package com.admin.crawl.pipeline;

import com.admin.crawl.repository.VedioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author: wugang
 * @version: 1.0
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VedioPipeline implements Pipeline {

    protected final VedioRepository vedioRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        //TODO 待实现逻辑
    }
}
