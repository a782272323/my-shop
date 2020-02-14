package learn.lhb.my.shop.web.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 梁鸿斌
 * @date 2020/2/13.
 * @time 16:34
 */
@SpringBootApplication
//@MapperScan(value = "learn.lhb.my.shop.web.admin.dao") //扫描 dao
@EntityScan(basePackages = "learn.lhb.my.shop")
@ComponentScan(basePackages = "learn.lhb.my.shop")
public class WebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class,args);
    }
}
