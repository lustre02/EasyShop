package com.lustre.mall.admin.message.receive;

import com.lustre.mall.admin.domain.TbAdminLoginLog;
import com.lustre.mall.admin.service.TbAdminLoginLogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class TbAdminLoginLogReceive {

    @Reference
    private TbAdminLoginLogService tbAdminLoginLogService;


    @StreamListener("mall-admin-login-log-insert-topic")
    public void insert(TbAdminLoginLog log){
        tbAdminLoginLogService.insert(log);
    }


}
