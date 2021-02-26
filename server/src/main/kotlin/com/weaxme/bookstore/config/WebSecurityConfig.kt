package com.weaxme.bookstore.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class WebSecurityConfig {
    @Bean
    fun securityWebChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .csrf().disable()
            .authorizeExchange()
            .anyExchange().authenticated()
            .and()
            .httpBasic()
            .and()
            .formLogin().disable()
            .build()
    }

    @Bean
    fun userDetailsService(encoder: PasswordEncoder): MapReactiveUserDetailsService {
        val userDetails = User
            .withUsername("user")
            .password("user")
            .passwordEncoder(encoder::encode)
            .roles("USER")
            .build()
        return MapReactiveUserDetailsService(userDetails)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }
}
