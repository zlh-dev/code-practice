package cn.code.springbootmybatisplus.controller;

import cn.code.springbootmybatisplus.service.FileUploadService;
import cn.code.springbootmybatisplus.temp.bean.FileContent;
import cn.code.springbootmybatisplus.temp.enums.TempType;
import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/file")
@Slf4j
public class FIleController {

    @Resource
    private FileUploadService fileUploadService;

    /**
     * 动态模板下载
     * @param templateType
     * @param request
     * @return
     */
    @GetMapping("/response/{templateType}")
    public ResponseEntity<Object> dynamicDownload(@PathVariable("templateType")String templateType, HttpServletRequest request)throws Exception{
        Assert.notBlank(templateType,"必须只当一个模板类型");

        FileContent fileContent = fileUploadService.dynamicRendering(TempType.valueOf(templateType), request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_ATOM_XML);
        headers.setContentDispositionFormData("attachment",new String(fileContent.getFileName().getBytes(StandardCharsets.UTF_8),StandardCharsets.UTF_8));


        return new ResponseEntity<>(fileContent.getContent(),headers, HttpStatus.OK);
    }
}
