package com.glawler.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.UnknownHostException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.glawler.demo.controller")
public class ApplicationConfig {

  @Bean
  @Lazy
  public RedisConnectionFactory defaultRedisConnectionFactory() throws UnknownHostException {
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("redis", 6379);
    return new LettuceConnectionFactory(configuration);
  }

  @Bean
  @Lazy
  public ValueOperations getStringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    StringRedisTemplate redisTemplate = new StringRedisTemplate();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    return redisTemplate.opsForValue();
  }
}
