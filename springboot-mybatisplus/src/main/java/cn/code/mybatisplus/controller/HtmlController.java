package cn.code.mybatisplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面控制器
 *
 * @author zlh-dev
 * @date 2020/04/24 20:46
 */
@Controller
@RequestMapping("index")
public class HtmlController {

    @RequestMapping("provinces")
    public String provincesIndex() {
        return "provinces";
    }

}
