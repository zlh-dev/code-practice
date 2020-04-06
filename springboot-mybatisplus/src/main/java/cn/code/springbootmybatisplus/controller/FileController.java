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
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Resource
    private FileUploadService fileUploadService;

    /**
     * 动态模板下载
     * 须继承 cn.code.springbootmybatisplus.temp.proce.AbstractProcession
     * excel 类型实现 cn.code.springbootmybatisplus.temp.proce.AbstractProcession#customize(java.io.InputStream, javax.servlet.http.HttpServletRequest)
     *目前之兼容了 excel文件类型，DOC，PDF文件类型会在后续更新
     * @param templateType
     * @param request
     * @return
     */
    @GetMapping("/response/{templateType}")
    public ResponseEntity<Object> dynamicDownload(@PathVariable("templateType") String templateType, HttpServletRequest request) {
        try{
            Assert.notBlank(templateType, "必须指定一个模板类型");

            FileContent fileContent = fileUploadService.dynamicRendering(TempType.valueOf(templateType), request);

            return fileHeadersAndDownload(fileContent);
        }catch(Exception e){
            log.error("文件模板{}下载失败",templateType);
            throw new RuntimeException(e);
        }

    }

    @GetMapping("static/{templateType}")
    public ResponseEntity<Object> staticFileDownload(@PathVariable("templateType") String templateType){
        try{
            Assert.notBlank(templateType,"必须执行一个模板类型");

            FileContent fileContent = fileUploadService.staticTemplateDownload(TempType.valueOf(templateType));

            return fileHeadersAndDownload(fileContent);
        }catch (Exception e){
            log.error("文件模板{}下载失败",templateType);
            throw new RuntimeException(e);
        }

    }

    /**
     * 文件下载头信息公共处理
     * @param fileContent 包含文件信息的字节数组和文件名
     * @return
     */
    private ResponseEntity<Object> fileHeadersAndDownload(@NotNull FileContent fileContent){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //解决文件名乱码问题-------在utf8编码的环境下需要文件名以utf8的方式解码，在以ISO 8859-1的方式编码，
        headers.setContentDispositionFormData("attachment", new String(fileContent.getFileName().getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1));

        return new ResponseEntity<>(fileContent.getContent(),headers,HttpStatus.OK);

    }
}
