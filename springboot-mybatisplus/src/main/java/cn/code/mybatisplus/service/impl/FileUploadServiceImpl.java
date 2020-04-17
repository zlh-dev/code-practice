package cn.code.mybatisplus.service.impl;

import cn.code.mybatisplus.service.FileUploadService;
import cn.code.mybatisplus.temp.bean.FileContent;
import cn.code.mybatisplus.temp.enums.TempType;
import cn.code.mybatisplus.temp.proce.PersonalizedCustomization;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 文件上传服务impl
 *
 * @author 王亚旭
 * @date 2020/04/06 23:52
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    private Map<TempType, PersonalizedCustomization> map = Maps.newHashMap();

    @Override
    public FileContent staticTemplateDownload(TempType tempType) throws Exception {
        //静态模板直接下载
        return new FileContent(IoUtil.readBytes(getInputStream(tempType),Boolean.TRUE),tempType.getDefaultFileName());
    }

    @Override
    public FileContent dynamicRendering(TempType tempType, HttpServletRequest request) throws Exception {

         return map.get(tempType).distributionProcessing(getInputStream(tempType), request);

    }


    private InputStream getInputStream(TempType tempType){

        ClassPathResource classPathResource = new ClassPathResource(tempType.getFilePath());

        return classPathResource.getStream();

    }

    @Autowired
    private void setFileTemplateMessage(List<PersonalizedCustomization> persona){
        persona.forEach(s->map.put(s.getFileType(),s));
    }
}
