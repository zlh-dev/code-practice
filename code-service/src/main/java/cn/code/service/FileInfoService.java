package cn.code.service;

import cn.code.entity.FileInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileInfoService extends IService<FileInfo> {

    /**
     * 创建文件
     *
     * @return {@link String}
     */
    int createFile(FileInfo fileInfo);

    /**
     * 根据id删除文件
     *
     * @param fileIds 文件的id
     * @return int
     */
    int deleteFileById(List<String> fileIds);

    /**
     * 修改文件信息
     *
     * @return {@link String}
     */
    int modifyFileInfo(FileInfo fileInfo);

    /**
     * 批量创建文件
     *
     * @return {@link String}
     */
    int createFile(List<FileInfo> fileInfo);

    /**
     * 批量修改文件信息
     *
     * @return {@link String}
     */
    int modifyFileInfo(List<FileInfo> fileInfo);

}
