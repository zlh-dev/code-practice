package cn.code.springbootsocket.lisener;

import cn.code.springbootsocket.util.Socketio;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author zlh-dev
 */
@Configuration
@WebListener
public class SocketIoListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //启动Socketio服务
        Socketio socketio = new Socketio();
        socketio.startServer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //关闭Socketio服务
        Socketio socketio = new Socketio();
        socketio.stopSocketIo();
    }

}