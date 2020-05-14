package com.lustre.mall.admin.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TbAdminLoginLog implements Serializable {
    private Long id;

    private Integer adminId;

    private Date createTime;

    private String ip;

    private String address;

    /**
    * 浏览器登录类型
    */
    private String userAgent;

    private static final long serialVersionUID = 1L;
}