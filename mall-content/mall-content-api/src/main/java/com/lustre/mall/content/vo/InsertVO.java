package com.lustre.mall.content.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class InsertVO {

    @NotNull(message = "类目ID不能为空")
    private Long categoryId;

    /**
     * 内容标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;

    /**
     * 链接
     */
    @NotBlank(message = "重定向不能为空")
    private String redirect;

    /**
     * 图片绝对路径
     */
    @NotBlank(message = "图片路径不能为空")
    private String imageUrl;

    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;
}
