package com.lustre.mall.item.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TbItem implements Serializable {
    /**
    * 商品id，同时也是商品编号
    */
    private Long id;

    /**
    * 商品标题
    */
    private String title;

    /**
    * 商品卖点
    */
    private String sellPoint;

    /**
    * 商品价格，单位为：分
    */
    private Integer price;

    /**
    * 库存数量
    */
    private Integer num;

    /**
    * 商品条形码
    */
    private String barcode;

    /**
    * 商品图片
    */
    private String image;

    /**
    * 所属类目，叶子类目
    */
    private Long cid;

    /**
    * 商品状态，1-正常，2-下架，3-删除
    */
    private Byte status;

    /**
    * 创建时间
    */
    private Date created;

    /**
    * 更新时间
    */
    private Date updated;

    private static final long serialVersionUID = 1L;
}