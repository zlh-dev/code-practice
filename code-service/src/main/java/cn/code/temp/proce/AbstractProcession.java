package cn.code.temp.proce;

import cn.code.temp.bean.FileContent;
import cn.code.temp.enums.TempType;
import cn.hutool.core.util.StrUtil;

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
            case PDF :
                return null;
            case EXC :
                FileContent customize = customize(templateInputStream, request);
                return fileNameEnhancement(tempType,customize);
            default:throw new RuntimeException("模板为非指定的文件类型");
        }
    }

    /**
     * 自定义文件模板文件处理，动态渲染
     * @param templateInputStream 包含模板文件信息的输入流
     * @param request 请求对象
     * @return 包含文件数据
     */
    public abstract FileContent customize(InputStream templateInputStream,HttpServletRequest request);


    /**
     * 文件名增强
     * <p>
     * 如果文件名不为空直接返回
     * 为空则使用默认文件名
     *
     * @param tempType    临时类型
     * @param fileContent 文件内容
     * @return {@link FileContent}
     */
    private FileContent fileNameEnhancement(TempType tempType,FileContent fileContent){

        if (Objects.nonNull(fileContent) && StrUtil.isNotBlank(fileContent.getFileName())) {
            return fileContent;
        }

        fileContent.setFileName(tempType.getDefaultFileName());
        return fileContent;
    }
}
