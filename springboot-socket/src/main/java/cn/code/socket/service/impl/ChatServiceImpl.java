package cn.code.socket.service.impl;

import cn.code.socket.service.ChatService;
import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Service;

/**
 * 聊天服务impl
 *
 * @author zlh-dev
 * @date 2020/04/24 21:50
 */
@Service
public class ChatServiceImpl implements ChatService {

    private final static String AI_CHAT_URL = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";


    @Override
    public String aiChat(String keyword) {
        return HttpUtil.get(AI_CHAT_URL + keyword);
    }
}
