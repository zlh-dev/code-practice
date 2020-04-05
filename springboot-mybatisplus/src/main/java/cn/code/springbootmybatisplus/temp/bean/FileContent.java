package cn.code.springbootmybatisplus.temp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 要到处的文件内容
 * @author 王亚旭
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileContent {

    /**
     * 包含文件内容的字节数组
     */
    private byte[] content;
    /**
     * 指定的文件名
     */
    private String fileName;
}