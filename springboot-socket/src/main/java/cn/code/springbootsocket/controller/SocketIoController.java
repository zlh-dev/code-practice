package cn.code.springbootsocket.controller;

import cn.code.springbootsocket.util.Socketio;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 套接字Io控制器
 *
 * @author 张灵辉
 * @date 2020/04/05 14:19
 */
@RestController
@RequestMapping("sockets")
public class SocketIoController {
    /**
     * 测试报警推送服务:主要应用一个方法pushArr
     */
    @GetMapping("/pushMessage")
    @ApiOperation("测试消息推送")
    public void pushMessage() {
        Socketio socketio = new Socketio();
        //这里发送的消息内容可以结合具体场景自定义对象
        socketio.pushArr("connect_msg", "今天下午2点开会");
    }
}
