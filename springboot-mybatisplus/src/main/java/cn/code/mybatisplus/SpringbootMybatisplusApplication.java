package cn.code.mybatisplus;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Springboot入口
 *
 * @author zlh-dev
 * @date 2020/03/28 21:24
 */
@EnableKnife4j
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.code.mybatisplus.mapper")
public class SpringbootMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusApplication.class, args);
    }

}
