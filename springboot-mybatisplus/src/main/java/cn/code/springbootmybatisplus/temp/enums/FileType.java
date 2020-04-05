package cn.code.springbootmybatisplus.temp.enums;

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
