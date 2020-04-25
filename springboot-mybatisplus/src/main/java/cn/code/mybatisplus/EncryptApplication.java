//package cn.code.mybatisplus;
//
//import org.jasypt.encryption.StringEncryptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.env.Environment;
//
///**
// * 配置信息加密启动类示例
// *
// * @author zlh-dev
// * @date 2020/04/25 13:12
// */
//@SpringBootApplication
//public class EncryptApplication implements CommandLineRunner {
//
//    @Autowired
//    private ApplicationContext appCtx;
//
//    @Autowired
//    private StringEncryptor codeSheepEncryptorBean;
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(EncryptApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Environment environment = appCtx.getBean(Environment.class);
//
//        // 首先获取配置文件里的原始明文信息
//        String mysqlOriginUsername = environment.getProperty("spring.datasource.username");
//        String mysqlOriginPassword = environment.getProperty("spring.datasource.password");
//
//        // 加密
//        String mysqlEncryptedUsername = encrypt(mysqlOriginUsername);
//        String redisEncryptedPassword = encrypt(mysqlOriginPassword);
//
//        // 打印加密前后的结果对比
//        System.out.println("MySQL原始明文用户名为：" + mysqlOriginUsername);
//        System.out.println("MySQL原始明文密码为：" + mysqlOriginPassword);
//        System.out.println("====================================");
//        System.out.println("MySQL原始明文用户名加密后的结果为：" + mysqlEncryptedUsername);
//        System.out.println("MySQL原始明文密码加密后的结果为：" + redisEncryptedPassword);
//    }
//
//    private String encrypt(String origin) {
//        return codeSheepEncryptorBean.encrypt(origin);
//    }
//
//    private String decrypt(String encrypted) {
//        return codeSheepEncryptorBean.decrypt(encrypted);
//    }
//}
