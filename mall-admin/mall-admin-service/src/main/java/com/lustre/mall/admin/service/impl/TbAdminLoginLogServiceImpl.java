package com.lustre.mall.admin.service.impl;

import com.lustre.mall.admin.domain.TbAdminLoginLog;
import com.lustre.mall.admin.mapper.TbAdminLoginLogMapper;
import com.lustre.mall.admin.service.TbAdminLoginLogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TbAdminLoginLogServiceImpl implements TbAdminLoginLogService {

    @Autowired
    private TbAdminLoginLogMapper mapper;

    @Override
    public int insert(TbAdminLoginLog log) {
        return mapper.insertSelective(log);
    }
}
