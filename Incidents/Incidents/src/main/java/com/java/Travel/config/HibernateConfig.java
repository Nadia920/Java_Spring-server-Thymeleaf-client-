package com.java.Travel.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration//Указывает, что класс объявляет один или несколько методов @Bean и может обрабатываться контейнером Spring для создания определений компонентов и запросов служб для этих компонентов во время выполнения, например:
@ComponentScan(basePackages = "com.java.Incidents")/*Настраивает директивы сканирования компонентов для использования с классами @Configuration. Обеспечивает поддержку параллельно с элементом Spring XML. <context:component-scan>
Для определения конкретных пакетов для сканирования можно указать либо basePackageClasses(), либо basePackages() (или его псевдоним value()). Если определенные пакеты не определены, сканирование будет происходить из пакета класса, объявляющего эту аннотацию.

        Обратите внимание, что элемент имеет атрибут; однако эта аннотация этого не делает. Это связано с тем, что почти во всех случаях при использовании , по умолчанию предполагается обработка конфигурации аннотации (например, обработка и друзья). Кроме того, при использовании AnnotationConfigApplicationContext обработчики конфигурации аннотаций всегда регистрируются, что означает, что любая попытка отключить их на этом уровне будет проигнорирована. <context:component-scan>annotation-config@ComponentScan@Autowired@ComponentScan*/
@EnableTransactionManagement//Включает возможность управления транзакциями Spring на основе аннотаций, аналогичную поддержке, найденной в пространстве имен XML Spring. Для использования на @Configuration классов для настройки традиционного, императивного управления транзакциями или реактивного управления транзакциями. <tx:*>
@PropertySource("classpath:application.yml")//Аннотация, предоставляющая удобный и декларативный механизм добавления PropertySource в среду Spring. Используется совместно с классами @Configuration.
public class HibernateConfig {

    @Value("${spring.datasource.platform}")
    private String platform;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("spring.datasource.platform", platform);
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.java.Incidents.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

}
