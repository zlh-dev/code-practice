package cn.code.controller;

import cn.code.common.CommonResult;
import cn.code.entity.FileInfo;
import cn.code.service.FileInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("file")
public class FileInfoController {

    @Autowired
    private FileInfoService fileInfoService;

    /**
     * 文件列表页面
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return {@link CommonResult<PageInfo<FileInfo>>}
     */
    @GetMapping("page")
    public CommonResult<PageInfo<FileInfo>> fileListPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FileInfo> fileList = fileInfoService.list();
        PageInfo<FileInfo> pageInfo = new PageInfo<>(fileList);
        return CommonResult.success(pageInfo);
    }

    /**
     * 搜索文件
     *
     * @param fileInfo 文件信息
     * @return {@link CommonResult<PageInfo<FileInfo>>}
     */
    @GetMapping("search")
    public CommonResult<PageInfo<FileInfo>> searchFile(FileInfo fileInfo) {
        List<FileInfo> fileList = fileInfoService.list();
        PageInfo<FileInfo> pageInfo = new PageInfo<>(fileList);
        return CommonResult.success(pageInfo);
    }


}
