package se.jensen.project.department.test.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
@TestConfiguration
public class LiquibaseTestConfigurer {
    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource dataSource;

    @Bean
    @DependsOn
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase/liquibase-changelog.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}
