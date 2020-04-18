package cn.code.oss.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 返回值
 *
 * @author zlh-dev
 * @date 2020/04/18 21:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileResult {

    /**
     * 文件唯一标识
     */
    private String uid;

    /**
     * 文件名
     */
    private String name;

    /**
     * 状态
     * uploading done error removed
     */
    private String status;

    /**
     * 服务端响应内容
     * 如：'{"status": "success"}'
     */
    private String response;
}

