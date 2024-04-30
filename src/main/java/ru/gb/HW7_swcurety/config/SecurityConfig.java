package ru.gb.HW7_swcurety.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 *  С помощью метода authorizeHttpRequests() мы настроим метод таким образом, каким пользователям
 * можно получить доступ к странице а каким нельзя
 *  antMatchers("/pablic/**") - задача этого метода - указать паттерн для этого метода
 * в котором он будет доступен без ауториз/автризации
 *  permitAll() - мы разрешаем доступ ко всем страницам находящихся по пути pablic.
 *  anyRequest().authenticated() - все остальные запросы которые есть на сервере будут доступны только
 * авторизованнным пользователям.
 *  formLogin() - форма включающая в себя аут/авторизацию
 *  Также мы указжем свою страницу - loginPage("form")
 *  Потом укажем что эта страница доступна для всех
 *  И выход из профиля тоже доступен всем logout().permitAll()
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                    authorizeHttpRequests().antMatchers("/public/**").permitAll().
                    anyRequest().authenticated().
                and().
                    formLogin().loginPage("/login").permitAll().
                and().
                    logout().permitAll();
    }
    /**
     * Далее создадим Bean который будет возвращать некоторую информацию о пользователе
     */
    @Bean
    public UserDetailsManager userDetailsManager(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.
                createUser(User.withDefaultPasswordEncoder().
                        username("user").
                        password("password").
                        roles("USER").
                        build());
        return manager;
    }
}
