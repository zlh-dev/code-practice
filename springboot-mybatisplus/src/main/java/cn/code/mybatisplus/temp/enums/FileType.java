package cn.code.mybatisplus.temp.enums;

/**
 * 文件类型
 *
 * @author 王亚旭
 * @date 2020/04/06 23:53
 */
public enum FileType {

    /**
     * world文档
     */
    DOC("worldtemplate"),
    /**
     * excel文档
     */
    EXC("exceltemplate"),
    /**
     * PDF文档
     */
    PDF("pdftemplate");
    private String type;

    FileType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
