package com.trane.statTrack.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("app.properties")
@EnableJpaRepositories(basePackages = "com.trane.statTrack")
@ComponentScan({"com.trane.statTrack"})
public class DataConfig {

  @Autowired
  private Environment env;

  @Autowired
  public void setEnv(Environment env) {
    this.env = env;
  }

  private static final String DATABASE_DRIVER = "org.h2.Driver";
  private static final String DATABASE_PASSWORD = "";
  private static final String DATABASE_URL = "jdbc:h2:mem:statTrack";
  private static final String DATABASE_USERNAME = "sa";

  private static final String HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
  private static final String HIBERNATE_SHOWSQL = "hibernate.show_sql";

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    Resource config = new ClassPathResource("hibernate.cfg.xml");
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setConfigLocation(config);
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(new String[]{"com.trane.statTrack"});
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();

    ds.setUrl(env.getRequiredProperty("jdbc:h2:mem:statTrack"));
    ds.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
    ds.setUsername(env.getRequiredProperty(DATABASE_USERNAME));
    ds.setPassword(env.getRequiredProperty(DATABASE_PASSWORD));
    return ds;
  }


  private Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
    hibernateProperties.put(HIBERNATE_SHOWSQL, env.getRequiredProperty(HIBERNATE_SHOWSQL));
    hibernateProperties.put(HIBERNATE_HBM2DDL, env.getRequiredProperty(HIBERNATE_HBM2DDL));
    return hibernateProperties;
  }

  @Bean
  @Autowired
  public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    hibernateTransactionManager.setSessionFactory(sessionFactory);
    return hibernateTransactionManager;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                     JpaVendorAdapter jpaVendorAdapter) {

    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    emfb.setDataSource(dataSource);
    emfb.setJpaVendorAdapter(jpaVendorAdapter);
    emfb.setPackagesToScan("com.trane.statTrack.model");
    return emfb;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean
        factory = new LocalContainerEntityManagerFactoryBean();
    factory.setDataSource(dataSource());
    factory.setPackagesToScan("com.trane.statTrack.model");
    factory.setPersistenceUnitName("persistanceUnit");
    return factory;
  }

}