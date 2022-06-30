package com.java.Travel.config;


import com.java.Travel.security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;//Используется exceptionTranslationFilter для обработки платформы .AccessDeniedException

    @Autowired
    private UserDetailsService customUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/MenuUser").hasAnyRole("USER")
                .antMatchers("/MenuAdmin", "/addDetachment", "/showDetachment", "/PageIncidentLogAdd", "/showIncidentLog", "/MenuAdmin").hasAnyRole("ADMIN")
                .antMatchers("/MenuUser", "/PageIncidentAdd", "/ProblemsAdd", "/showAppRating").hasAnyRole("USER")
                .antMatchers("/MenuWorker", "/report", "/getReport").hasAnyRole("WORKER")
                .antMatchers("/addFixedDetachment", "/showIncidents", "/showIncidentsTrue", "/showIncidentsFalse", "/showAllIncidents").hasAnyRole("ADMIN", "USER", "WORKER")
                .antMatchers("/home").hasAnyRole("WORKER", "USER", "ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home")
                .and().logout().permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(getPasswordEncoder());
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        };
    }
}
