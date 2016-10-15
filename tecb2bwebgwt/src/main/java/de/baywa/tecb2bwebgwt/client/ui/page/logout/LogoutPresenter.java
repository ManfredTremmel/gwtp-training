package de.baywa.tecb2bwebgwt.client.ui.page.logout;

import de.baywa.tecb2bwebgwt.client.services.LoginLogoutRestService;
import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePagePresenter;
import de.baywa.tecb2bwebgwt.client.ui.navigation.NameTokens;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

import de.knightsoftnet.navigation.client.gatekeepers.LoggedInGatekeeper;
import de.knightsoftnet.navigation.client.session.Session;

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

  private final RestDispatch dispatcher;
  private final LoginLogoutRestService service;
  private final Session session;

  /**
   * constructor injecting parameters.
   *
   * @param peventBus event bus
   * @param pview view of the page
   * @param pproxy proxy of the page
   * @param pservice user remote service
   * @param psession session data
   */
  @Inject
  public LogoutPresenter(final EventBus peventBus, final LogoutPresenter.MyView pview,
      final MyProxy pproxy, final RestDispatch pdispatcher, final LoginLogoutRestService pservice,
      final Session psession) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
    this.dispatcher = pdispatcher;
    this.service = pservice;
    this.session = psession;
  }

  @Override
  protected void onReveal() {
    super.onReveal();
    this.dispatcher.execute(this.service.logout(), new AsyncCallback<Void>() {

      @Override
      public void onFailure(final Throwable pcaught) {
        // TODO Auto-generated method stub
      }

      @Override
      public void onSuccess(final Void presult) {
        // TODO Auto-generated method stub
      }
    });
    this.session.setUser(null);
  }
}
