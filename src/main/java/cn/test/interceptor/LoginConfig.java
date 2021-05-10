package cn.test.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Package: cn.test.interceptor
 * @Description:拦截器配置
 * @Author Wh
 * @Create 2021年05月02日 17时33分45秒
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        registry.addInterceptor(new SysInterceptor())
        .addPathPatterns("/**")                      //所有路径都被拦截
        .excludePathPatterns(                         //添加不拦截路径
                "/",
                "/login",                //登录
                "/doLogin",
                "/index",
                "/500",
                "/403",
                "/**/*.html",            //html静态资源
                "/**/*.js",              //js静态资源
                "/**/*.css",             //css静态资源
                "/css/**",
                "/fonts/**",
                "/images/**",
                "/js/**",
                "/localcss/**",
                "/localjs/**",
                "/uploadfiles/**"
        );
    }

}
