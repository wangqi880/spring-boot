package com.j.sessionconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @version 1.0 created by xxxx on 2018/5/20 23:11
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=600)
public class SessionConfig {
}
