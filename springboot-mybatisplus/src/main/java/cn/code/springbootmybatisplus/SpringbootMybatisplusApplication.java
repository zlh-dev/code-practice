package cn.code.springbootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Springboot入口
 *
 * @author 张灵辉
 * @date 2020/03/28 21:24
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.code.springbootmybatisplus.mapper")
public class SpringbootMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusApplication.class, args);
    }

}
