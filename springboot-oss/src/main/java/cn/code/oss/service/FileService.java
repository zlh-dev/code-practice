package cn.code.oss.service;

import cn.code.oss.entity.FileResult;
import com.aliyun.oss.model.OSSObjectSummary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 文件服务类
 *
 * @author zlh-dev
 * @date 2020/04/18 21:46
 */
@Service
public interface FileService {

    /**
     * 上传
     *
     * @param uploadFile 上传文件
     * @return {@link FileResult}
     */
    FileResult upload(MultipartFile uploadFile);

    /**
     * 查看文件列表
     *
     * @return {@link List<OSSObjectSummary>}
     */
    List<OSSObjectSummary> list();

    /**
     * 删除文件
     *
     * @param objectName 对象名称
     * @return {@link FileResult}
     */
    FileResult delete(String objectName);

    /**
     * 下载文件
     *
     * @param os         操作系统
     * @param objectName 对象名称
     * @throws IOException ioexception
     */
    void exportOssFile(OutputStream os, String objectName) throws IOException;
}

