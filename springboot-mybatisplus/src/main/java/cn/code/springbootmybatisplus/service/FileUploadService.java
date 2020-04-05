package cn.code.springbootmybatisplus.service;

import cn.code.springbootmybatisplus.temp.bean.FileContent;
import cn.code.springbootmybatisplus.temp.enums.TempType;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {

    /**
     * 静态模板下载
     */
    FileContent staticTemplateDownload(TempType tempType)throws Exception;

    /**
     * 动态模板渲染
     * @param tempType 文件模板类型
     * @param request 请求对象
     * @return 文件信息
     * @throws Exception 异常
     */
    FileContent dynamicRendering(TempType tempType, HttpServletRequest request) throws Exception;
}
