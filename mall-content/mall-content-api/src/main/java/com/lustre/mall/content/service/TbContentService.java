package com.lustre.mall.content.service;

import com.lustre.mall.content.domain.TbContent;

import java.util.List;

public interface TbContentService {

    /**
     * 查询列表
     *
     * @param cid 内容类目ID
     */
    List<TbContent> listByCid(Long cid);


    /**
     * 分页查询列表
     *
     * @param cid 内容类目id
     * @param pageNum           页数
     * @param pageSize          条数
     * @return
     */
    List<TbContent> pageByCid(Long cid, int pageNum, int pageSize);


    /**
     * 全部检索
     *
     * @return
     */
    List<TbContent> list();


    /**
     * 获取类目下的条数
     *
     * @param cid 内容类目id
     * @return
     */
    Long countByCid(Long cid);

    /**
     * 添加内容
     *
     * @param tbContent
     * @return
     */
    int insert(TbContent tbContent);

    /**
     * 删除内容
     *
     * @param id 主键
     * @return
     */
    int delById(Long id);


}
