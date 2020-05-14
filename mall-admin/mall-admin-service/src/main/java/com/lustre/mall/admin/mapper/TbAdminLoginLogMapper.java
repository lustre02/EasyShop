package com.lustre.mall.admin.mapper;

import com.lustre.mall.admin.domain.TbAdminLoginLog;
import com.lustre.mall.admin.domain.TbAdminLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAdminLoginLogMapper {
    long countByExample(TbAdminLoginLogExample example);

    int deleteByExample(TbAdminLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAdminLoginLog record);

    int insertSelective(TbAdminLoginLog record);

    List<TbAdminLoginLog> selectByExample(TbAdminLoginLogExample example);

    TbAdminLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAdminLoginLog record, @Param("example") TbAdminLoginLogExample example);

    int updateByExample(@Param("record") TbAdminLoginLog record, @Param("example") TbAdminLoginLogExample example);

    int updateByPrimaryKeySelective(TbAdminLoginLog record);

    int updateByPrimaryKey(TbAdminLoginLog record);
}