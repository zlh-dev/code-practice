package cn.code.enums;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

public enum FileType {
    REGULAR("regular", "常规文件"),
    COMPRESS("compress", "压缩文件"),
    DOCUMENT("document", "文档"),
    PICTURE("picture", "图片"),
    PROGRAM("program", "程序"),
    VIDEO("video", "视频"),
    AUDIO("audio", "音频");

    private String type;
    private String desc;

    FileType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    /**
     * 得到文件类型
     *
     * @param sourceFileName 源文件名字
     * @return {@link FileType}
     */
    public static FileType getFileType(String sourceFileName) {
        // 截取后缀
        String suffix = StrUtil.subAfter(sourceFileName, ".", true).toLowerCase();
        // 原生实现
        // String suffix = sourceFileName.substring(sourceFileName.lastIndexOf(".") + 1).toLowerCase();

        // 压缩文件：zip rar arj gz sit sitx sea ace bz2 7z
        String[] compress = {"zip", "rar", "arj", "gz", "sit", "sitx", "sea", "ace", "bz2", "7z"};
        if (ArrayUtil.contains(compress, suffix)) {
            return FileType.COMPRESS;
        }

        // 图片：bmp,jpg,png,tif,gif,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw,wmf,webp
        String[] picture = {"bmp", "jpg", "png", "tif", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd", "cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf", "webp"};
        if (ArrayUtil.contains(picture, suffix)) {
            return FileType.PICTURE;
        }

        // 图片：mp3 wav wma mpa ram ra aac aif m4a tsa
        String[] audio = {"mp3", "wav", "wma", "mpa", "ram", "ra", "aac", "aif", "m4a", "tsa"};
        if (ArrayUtil.contains(audio, suffix)) {
            return FileType.AUDIO;
        }

        // 文档 doc pdf ppt pps docx pptx
        String[] document = {"doc", "pdf", "ppt", "pps", "docx", "pptx", "txt", "md"};
        if (ArrayUtil.contains(document, suffix)) {
            return FileType.DOCUMENT;
        }

        // 程序：exe msi rpm dpkg bin
        String[] program = {"exe", "msi", "rpm", "dpkg", "bin"};
        if (ArrayUtil.contains(program, suffix)) {
            return FileType.PROGRAM;
        }

        // 视频：avi mpg mpe mpeg asf wmv mov qt rm mp4 flv m4v webm ogv ogg mkv ts tsv
        String[] video = {"avi", "mpg", "mpe", "mpeg", "asf", "wmv", "mov", "qt", "rm", "mp4", "flv", "m4v", "webm", "ogv", "ogg", "mkv", "ts", "tsv"};
        if (ArrayUtil.contains(video, suffix)) {
            return FileType.VIDEO;
        }

        return FileType.REGULAR;
    }
}
