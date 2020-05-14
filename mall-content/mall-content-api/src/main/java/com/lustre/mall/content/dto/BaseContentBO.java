package com.lustre.mall.content.dto;

import lombok.Data;

@Data
public class BaseContentBO {
    private Long id;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 链接
     */
    private String redirect;

    /**
     * 图片绝对路径
     */
    private String imageUrl;

    /**
     * 内容
     */
    private String content;
}
