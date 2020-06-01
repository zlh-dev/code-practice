package cn.code.util;

import cn.code.config.OssConfig;
import cn.code.enums.FileType;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * oss工具类
 *
 * @author zlh-dev
 * @date 2020/05/23 20:56
 */
@Slf4j
public class OssUtil {
    @Autowired
    private OSS ossClient;
    @Autowired
    private OssConfig ossConfig;

    /**
     * 上传
     *
     * @param uploadFile 上传文件
     */
    public String upload(MultipartFile uploadFile) {
        //文件新路径
        String fileName = uploadFile.getOriginalFilename();
        String filePath = getFilePath(fileName);
        // 上传到阿里云
        try {
            ossClient.putObject(ossConfig.getBucketName(), filePath, new ByteArrayInputStream(uploadFile.getBytes()));
            String url = ossConfig.getUrlPrefix() + filePath;
            log.debug("上传成功，url:{}", url);
            return url;
        } catch (Exception e) {
            //上传失败
            log.error("文件上传失败:{}", e.getMessage());
            return null;
        }
    }

    /**
     * 生成路径以及文件名
     * 例如：//document/test.txt
     *
     * @param sourceFileName 源文件名字
     * @return {@link String}
     */
    private String getFilePath(String sourceFileName) {
        return FileType.getFileType(sourceFileName).name() + "/" + sourceFileName;
    }

    /**
     * 查看文件列表
     *
     * @return {@link List<OSSObjectSummary>}
     */
    public List<OSSObjectSummary> list() {
        // 设置最大个数。
        final int maxKeys = 200;
        // 列举文件。
        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(ossConfig.getBucketName()).withMaxKeys(maxKeys));
        return objectListing.getObjectSummaries();
    }

    /**
     * 删除文件
     *
     * @param objectName 对象名称
     * @return boolean
     */
    public boolean delete(String objectName) {
        try {
            // 根据BucketName,objectName删除文件
            ossClient.deleteObject(ossConfig.getBucketName(), objectName);
            log.error("删除成功:{}", objectName);
            return true;
        } catch (Exception e) {
            log.error("删除失败:{}", e.getMessage());
            return false;
        }
    }

    /**
     * 下载文件
     *
     * @param os         操作系统
     * @param objectName 对象名称
     * @throws IOException ioexception
     */
    public void exportOssFile(OutputStream os, String objectName) throws IOException {
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(ossConfig.getBucketName(), objectName);
        // 读取文件内容。
        BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
        BufferedOutputStream out = new BufferedOutputStream(os);
        byte[] buffer = new byte[1024];
        int lenght;
        while ((lenght = in.read(buffer)) != -1) {
            out.write(buffer, 0, lenght);
        }
        out.flush();
        out.close();
        in.close();
    }
}
