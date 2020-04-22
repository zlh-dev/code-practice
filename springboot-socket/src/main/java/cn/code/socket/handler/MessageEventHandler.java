package cn.code.socket.handler;

import cn.code.socket.entity.MessageInfo;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 消息事件，作为后端与前台交互
 *
 * @author zlh-dev
 * @date 2020/04/18 17:15
 */
@Slf4j
@Component
public class MessageEventHandler {
    public static SocketIOServer socketIoServer;
    static ArrayList<UUID> listClient = new ArrayList<>();
    static final int LIMIT_SECONDS = 60;
    /**
     * 线程安全的map
     */
    public static ConcurrentHashMap<String, SocketIOClient> webSocketMap = new ConcurrentHashMap<>();

    @Autowired
    public MessageEventHandler(SocketIOServer server) {
        socketIoServer = server;
    }

    /**
     * 客户端连接
     * 客户端连接的时候触发.
     * 前端js触发：socket = io.connect("http://192.168.0.1:9090").
     *
     * @param client 客户端
     */
    @OnConnect
    public void onConnect(SocketIOClient client) {
        String mac = client.getHandshakeData().getSingleUrlParam("mac");
        listClient.add(client.getSessionId());
        //以mac地址为key,SocketIOClient 为value存入map,后续可以指定mac地址向客户端发送消息
        webSocketMap.put(mac, client);
        //socketIoServer.getClient(client.getSessionId()).sendEvent("message", "back data");
        log.info("客户端已连接: {}, 设备号: {}", client.getSessionId(), mac);
    }

    /**
     * 客户端下线
     * 客户端关闭连接时触发.
     * 前端js触发：socket.disconnect();
     *
     * @param client 客户端
     */
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        log.info("客户端已断开连接: {}", client.getSessionId());
    }

    /**
     * 自定义消息事件
     * 客户端js触发：socket.emit('messageEvent', {msgContent: msg}); 时触发
     * 前端js的 socket.emit("事件名","参数数据")方法，是触发后端自定义消息事件的时候使用的,
     * 前端js的 socket.on("事件名",匿名函数(服务器向客户端发送的数据))为监听服务器端的事件
     *
     * @param client  　客户端信息
     * @param request 请求信息
     * @param data    　客户端发送数据{msgContent: msg}
     */
    @OnEvent(value = "messageEvent")
    public void onEvent(SocketIOClient client, AckRequest request, MessageInfo data) {
        log.info("收到消息: {}", data);
        //服务器端向该客户端发送消息
        //socketIoServer.getClient(client.getSessionId()).sendEvent("messageevent", "你好 data");
        client.sendEvent("messageEvent", "我是服务器发送的信息");
    }

    /**
     * 向客户端推消息
     */
    public static void sendLogEvent() {
        String dateTime = new DateTime().toString("hh:mm:ss");
        for (UUID clientId : listClient) {
            if (ObjectUtil.isEmpty(socketIoServer.getClient(clientId))) {
                continue;
            }
            socketIoServer.getClient(clientId).sendEvent("enewbuy", "当前时间", dateTime);
        }

    }
}