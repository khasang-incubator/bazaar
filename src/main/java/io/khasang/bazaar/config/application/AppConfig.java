package io.khasang.bazaar.config.application;

import io.khasang.bazaar.dao.CatDao;
import io.khasang.bazaar.dao.CatWomanDao;
import io.khasang.bazaar.dao.ProductDao;
import io.khasang.bazaar.dao.impl.CatDaoImpl;
import io.khasang.bazaar.dao.impl.CatWomanDaoImpl;
import io.khasang.bazaar.dao.impl.ProductDaoImpl;
import io.khasang.bazaar.entity.Cat;
import io.khasang.bazaar.entity.CatWoman;
import io.khasang.bazaar.entity.Product;
import io.khasang.bazaar.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = "classpath:util.properties")
@PropertySource(value = "classpath:auth.properties")
public class AppConfig {
    @Autowired
    private Environment environment;

    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());
        jdbcDao.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        jdbcDao.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcDao;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.name"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public CreateTable createTable(){
        return new CreateTable(jdbcTemplate());
    }

    @Bean
    public CatDao catDao(){
        return new CatDaoImpl(Cat.class);
    }

    @Bean
    public CatWomanDao catWomanDao(){
        return new CatWomanDaoImpl(CatWoman.class);
    }

    @Bean
    public ProductDao productDao(){
        return new ProductDaoImpl(Product.class);
    }
}
