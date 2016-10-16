package de.baywa.tecb2bwebgwt.server;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

/**
 * configuration of the url filter, it's used to redirect all pushstate urls (which don't realy
 * exists) to the index.html page.
 *
 * @author Manfred Tremmel
 */
@Configuration
public class FilterRegistrationConfig {

  /**
   * register filter bean.
   *
   * @return FilterRegistrationBean
   */
  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    final FilterRegistrationBean registrationBean = new FilterRegistrationBean();

    registrationBean.setFilter(new UrlRewriteFilter());
    registrationBean.addUrlPatterns("*");
    registrationBean.addInitParameter("confReloadCheckInterval", "5");
    registrationBean.addInitParameter("logLevel", "INFO");

    return registrationBean;
  }
}
