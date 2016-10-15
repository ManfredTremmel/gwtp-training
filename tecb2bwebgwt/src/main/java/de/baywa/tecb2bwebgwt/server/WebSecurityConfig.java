package de.baywa.tecb2bwebgwt.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /**
   * configure security settings.
   *
   * @param phttp http security
   */
  @Override
  protected void configure(final HttpSecurity phttp) throws Exception { // NOPMD
    phttp.csrf().disable() //
        .authorizeRequests() //
        .antMatchers("/").permitAll() //
        .antMatchers("/**").permitAll(); //
  }
}
