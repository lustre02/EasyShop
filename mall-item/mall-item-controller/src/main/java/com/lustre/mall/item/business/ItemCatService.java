package com.lustre.mall.item.business;

import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.redis.LockTemplate;
import com.lustre.mall.core.redis.RedisFacade;
import com.lustre.mall.core.state.ResponseState;
import com.lustre.mall.core.utils.MapperUtil;
import com.lustre.mall.item.dto.CatTreeBO;
import com.lustre.mall.item.service.TbItemCatService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCatService {

    @Reference
    private TbItemCatService tbItemCatService;

    private final String itemCatTreeRedisKey = "api:item:cat:tree";

    private RedisFacade redisFacade;
    private LockTemplate lockTemplate;

    public ItemCatService(RedisFacade redisFacade, LockTemplate lockTemplate) {
        this.redisFacade = redisFacade;
        this.lockTemplate = lockTemplate;
    }

    private List<CatTreeBO> listItemCatTreeByRedis(String redisKey) {
        String cache = redisFacade.get(redisKey);
        List<CatTreeBO> list = null;
        if (cache != null) {
            list = MapperUtil.toList(cache, CatTreeBO.class);
        }
        return list;
    }

    public ResponseResult<List<CatTreeBO>> ItemCatTree() {
        List<CatTreeBO> data = listItemCatTreeByRedis(itemCatTreeRedisKey);
        if (data != null) {
            return new ResponseResult<>(ResponseState.OK, "查询成功", data);
        }

        //加锁  解决缓存击透
        Object response = lockTemplate.exec(itemCatTreeRedisKey + ":lock", () -> {
            List<CatTreeBO> data2 = listItemCatTreeByRedis(itemCatTreeRedisKey);
            if (data2 != null) {
                return new ResponseResult<>(ResponseState.OK, "查询成功", data2);
            } else {
                List<CatTreeBO> data3 = tbItemCatService.tree();
                redisFacade.set(itemCatTreeRedisKey, MapperUtil.toJSON(data3));
                return new ResponseResult<>(ResponseState.OK, "查询成功", data3);
            }
        });

        if (response != null) {
            return (ResponseResult<List<CatTreeBO>>) response;
        } else {
            return new ResponseResult<>(ResponseState.UNKNOWN_EXCEPTION, "未知原因");
        }
    }
}
