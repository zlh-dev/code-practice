package cn.code.springbootmybatisplus.controller;


import cn.code.springbootmybatisplus.common.Result;
import cn.code.springbootmybatisplus.entity.Provinces;
import cn.code.springbootmybatisplus.service.ProvincesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 省级（省份直辖市自治区） 前端控制器
 *
 * @author 张灵辉
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
        List<Provinces> data;
        try {
            data = provincesService.list();
            if (CollectionUtils.isEmpty(data)) {
                return Result.fail("未找到数据");
            }
        } catch (Exception e) {
            log.error("查找所有数据异常:{}", e.getMessage());
            return Result.fail("查找所有数据失败:" + e.getMessage());
        }
        return Result.success(data);
    }
}