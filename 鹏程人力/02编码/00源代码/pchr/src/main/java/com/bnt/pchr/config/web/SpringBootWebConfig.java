package com.bnt.pchr.config.web;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bnt.pchr.commons.converter.SqlDateConverter;
import com.bnt.pchr.commons.converter.UtilDateConverter;
import com.bnt.pchr.commons.util.RedisUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.ServletContext;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;

@Configuration
public class SpringBootWebConfig extends WebMvcConfigurationSupport {

    /**
     * 简历在线预览URL地址
     */
    @Value("${config.rescouce.online-preview}")
    private String onlinePreview;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //注册spring mvc拦截器
        //LoginCheckedInterceptor loginCheckedInterceptor = new LoginCheckedInterceptor();
        //registry.addInterceptor(loginCheckedInterceptor).addPathPatterns("/dep/**", "/emp/**").excludePathPatterns("/emp/query", "/dep/query");
    }

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        //注册数据类型转换器
        SqlDateConverter sqlDateConverter = new SqlDateConverter();
        UtilDateConverter utilDateConverter = new UtilDateConverter();
        registry.addConverter(sqlDateConverter);
        registry.addConverter(utilDateConverter);
    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //配置消息转换器---将控制器方法转成指定的格式---要加responseBody
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setCharset(Charset.forName("utf-8"));
        //设置序列化
        fastJsonConfig.setSerializerFeatures(
                WriteNullBooleanAsFalse,
                WriteNullListAsEmpty,
                WriteNullStringAsEmpty,
                WriteNullNumberAsZero,
                WriteDateUseDateFormat,
                WriteMapNullValue,
                PrettyFormat,
                DisableCircularReferenceDetect,
                BrowserCompatible
        );
        List<MediaType> mediaTypes = new ArrayList<>();
        //设置数mediaType媒体据格式
        mediaTypes.add(MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("utf-8"));
        converters.add(0, fastJsonHttpMessageConverter);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        //配置URL与页面模板对应关系(相当于访问控制器方法,然后跳转到页面)
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 配置Redis
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisUtils redisUtils(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        RedisUtils redisUtil = new RedisUtils();
        redisUtil.setRedisTemplate(template);
        return redisUtil;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setAttribute("onlinePreview",onlinePreview);
        super.setServletContext(servletContext);
    }
}