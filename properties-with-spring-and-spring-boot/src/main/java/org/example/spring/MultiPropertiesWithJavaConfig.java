package org.example.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
        @PropertySource("classpath:foo.properties"),
        @PropertySource("classpath:bar.properties")
})
public class MultiPropertiesWithJavaConfig {

    public MultiPropertiesWithJavaConfig() {
        super();
    }

    /**
     * 这个函数的作用是配置Spring Boot的属性源占位符解析器(Property Sources PlaceholderConfigurer)。
     * 通过在配置类中添加这个静态方法，并使用@Bean注解，
     * Spring容器会自动实例化并注册一个PropertySourcesPlaceholderConfigurer对象。
     * 这个对象负责解析应用程序中使用${}占位符的属性值，
     * 它会从不同的属性源（如application.properties、系统环境变量、命令行参数等）中查找对应的属性值，
     * 并将其替换到配置文件中。这样可以方便地在配置文件中使用动态属性，而不需要硬编码一些值。
     *
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}