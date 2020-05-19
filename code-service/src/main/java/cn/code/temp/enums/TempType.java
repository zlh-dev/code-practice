package cn.code.temp.enums;

import cn.hutool.core.util.StrUtil;

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
    ADMINISTRATIVE_OFFICE(FileType.EXC, "工作簿1.xlsx", "工作簿1.xlsx");

    private final String FILE_TEMPLATE_PATH_FORMAT = "%s/%s";
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
     *
     * @return {@link String}
     */
    public String getFilePath() {
        return String.format(FILE_TEMPLATE_PATH_FORMAT, fileType.getType(), getFileName());
    }

    public String getFileName() {
        return fileName;
    }

    public FileType getFileType() {
        return fileType;
    }

    /**
     * 获取默认文件名
     *
     * @return {@link String}
     */
    public String getDefaultFileName() {
        return StrUtil.isBlank(defaultFileName) ? this.fileName : defaultFileName;
    }
}
