package com.admin.crawl.bean;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class SeedVO {
    private long seed_id;
    private String seed_title;
    private String seed_desc;
    private String seed_hot;
    private String seed_size;
    private String seed_link;
    private LocalDateTime seed_create_time;
}
