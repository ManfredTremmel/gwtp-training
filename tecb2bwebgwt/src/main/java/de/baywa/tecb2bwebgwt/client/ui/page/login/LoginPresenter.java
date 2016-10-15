package de.baywa.tecb2bwebgwt.client.ui.page.login;

import de.baywa.tecb2bwebgwt.client.services.LoginLogoutRestService;
import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePagePresenter;
import de.baywa.tecb2bwebgwt.client.ui.navigation.NameTokens;
import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;
import de.baywa.tecb2bwebgwt.shared.dto.UserDto;

import com.google.gwt.core.client.Scheduler;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

import de.knightsoftnet.navigation.client.session.Session;
import de.knightsoftnet.validators.client.event.FormSubmitHandler;
import de.knightsoftnet.validators.client.rest.helper.AbstractRestCallback;
import de.knightsoftnet.validators.client.rest.helper.EditorWithErrorHandling;

/**
 * Activity/Presenter of the login, implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {


  public interface MyView
      extends EditorWithErrorHandling<LoginPresenter, LoginDto>, FormSubmitHandler<LoginDto> {
  }


  @ProxyStandard
  @NameToken(NameTokens.LOGIN)
  @NoGatekeeper
  public interface MyProxy extends ProxyPlace<LoginPresenter> {
  }

  /**
   * loginData data to remember.
   */
  private final LoginDto loginData;
  private final RestDispatch dispatcher;
  private final LoginLogoutRestService service;
  private final Session session;

  /**
   * constructor injecting parameters.
   *
   * @param peventBus event bus
   * @param pview page view
   * @param pproxy page proxy
   * @param pservice remote user service
   * @param psession session data
   */
  @Inject
  public LoginPresenter(final EventBus peventBus, final LoginPresenter.MyView pview,
      final MyProxy pproxy, final RestDispatch pdispatcher, final LoginLogoutRestService pservice,
      final Session psession) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
    this.dispatcher = pdispatcher;
    this.service = pservice;
    this.session = psession;
    this.loginData = new LoginDto();
    this.getView().setPresenter(this);
    this.getView().fillForm(this.loginData);
  }

  @Override
  protected void onReveal() {
    super.onReveal();
    Scheduler.get().scheduleDeferred(() -> LoginPresenter.this.getView().setFocusOnFirstWidget());
  }

  /**
   * try to login with form data.
   */
  public final void tryToLogin() {
    this.dispatcher.execute(this.service.login(this.loginData),
        new AbstractRestCallback<LoginPresenter, LoginDto, MyView, UserDto>(this.getView(),
            this.loginData, this.session) {

          @Override
          public void onSuccess(final UserDto presult) {
            LoginPresenter.this.session.setUser(presult);
          }
        });
  }
}
