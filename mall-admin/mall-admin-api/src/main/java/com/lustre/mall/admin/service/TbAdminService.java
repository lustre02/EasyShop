package com.lustre.mall.admin.service;

import com.lustre.mall.admin.domain.TbAdmin;

public interface TbAdminService {
    TbAdmin getByUsername(String username);

    TbAdmin getByEmail(String email);

    int insert(TbAdmin tbAdmin);

    int delete(Long id);
}
