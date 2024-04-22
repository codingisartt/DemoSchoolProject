package com.tubanurbalci.demoschool.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

  @Bean
//    @Order(SecurityProperties.BASIC_AUTH_ORDER)
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
    http.csrf(csrf -> csrf.ignoringRequestMatchers(mvcMatcherBuilder.pattern("/saveMsg")).ignoringRequestMatchers(mvcMatcherBuilder.pattern("/public/**")).
            ignoringRequestMatchers(mvcMatcherBuilder.pattern("/api/**")).ignoringRequestMatchers(mvcMatcherBuilder.pattern("/data-api/**")).
                ignoringRequestMatchers(PathRequest.toH2Console()) ). // dont
    authorizeHttpRequests((requests) -> requests.
        requestMatchers(mvcMatcherBuilder.pattern("/dashboard")).authenticated(). // spring security default but readability
            requestMatchers(mvcMatcherBuilder.pattern("/displayMessages/**")).hasRole("ADMIN").
        requestMatchers(mvcMatcherBuilder.pattern("/admin/**")).hasRole("ADMIN").
        requestMatchers(mvcMatcherBuilder.pattern("/api/**")).authenticated().
        requestMatchers(mvcMatcherBuilder.pattern("/data-api/**")).authenticated().
        requestMatchers(mvcMatcherBuilder.pattern("/closeMsg/**")).hasRole("ADMIN").
        requestMatchers(mvcMatcherBuilder.pattern("/displayProfile")).authenticated().
        requestMatchers(mvcMatcherBuilder.pattern("/updateProfile")).authenticated().
        requestMatchers(mvcMatcherBuilder.pattern("/student/**")).hasRole("STUDENT").
        requestMatchers(mvcMatcherBuilder.pattern("/")).permitAll().
        requestMatchers(mvcMatcherBuilder.pattern("/home")).permitAll().
        requestMatchers(mvcMatcherBuilder.pattern("/holidays/**")).permitAll().
//                        requestMatchers(mvcMatcherBuilder.pattern("/data-api/**")).permitAll(). // for Rest HAL but not secure
//                        requestMatchers(mvcMatcherBuilder.pattern("/profile/**")).permitAll(). // Rest HAL
//                        requestMatchers(mvcMatcherBuilder.pattern("/courseses/**")).permitAll(). // Rest HAL
//                        requestMatchers(mvcMatcherBuilder.pattern("/contacts/**")).permitAll(). // Rest HAL
    requestMatchers(mvcMatcherBuilder.pattern("/contact")).permitAll().
        requestMatchers(mvcMatcherBuilder.pattern("/saveMsg")).permitAll().
        requestMatchers(mvcMatcherBuilder.pattern("/courses")).permitAll().
        requestMatchers(mvcMatcherBuilder.pattern("/about")).permitAll().
        requestMatchers(mvcMatcherBuilder.pattern("/assets/**")).permitAll().
                        requestMatchers(PathRequest.toH2Console()).permitAll(). // dont
    requestMatchers(mvcMatcherBuilder.pattern("/login")).permitAll().
        requestMatchers(mvcMatcherBuilder.pattern("/logout")).permitAll().
                        requestMatchers(PathRequest.toH2Console()).permitAll().
    requestMatchers(mvcMatcherBuilder.pattern("/public/**")).permitAll()
).formLogin(form -> form.loginPage("/login").
            defaultSuccessUrl("/dashboard").
            failureUrl("/login?error=true").
            permitAll())
        .logout(out -> out.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll());
    http.httpBasic(withDefaults());
                http.headers(headersConfigurer -> headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  } // we generate hash value during the registration process

}
