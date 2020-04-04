package cn.code.springbootmybatisplus.controller;


import cn.code.springbootmybatisplus.service.AreasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 县级（区县） 前端控制器
 *
 * @author 张灵辉
 * @date 2020/03/27 23:32
 */
@Slf4j
@RestController
@RequestMapping("areas")
public class AreasController {

    @Autowired
    private AreasService areasService;

    @GetMapping("page")
    public void page() {

    }
}
