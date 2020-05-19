package cn.code.controller;


import cn.code.common.Result;
import cn.code.service.ProvincesService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 省级（省份直辖市自治区） 前端控制器
 *
 * @author zlh-dev
 * @date 2020/03/27 23:33
 */
@Slf4j
@RestController
@RequestMapping("provinces")
public class ProvincesController {

    @Autowired
    private ProvincesService provincesService;

    @GetMapping("findAll")
    public Result findAll() {
        return Result.success(provincesService.list());
    }

    @GetMapping("findPage")
    public Result findPage(int page, int size) {
        PageHelper.startPage(page, size);
        return Result.success(provincesService.list());
    }
}
