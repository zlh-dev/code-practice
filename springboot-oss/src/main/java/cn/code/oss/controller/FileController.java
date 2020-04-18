package cn.code.oss.controller;

import cn.code.oss.entity.FileResult;
import cn.code.oss.service.FileService;
import com.aliyun.oss.model.OSSObjectSummary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 文件控制器
 *
 * @author zlh-dev
 * @date 2020/04/18 21:21
 */
@Slf4j
@Controller
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("test")
    public String test() {
        return "upload";
    }

    /**
     * 文件上传到oss
     *
     * @param uploadFile 上传文件
     * @return {@link FileResult}
     */
    @PostMapping("upload")
    @ResponseBody
    public FileResult upload(@RequestParam("file") MultipartFile uploadFile) {
        return this.fileService.upload(uploadFile);
    }

    /**
     * 根据文件名删除oss上的文件
     *
     * @param objectName 对象名称
     * @return {@link FileResult}
     */
    @DeleteMapping("delete")
    @ResponseBody
    public FileResult delete(@RequestParam("fileName") String objectName) {
        return this.fileService.delete(objectName);
    }

    /**
     * 查询oss上的所有文件
     *
     * @return {@link List<OSSObjectSummary>}
     */
    @GetMapping("list")
    @ResponseBody
    public List<OSSObjectSummary> list() {
        return this.fileService.list();
    }

    /**
     * 根据文件名下载oss上的文件
     *
     * @param objectName 对象名称
     * @param response   响应
     * @throws IOException ioexception
     */
    @RequestMapping("download")
    @ResponseBody
    public void download(@RequestParam("fileName") String objectName, HttpServletResponse response) throws IOException {
        //通知浏览器以附件形式下载
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String(objectName.getBytes(), "ISO-8859-1"));
        this.fileService.exportOssFile(response.getOutputStream(), objectName);
    }
}