package com.example.config.DynamicDateSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 重写SqlSessionFactory
 * @author:gaoguangjin
 * @date 2016/5/30 11:18
 */
@Configuration
@MapperScan(basePackages = {"com.example.mastermapper","com.example.mapper"})
public class MybatisConfiguration extends MybatisAutoConfiguration {

	@Autowired
	private Environment environment;




	@Bean
	public DataSource slaveDataSource() throws Exception {
		Properties props = new Properties();
		props.put("driverClassName", environment.getProperty("spring.datasource2.driver-class-name"));
		props.put("url", environment.getProperty("spring.datasource2.url"));
		props.put("username", environment.getProperty("spring.datasource2.username"));
		props.put("password", environment.getProperty("spring.datasource2.password"));
		return DruidDataSourceFactory.createDataSource(props);
	}

	@Bean
	public DataSource masterDataSource() throws Exception {
		Properties props = new Properties();
		props.put("driverClassName", environment.getProperty("spring.datasource.driver-class-name"));
		props.put("url", environment.getProperty("spring.datasource.url"));
		props.put("username", environment.getProperty("spring.datasource.username"));
		props.put("password", environment.getProperty("spring.datasource.password"));
		return DruidDataSourceFactory.createDataSource(props);
	}


	/*spring-boot-starter-parent架包升级到1.4.0.RELEASE 解决循环依赖问题*/
	/*@ConditionalOnBean({AbstractRoutingDataSource.class})*/
	@Bean
	public SqlSessionFactory sqlSessionFactorys(@Qualifier("roundRobinDataSouceProxy")DynamicDataSource roundRobinDataSouceProxy) throws Exception {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		PageHelper pageHelper = new PageHelper();
		Properties props = new Properties();
		props.setProperty("reasonable", "true");
		props.setProperty("supportMethodsArguments", "true");
		props.setProperty("returnPageInfo", "check");
		props.setProperty("params", "count=countSql");
		pageHelper.setProperties(props);
		fb.setPlugins(new Interceptor[]{pageHelper});
		fb.setDataSource(roundRobinDataSouceProxy);
		// 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
		fb.setTypeAliasesPackage("com.example.domain");// 指定基包
		fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
		return fb.getObject();
	}


	/**
	 * 有多少个数据源就要配置多少个bean
	 * @return
	 */
	@Bean(name = "roundRobinDataSouceProxy")
	@Primary //指定在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@Autowire注解报错（一般用于多数据源的情况下）
	public DynamicDataSource roundRobinDataSouceProxy(@Qualifier("slaveDataSource") DataSource slaveDataSource,@Qualifier("masterDataSource") DataSource masterDataSource) {
		DynamicDataSource proxy = new DynamicDataSource();
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		// 写
		targetDataSources.put(DataSources.SLAVE, slaveDataSource);
		proxy.setDefaultTargetDataSource(masterDataSource);
		proxy.setTargetDataSources(targetDataSources);
		return proxy;
	}


	/**
	 * 配置事务管理器
	 */
     @Bean
	 public DataSourceTransactionManager transactionManager(@Qualifier("roundRobinDataSouceProxy")DynamicDataSource dataSource) throws Exception {
		 return new DataSourceTransactionManager(dataSource);
	 }
	
}
