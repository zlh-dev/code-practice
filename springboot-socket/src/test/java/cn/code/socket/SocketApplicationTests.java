package cn.code.socket;

import cn.code.socket.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SocketApplicationTests {

    @Autowired
    private ChatService chatService;

    @Test
    void contextLoads() {
        String s = chatService.aiChat("杭州天气");
        System.out.println(s);
    }

}
