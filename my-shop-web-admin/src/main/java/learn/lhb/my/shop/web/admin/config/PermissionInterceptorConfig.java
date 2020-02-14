//package learn.lhb.my.shop.web.admin.config;
//
//import learn.lhb.my.shop.web.admin.interceptor.PermissionInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 权限拦截器配置
// *
// * @author 梁鸿斌
// * @date 2020/2/14.
// * @time 02:41
// */
//public class PermissionInterceptorConfig implements WebMvcConfigurer {
//
//    @Bean
//    PermissionInterceptor permissionInterceptor()   {
//        return new PermissionInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(permissionInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/static");
//    }
//}
