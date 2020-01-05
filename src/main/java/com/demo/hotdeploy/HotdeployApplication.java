package com.demo.hotdeploy;

import com.demo.hotdeploy.config.MapperRefresh;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.Executors;


@MapperScan(basePackages = {"com.demo.hotdeploy.emp.mapper"})
@SpringBootApplication
public class HotdeployApplication extends SpringBootServletInitializer {


    @Autowired
    private SqlSession sqlSession;
    public static void main(String[] args) {
        SpringApplication.run(HotdeployApplication.class, args);


    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        builder.registerShutdownHook(false);
        return builder.sources(HotdeployApplication.class);
    }

    //mybatis热部署
    @PostConstruct
    public void postConstruct() throws IOException {
        Executors.newFixedThreadPool(20);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*Mapper.xml");
        new MapperRefresh(resources, sqlSession.getConfiguration()).run();
    }
}
