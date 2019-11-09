package com.sys.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.sys.converter.DateConverter;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
@MapperScan("com.app.dao")
@PropertySource("classpath:application.properties")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {



    @Autowired
   private org.springframework.core.env.Environment environment;

    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }
    /*
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**","/login/**","/signup/**");
    }
    */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        registry.viewResolver(resolver);
    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
       Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().indentOutput(true).dateFormat(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        );
        ObjectMapper objectMapper = builder.build();
        MappingJackson2HttpMessageConverter converter
                = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(converter);
    }

    @Bean
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));

        PageInterceptor pageInterceptor = new PageInterceptor();
       /* Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        */
        factoryBean.setPlugins(new Interceptor[]{pageInterceptor});




        return  factoryBean.getObject();

    }
    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;

    }

}
