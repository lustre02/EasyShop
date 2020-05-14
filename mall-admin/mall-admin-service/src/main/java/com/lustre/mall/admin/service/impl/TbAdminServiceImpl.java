package com.lustre.mall.admin.service.impl;

import com.lustre.mall.admin.domain.TbAdmin;
import com.lustre.mall.admin.domain.TbAdminExample;
import com.lustre.mall.admin.mapper.TbAdminMapper;
import com.lustre.mall.admin.service.TbAdminService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TbAdminServiceImpl implements TbAdminService {

    @Autowired
    private TbAdminMapper tbAdminMapper;

    private TbAdmin getFirstElement(TbAdminExample e){
        List<TbAdmin> tbAdmins = tbAdminMapper.selectByExample(e);
        if (!tbAdmins.isEmpty()) {
            return tbAdmins.get(0);
        }
        return null;
    }

    @Override
    public TbAdmin getByUsername(String username) {
        TbAdminExample e = new TbAdminExample();
        e.createCriteria().andUsernameEqualTo(username);
        return getFirstElement(e);
    }

    @Override
    public TbAdmin getByEmail(String email) {
        TbAdminExample e = new TbAdminExample();
        e.createCriteria().andEmailEqualTo(email);
        return getFirstElement(e);
    }

    @Override
    public int insert(TbAdmin tbAdmin) {
        return tbAdminMapper.insertSelective(tbAdmin);
    }

    @Override
    public int delete(Long id) {
        return tbAdminMapper.deleteByPrimaryKey(id);
    }

}
