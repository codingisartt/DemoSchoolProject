package com.tubanurbalci.demoschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

  @Bean
//    @Order(SecurityProperties.BASIC_AUTH_ORDER)
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
    http.csrf(csrf -> csrf.ignoringRequestMatchers("/saveMsg").ignoringRequestMatchers("/public/**").
            ignoringRequestMatchers("/api/**").ignoringRequestMatchers("/data-api/**")).
//                ignoringRequestMatchers(PathRequest.toH2Console()) // ). // dont
    authorizeHttpRequests((requests) -> requests.
        requestMatchers("/dashboard").authenticated(). // spring security default but readability
            requestMatchers("/displayMessages/**").hasRole("ADMIN").
        requestMatchers("/admin/**").hasRole("ADMIN").
        requestMatchers("/api/**").authenticated().
        requestMatchers("/data-api/**").authenticated().
        requestMatchers("/closeMsg/**").hasRole("ADMIN").
        requestMatchers("/displayProfile").authenticated().
        requestMatchers("/updateProfile").authenticated().
        requestMatchers("/student/**").hasRole("STUDENT").
        requestMatchers("/").permitAll().
        requestMatchers("/home").permitAll().
        requestMatchers("/holidays/**").permitAll().
//                        requestMatchers("/data-api/**").permitAll(). // for Rest HAL but not secure
//                        requestMatchers("/profile/**").permitAll(). // Rest HAL
//                        requestMatchers("/courseses/**").permitAll(). // Rest HAL
//                        requestMatchers("/contacts/**").permitAll(). // Rest HAL
    requestMatchers("/contact").permitAll().
        requestMatchers("/saveMsg").permitAll().
        requestMatchers("/courses").permitAll().
        requestMatchers("/about").permitAll().
        requestMatchers("/assets/**").permitAll().
//                        requestMatchers(PathRequest.toH2Console()).permitAll(). // dont
    requestMatchers("/login").permitAll().
        requestMatchers("/logout").permitAll().
//                        .requestMatchers(PathRequest.toH2Console()).permitAll()
    requestMatchers("/public/**").permitAll()
).formLogin(form -> form.loginPage("/login").
            defaultSuccessUrl("/dashboard").
            failureUrl("/login?error=true").
            permitAll())
        .logout(out -> out.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll());
    http.httpBasic(withDefaults());
//                http.headers(headersConfigurer -> headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  } // we generate hash value during the registration process

}
