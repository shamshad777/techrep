package com.org.spring.mvc;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.org.spring.*" })
@EnableTransactionManagement
public class Config extends WebMvcConfigurerAdapter {

	// Change has been made
	
	@Bean
	public ViewResolver CreateViewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");

		return resolver;

	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		System.out.println("mutipartresolver beans.");
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		// resolver.setDefaultEncoding("utf-8");
		resolver.setMaxUploadSize(1000000);

		return resolver;
	}

	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;

	}
	
	//another change
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/newdb");
		dataSource.setUsername("root");
		dataSource.setPassword("rootpass");
		return dataSource;

	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(ds);

		sessionFactory.setPackagesToScan("com.org.spring.hibernate");
		Properties prop = new Properties();

		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		sessionFactory.setHibernateProperties(prop);

		return sessionFactory;

	}

	@Bean
	public HibernateTemplate hibernateTemplate(SessionFactory sf) {

		HibernateTemplate hTemp = new HibernateTemplate(sf);

		return hTemp;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sf) {

		HibernateTransactionManager txManager = new HibernateTransactionManager(sf);

		return txManager;

	}

}
