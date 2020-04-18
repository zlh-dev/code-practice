package cn.code.socket.server;

import cn.hutool.core.thread.ThreadUtil;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;

/**
 * socket-io服务类 创建、添加和启动客户端 消息推送 关闭服务
 *
 * @author zlh-dev
 * @date 2020/04/05 14:15
 */
public class SocketIoServer {

    @Value("${socket.config.host-name}")
    private String hostName;

    @Value("${socket.config.port}")
    private int port;

    @Value("${socket.config.max-frame-payload-length}")
    private int maxFramePayloadLength;

    @Value("${socket.config.max-http-content-length}")
    private int maxHttpContentLength;

    private static SocketIOServer socketIOServer;

    /**
     * 创建服务添加客户端
     */
    public void startSocketIo() {

        // 配置
        Configuration conf = new Configuration();
        // 指定要主机ip地址，这个和页面请求ip地址一致
        conf.setHostname(hostName);
        // 指定端口号
        conf.setPort(port);
        // 设置最大的WebSocket帧内容长度限制
        conf.setMaxFramePayloadLength(maxFramePayloadLength);
        // 设置最大HTTP内容长度限制
        conf.setMaxHttpContentLength(maxHttpContentLength);

        socketIOServer = new SocketIOServer(conf);

        ConnectListener connect = client -> {
        };
        // 添加客户端
        socketIOServer.addConnectListener(connect);
        socketIOServer.start();
    }

    /**
     * 全体消息推送
     *
     * @param type    前台根据类型接收消息，所以接收的消息类型不同，收到的通知就不同 推送的事件类型
     * @param content 推送的内容
     */
    public void pushArr(String type, Object content) {
        // 获取全部客户端
        Collection<SocketIOClient> allClients = socketIOServer.getAllClients();
        for (SocketIOClient socket : allClients) {
            socket.sendEvent(type, content);
        }
    }

    /**
     * 启动服务
     */
    public void startServer() {
        if (ObjectUtils.isEmpty(socketIOServer)) {
//            new Thread(this::startSocketIo).start();
            ThreadUtil.execute(this::startSocketIo);
        }
    }

    /**
     * 停止服务
     */
    public void stopServer() {
        if (ObjectUtils.isNotEmpty(socketIOServer)) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }

}