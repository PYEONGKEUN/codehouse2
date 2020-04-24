



package org.itbuddy.codehouse.config;





import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.DateTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = { "org.itbuddy.codehouse.DAO" })
@PropertySource({"classpath:profiles/${spring.profiles.active}/application.properties"})


public class DataSourceConfig{
	
	@Value("${db.url}")
	private String jdbcUrl;	
	@Value("${db.userName}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.driverClassName}")
	private String driverClassName;
	
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    
	@Bean
	public HikariDataSource dataSource() {
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/codehouse");
        config.setUsername(username);
        config.setPassword(password);
        config.setMinimumIdle(10);
        config.setMaximumPoolSize(40);
        config.setIdleTimeout(10000);
        config.setMaxLifetime(1000);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);

        return ds;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		 Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*DAO.xml");
		 sqlSessionFactory.setMapperLocations(res);
		 sqlSessionFactory.setTypeAliasesPackage("org.itbuddy.codehouse.DTO");
		 
		 sqlSessionFactory.setTypeHandlers(
				 new TypeHandler[] {
						 new DateTypeHandler(),
						 new BooleanTypeHandler()
						 }
				 );
		return sqlSessionFactory.getObject();
	}
	
    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
	
//	@Bean
//	public SqlSession sqlSession() throws Exception {
//		SqlSessionTemplate template=null;
//		try {
//			template = new SqlSessionTemplate(sqlSessionFactory());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new SqlSessionTemplate(sqlSessionFactory());
//	}

	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}





}	
