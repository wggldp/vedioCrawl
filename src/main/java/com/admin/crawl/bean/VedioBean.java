package com.admin.crawl.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: wugang
 * @version: 1.0
 * @date: 2019/1/26
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class VedioBean {
    private Integer id;
    private String title;
    private String des;
    private String torrent;
    private LocalDateTime cjsj;
}
