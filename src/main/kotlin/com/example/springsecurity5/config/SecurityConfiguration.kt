package com.example.springsecurity5.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authz ->
            authz
               // .antMatchers("/hello").permitAll()
                .anyRequest().authenticated()
        }
            .httpBasic(withDefaults())
        return http.build()
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity -> web.ignoring().antMatchers("/hello") }
    }



}

// DEPRECATED
//@Configuration
//class SecurityConfiguration : WebSecurityConfigurerAdapter() {
//    @Throws(Exception::class)
//    override fun configure(http: HttpSecurity) {
//        http
//            .authorizeHttpRequests { authz ->
//                authz
//                    .antMatchers("/hello").permitAll()
//                    .anyRequest().authenticated()
//            }
//            .httpBasic(withDefaults())
//    }
//}