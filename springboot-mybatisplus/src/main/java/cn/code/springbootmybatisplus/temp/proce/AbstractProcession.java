package cn.code.springbootmybatisplus.temp.proce;

import cn.code.springbootmybatisplus.temp.bean.FileContent;
import cn.code.springbootmybatisplus.temp.enums.TempType;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author 王亚旭
 * @date 2020/4/05
 */
public abstract class AbstractProcession implements PersonalizedCustomization{

    @Override
    public FileContent distributionProcessing(InputStream templateInputStream, HttpServletRequest request) {
        //TODO world和PDF暂时未实现
        TempType tempType = getFileType();
        switch (tempType.getFileType()){
            case DOC:
                return null;
            case EXC :
                FileContent customize = customize(templateInputStream, request);
                return fileNameEnhancement(tempType,customize);
            case PDF :
                return null;
            default:throw new RuntimeException("模板为非指定的文件类型");
        }
    }

    /**
     * 自定义文件模板文件处理，动态渲染
     * @param templateInputStream 包含模板文件信息的输入流
     * @param request 请求对象
     * @return 包含文件数据
     * @throws Exception 异常
     */
    public abstract FileContent customize(InputStream templateInputStream,HttpServletRequest request);


    /**
     * 文件名增强
     *
     * 如果文件名不为空直接返回
     * 为空则使用默认文件名
     *
     * @param tempType
     * @param fileContent
     * @return
     */
    private FileContent fileNameEnhancement(TempType tempType,FileContent fileContent){

        if(Objects.nonNull(fileContent) && StringUtils.isNoneBlank(fileContent.getFileName())){
            return fileContent;
        }

        fileContent.setFileName(tempType.getDefaultFileName());
        return fileContent;
    }
}
