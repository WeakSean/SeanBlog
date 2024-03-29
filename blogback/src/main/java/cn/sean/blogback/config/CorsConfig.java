package cn.sean.blogback.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
@Configuration
public class CorsConfig {
    //当前跨域请求最大有效时长，默认1天
    private static final long MAX_AGE = 24 * 60 * 60;
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //设置访问源地址
        corsConfiguration.addAllowedOrigin("*");
        //设置访问源请求头
        corsConfiguration.addAllowedHeader("*");
        //设置访问源请求方法
        corsConfiguration.addAllowedMethod("*");
        //设置有效时长
        corsConfiguration.setMaxAge(MAX_AGE);
        //对接口配置跨域设置
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);
    }
}
