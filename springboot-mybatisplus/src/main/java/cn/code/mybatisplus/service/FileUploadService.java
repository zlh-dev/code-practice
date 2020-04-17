package cn.code.mybatisplus.service;

import cn.code.mybatisplus.temp.bean.FileContent;
import cn.code.mybatisplus.temp.enums.TempType;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传服务
 *
 * @author 王亚旭
 * @date 2020/04/06 23:51
 */
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
