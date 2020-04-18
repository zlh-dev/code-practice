package cn.code.socket.lisener;

import cn.code.socket.server.SocketIoServer;
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
        //启动socket-io服务
        SocketIoServer socketIoServer = new SocketIoServer();
        socketIoServer.startServer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //关闭socket-io服务
        SocketIoServer socketIoServer = new SocketIoServer();
        socketIoServer.stopServer();
    }

}