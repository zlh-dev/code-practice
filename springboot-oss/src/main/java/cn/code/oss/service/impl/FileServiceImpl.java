package cn.code.oss.service.impl;

import cn.code.oss.config.OssConfig;
import cn.code.oss.entity.FileResult;
import cn.code.oss.service.FileService;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 文件服务类
 *
 * @author zlh-dev
 * @date 2020/04/18 21:46
 */
@Service
public class FileServiceImpl implements FileService {
    /**
     * 允许上传的格式
     */
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};
    @Autowired
    private OSS ossClient;
    @Autowired
    private OssConfig ossConfig;

    /**
     * 上传
     *
     * @param uploadFile 上传文件
     * @return {@link FileResult}
     */
    @Override
    public FileResult upload(MultipartFile uploadFile) {
        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(),
                    type)) {
                isLegal = true;
                break;
            }
        }
        //封装Result对象，并且将文件的byte数组放置到result对象中
        FileResult result = new FileResult();
        if (!isLegal) {
            result.setStatus("error");
            return result;
        }
        //文件新路径
        String fileName = uploadFile.getOriginalFilename();
        String filePath = getFilePath(fileName);
        // 上传到阿里云
        try {
            ossClient.putObject(ossConfig.getBucketName(), filePath, new ByteArrayInputStream(uploadFile.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            //上传失败
            result.setStatus("error");
            return result;
        }
        result.setStatus("done");
        result.setResponse("success");
        result.setName(this.ossConfig.getUrlPrefix() + filePath);
        result.setUid(String.valueOf(System.currentTimeMillis()));
        return result;
    }

    /**
     * 生成路径以及文件名
     * 例如：//images/2019/08/10/15564277465972939.jpg
     *
     * @param sourceFileName 源文件名字
     * @return {@link String}
     */
    private String getFilePath(String sourceFileName) {
        LocalDateTime dateTime = LocalDateTime.now();
        return "images/" + dateTime.getYear() + "/"
                + dateTime.getMonth() + "/"
                + dateTime.getDayOfMonth() + "/"
                + dateTime.getHour() + dateTime.getMinute() + dateTime.getSecond() + dateTime.getNano() + "."
                + StringUtils.substringAfterLast(sourceFileName, ".");
    }

    /**
     * 查看文件列表
     *
     * @return {@link List<OSSObjectSummary>}
     */
    @Override
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
     * @return {@link FileResult}
     */
    @Override
    public FileResult delete(String objectName) {
        // 根据BucketName,objectName删除文件
        ossClient.deleteObject(ossConfig.getBucketName(), objectName);
        FileResult result = new FileResult();
        result.setName(objectName);
        result.setStatus("removed");
        result.setResponse("success");
        return result;
    }

    /**
     * 下载文件
     *
     * @param os         操作系统
     * @param objectName 对象名称
     * @throws IOException ioexception
     */
    @Override
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

