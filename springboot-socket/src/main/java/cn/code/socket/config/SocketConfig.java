package cn.code.socket.config;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * socketIo的运行类和启动类.
 *
 * @author zlh-dev
 * @date 2020/04/18 16:49
 */
@Configuration
public class SocketConfig {
    @Value("${socket.ip}")
    private String ip;
    @Value("${socket.port}")
    private int port;

    /**
     * socket-io配置
     *
     * @return {@link SocketIOServer}
     */
    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();

        config.setHostname(ip);

        config.setPort(port);
        config.setMaxFramePayloadLength(1024 * 1024);
        config.setMaxHttpContentLength(1024 * 1024);

        /*config.setAuthorizationListener(new AuthorizationListener() {//类似过滤器
            @Override
            public boolean isAuthorized(HandshakeData data) {
                //http://localhost:8081?username=test&password=test
                //例如果使用上面的链接进行connect，可以使用如下代码获取用户密码信息，本文不做身份验证
                // String username = data.getSingleUrlParam("username");
                // String password = data.getSingleUrlParam("password");
                return true;
            }
        });*/
        return new SocketIOServer(config);
    }

    /**
     * tomcat启动时候，扫描socket服务器并注册
     *
     * @param socketServer socket服务器
     * @return {@link SpringAnnotationScanner}
     */
    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
}
