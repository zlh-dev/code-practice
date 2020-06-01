package cn.code.service.impl;

import cn.code.entity.FileInfo;
import cn.code.mapper.FileInfoMapper;
import cn.code.service.FileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public abstract class FileInfoServiceImpl implements FileInfoService {
    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Override
    public int createFile(FileInfo fileInfo) {
        return fileInfoMapper.insert(fileInfo);
    }

    @Override
    public int deleteFileById(List<String> fileIds) {
        return fileInfoMapper.deleteBatchIds(fileIds);
    }

    @Override
    public int modifyFileInfo(FileInfo fileInfo) {
        return fileInfoMapper.updateById(fileInfo);
    }

    @Override
    public int createFile(List<FileInfo> fileInfo) {
        return 0;
    }

    @Override
    public int modifyFileInfo(List<FileInfo> fileInfo) {
        return 0;
    }
}
