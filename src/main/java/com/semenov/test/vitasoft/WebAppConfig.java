package com.semenov.test.vitasoft;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan("com.semenov.test.vitasoft.controller")
public class WebAppConfig {

}