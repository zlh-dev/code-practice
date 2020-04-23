package cn.code.mybatisplus;

import cn.code.mybatisplus.entity.Provinces;
import cn.code.mybatisplus.service.ProvincesService;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private ProvincesService provincesService;

    @Test
    void contextLoads() {
        PageHelper.startPage(1, 3);
        List<Provinces> data = provincesService.list();
        System.out.println(data.toString());
    }

}
