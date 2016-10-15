package de.baywa.tecb2bwebgwt.client.gin;

import de.baywa.tecb2bwebgwt.client.ui.page.login.LoginPresenter;
import de.baywa.tecb2bwebgwt.client.ui.page.login.LoginViewImpl;
import de.baywa.tecb2bwebgwt.shared.rpc.LoginLogoutRemoteServiceAsync;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    this.bindPresenter(LoginPresenter.class, LoginPresenter.MyView.class, LoginViewImpl.class,
        LoginPresenter.MyProxy.class);
    this.bind(LoginLogoutRemoteServiceAsync.class).in(Singleton.class);
  }
}
