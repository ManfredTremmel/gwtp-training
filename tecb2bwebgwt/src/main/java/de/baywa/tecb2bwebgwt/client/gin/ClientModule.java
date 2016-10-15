package de.baywa.tecb2bwebgwt.client.gin;

import de.baywa.tecb2bwebgwt.client.ui.navigation.NameTokens;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    this.install(new DefaultModule.Builder().defaultPlace(NameTokens.OVERVIEW)
        .errorPlace(NameTokens.LOGIN).unauthorizedPlace(NameTokens.LOGIN).build());

    this.install(new ApplicationModule());
  }
}
