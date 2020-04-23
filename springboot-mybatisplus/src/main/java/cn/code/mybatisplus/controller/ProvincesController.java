package cn.code.mybatisplus.controller;


import cn.code.mybatisplus.common.Result;
import cn.code.mybatisplus.entity.Provinces;
import cn.code.mybatisplus.service.ProvincesService;
import com.github.pagehelper.PageHelper;
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

    @GetMapping("findPage")
    public Result findPage(int page, int size) {
        PageHelper.startPage(page, size);
        List<Provinces> data;
        try {
            data = provincesService.list();
            if (CollectionUtils.isEmpty(data)) {
                return Result.fail("未找到数据");
            }
        } catch (Exception e) {
            log.error("查找数据异常:{}", e.getMessage());
            return Result.fail("查找数据失败:" + e.getMessage());
        }
        return Result.success(data);
    }
}
