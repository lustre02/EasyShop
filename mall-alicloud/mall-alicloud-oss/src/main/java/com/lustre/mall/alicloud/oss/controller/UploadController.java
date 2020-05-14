package com.lustre.mall.alicloud.oss.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.lustre.mall.alicloud.oss.dto.UploadDTO;
import com.lustre.mall.core.dto.ResponseResult;
import com.lustre.mall.core.state.ResponseState;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    private final String endpoint = "oss-cn-beijing.aliyuncs.com";
    private final String bucketName = "lustre123-myshop";
    @Resource
    private OSS ossClient;

    @PostMapping(path = "api/oss/upload")
    public ResponseResult<UploadDTO> upload(MultipartFile multipartFile) throws IOException {
        try {
            String fileName = multipartFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            String newName = UUID.randomUUID() + "." + suffix;
            ossClient.putObject(new PutObjectRequest(bucketName, newName, new ByteArrayInputStream(multipartFile.getBytes())));
            UploadDTO dto = new UploadDTO();
            dto.setUrl("http://" + bucketName + "." + endpoint + "/" + newName);
            return new ResponseResult<>(ResponseState.OK,"上传成功",dto);
        } catch (OSSException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseResult<>(ResponseState.UPLOAD_FAILED,"上传失败");
    }

}
