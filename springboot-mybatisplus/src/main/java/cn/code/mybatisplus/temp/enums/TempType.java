package cn.code.mybatisplus.temp.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 临时类型
 *
 * @author 王亚旭
 * @date 2020/04/06 23:53
 */
public enum TempType {
    /**
     * 中国行政办事处excel文件模板
     */
    ADMINISTRATIVE_OFFICE(FileType.EXC,"工作簿1.xlsx","工作簿1.xlsx")
    ;

    private String FILE_TEMPLATE_PATH_FORMAT="%s/%s";
    /**
     * 文件类行
     */
    private FileType fileType;
    /**
     * 原文件名
     */
    private String fileName;
    /**
     * 默认生成的文件名
     */
    private String defaultFileName;

    TempType(FileType fileType, String fileName, String defaultFileName) {
        this.fileType = fileType;
        this.fileName = fileName;
        this.defaultFileName = defaultFileName;
    }

    /**
     * 模板文件路径
     * @return
     */
    public String getFilePath(){
        return String.format(FILE_TEMPLATE_PATH_FORMAT,fileType.getType(),getFileName());
    }

    public String getFileName() {
        return fileName;
    }

    public FileType getFileType(){
        return fileType;
    }

    /**
     * h获取默认文件名
     * @return
     */
    public String getDefaultFileName() {
        return StringUtils.isBlank(defaultFileName) ? this.fileName : defaultFileName;
    }
}
