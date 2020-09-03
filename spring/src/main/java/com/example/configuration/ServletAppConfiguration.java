package com.example.configuration;

/*import javax.servlet.*;*/
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/*import org.springframework.web.*;*/
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.mapper.LogMapper;
import com.example.mapper.MemberMapper;
import com.example.mapper.PaymentMapper;

@Configuration
@EnableWebMvc
@ComponentScan("com.example")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppConfiguration implements WebMvcConfigurer {

	@Value("${db.classname}")
	private String db_classname;
	@Value("${db.url}")
	private String db_url;
	@Value("${db.username}")
	private String db_username;
	@Value("${db.password}")
	private String db_password;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/views/", ".jsp");

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");

	}

	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(db_classname);
		basicDataSource.setUrl(db_url);
		basicDataSource.setUsername(db_username);
		basicDataSource.setPassword(db_password);
		return basicDataSource;
	}

	@Bean
	public SqlSessionFactory factory(BasicDataSource basicDataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(basicDataSource);
		SqlSessionFactory factory = sqlSessionFactoryBean.getObject();
		return factory;
	}

	@Bean
	public MapperFactoryBean<MemberMapper> memberMapper(SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<MemberMapper> factoryBean = new MapperFactoryBean<>(MemberMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<PaymentMapper> paymentMapper(SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PaymentMapper> factoryBean = new MapperFactoryBean<>(PaymentMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<LogMapper> logMapper(SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<LogMapper> factoryBean = new MapperFactoryBean<>(LogMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}
}
