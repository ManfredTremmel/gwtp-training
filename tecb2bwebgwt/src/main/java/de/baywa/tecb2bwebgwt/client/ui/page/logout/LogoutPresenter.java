package de.baywa.tecb2bwebgwt.client.ui.page.logout;

import de.baywa.tecb2bwebgwt.client.SessionData;
import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePagePresenter;
import de.baywa.tecb2bwebgwt.client.ui.navigation.NameTokens;
import de.baywa.tecb2bwebgwt.shared.rpc.LoginLogoutRemoteServiceAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

import de.knightsoftnet.navigation.client.gatekeepers.LoggedInGatekeeper;

/**
 * Activity/Presenter of the logout, implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class LogoutPresenter extends Presenter<LogoutPresenter.MyView, LogoutPresenter.MyProxy> {

  public interface MyView extends View {
  }

  @ProxyStandard
  @NameToken(NameTokens.LOGOUT)
  @NoGatekeeper
  @UseGatekeeper(LoggedInGatekeeper.class)
  public interface MyProxy extends ProxyPlace<LogoutPresenter> {
  }

  private final LoginLogoutRemoteServiceAsync service;
  private final SessionData sessionData;

  /**
   * constructor injecting parameters.
   *
   * @param peventBus event bus
   * @param pview view of the page
   * @param pproxy proxy of the page
   * @param pservice user remote service
   * @param psessionData session data
   */
  @Inject
  public LogoutPresenter(final EventBus peventBus, final LogoutPresenter.MyView pview,
      final MyProxy pproxy, final LoginLogoutRemoteServiceAsync pservice,
      final SessionData psessionData) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
    this.service = pservice;
    this.sessionData = psessionData;
  }

  @Override
  protected void onReveal() {
    super.onReveal();
    this.service.logout(new AsyncCallback<Void>() {

      @Override
      public void onFailure(final Throwable pcaught) {
        // TODO Auto-generated method stub
      }

      @Override
      public void onSuccess(final Void presult) {
        // TODO Auto-generated method stub
      }
    });
    this.sessionData.setUser(null);
  }
}
