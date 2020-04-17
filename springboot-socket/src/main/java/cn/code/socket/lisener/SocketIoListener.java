package cn.code.socket.lisener;

import cn.code.socket.util.SocketIo;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * socket-io 监听器
 *
 * @author zlh-dev
 * @date 2020/04/05 14:19
 */
@Configuration
@WebListener
public class SocketIoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //启动Socketio服务
        SocketIo socketio = new SocketIo();
        socketio.startServer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //关闭Socketio服务
        SocketIo socketio = new SocketIo();
        socketio.stopSocketIo();
    }

}