package cn.code.temp.proce;

import cn.code.temp.bean.FileContent;
import cn.code.temp.enums.TempType;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * @author 王亚旭
 * @date 2020/4/05
 */
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
