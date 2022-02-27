/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.configuration;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 *
 * @author ewawuye
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages ={"com.zema.isms"})
//@PropertySource("classpath:massages.properties")
public class IamsWebConfig implements WebMvcConfigurer {
      private final int maxUploadSizeInMb = 25* 1024 * 1024; // 25 MB
      private final int UploadSizeInMb = 30* 1024 * 1024; //  30MB
      
       @Override
    public void addResourceHandlers(ResourceHandlerRegistry reg) { 
        //css, javascript... file in static follder
        reg.addResourceHandler("/resource/**").addResourceLocations("/resource/");
        //to handel resource add by webjars.. bootstrap ,jquery..
       reg.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setViewClass(JstlView.class);
        vr.setPrefix("/WEB-INF/pages/");
        vr.setSuffix(".jsp");
        return vr;
    }
@Bean
public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    //resolver.setMaxUploadSize(maxUploadSizeInMb);
    
resolver.setMaxUploadSizePerFile(UploadSizeInMb);
//resolver.setMaxUploadSizePerFile(maxUploadSizeInMb);
    resolver.setDefaultEncoding("utf-8");
     return resolver;
}

   @Bean("messageSource")
   public MessageSource messageSource() {
      ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
      messageSource.setBasename("classpath:locale/messages");
      messageSource.setDefaultEncoding("UTF-8");
      messageSource.setUseCodeAsDefaultMessage(true);
      return messageSource;
   }

   @Bean
   public LocaleResolver localeResolver() {

      
      
   SessionLocaleResolver localeResolver =  new SessionLocaleResolver();
   localeResolver.setDefaultLocale(new Locale("en"));
     // localeResolver.setDefaultLocale(new Locale("en"));
      return localeResolver;
   }

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
     LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
      localeChangeInterceptor.setParamName("lang");
      registry.addInterceptor(localeChangeInterceptor);
   }

}
