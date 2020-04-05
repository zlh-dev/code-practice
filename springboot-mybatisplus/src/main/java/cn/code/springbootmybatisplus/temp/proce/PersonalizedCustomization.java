package cn.code.springbootmybatisplus.temp.proce;

import cn.code.springbootmybatisplus.temp.bean.FileContent;
import cn.code.springbootmybatisplus.temp.enums.TempType;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

public interface PersonalizedCustomization {

    /**
     * 文件类型统一处理
     * @return
     */
    FileContent distributionProcessing(InputStream templateInputStream, HttpServletRequest request);


    /**
     * 获取文件类型
     * @return
     */
    TempType getFileType();

}
