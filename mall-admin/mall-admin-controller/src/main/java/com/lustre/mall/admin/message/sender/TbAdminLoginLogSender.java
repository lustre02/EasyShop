package com.lustre.mall.admin.message.sender;

import com.lustre.mall.admin.domain.TbAdminLoginLog;
import com.lustre.mall.admin.message.source.TbAdminLoginLogSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TbAdminLoginLogSender {
    @Autowired
    private TbAdminLoginLogSource source;

    public void sendLog(TbAdminLoginLog log){
        System.out.println(log);
        source.insert().send(MessageBuilder.withPayload(log).build());
    }

}
