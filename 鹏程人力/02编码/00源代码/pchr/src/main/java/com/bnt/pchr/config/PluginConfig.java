package com.bnt.pchr.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 插件配置
 */
@Configuration
public class PluginConfig {

    @Bean
    public MybatisPlusInterceptor getMybatisPlusInterceptor(){
        MybatisPlusInterceptor  mybatisPlusInterceptor=new MybatisPlusInterceptor();
        List<InnerInterceptor> interceptors=new ArrayList<>();
        interceptors.add(new PaginationInnerInterceptor());
        mybatisPlusInterceptor.setInterceptors(interceptors);
        return mybatisPlusInterceptor;
    }
}
