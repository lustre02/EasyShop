package com.lustre.mall.admin.pojo;

import lombok.Data;

import java.util.List;

@Data
public class InfoBO {
    /**
     * 权限
     */
    private List<String> roles;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String name;

    /**
     * 备注信息
     */
    private String introduction;
}
