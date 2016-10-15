package de.baywa.tecb2bwebgwt.client.ui.page.login;

import de.baywa.tecb2bwebgwt.client.SessionData;
import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePagePresenter;
import de.baywa.tecb2bwebgwt.client.ui.navigation.NameTokens;
import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;
import de.baywa.tecb2bwebgwt.shared.dto.UserDto;
import de.baywa.tecb2bwebgwt.shared.rpc.LoginLogoutRemoteServiceAsync;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import java.util.ArrayList;

import de.knightsoftnet.validators.client.event.FormSubmitHandler;
import de.knightsoftnet.validators.shared.exceptions.ValidationException;

/**
 * Activity/Presenter of the login, implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {


  public interface MyView extends View, Editor<LoginDto>, FormSubmitHandler<LoginDto> {
    /**
     * set a reference to the presenter/activity.
     *
     * @param ppresenter reference to set
     */
    void setPresenter(LoginPresenter ppresenter);

    /**
     * fill the form with data.
     *
     * @param puser data to fill into the form
     */
    void fillForm(LoginDto puser);

    /**
     * set focus on first widget.
     */
    void setFocusOnFirstWidget();

    /**
     * display validation errors.
     *
     * @param perrors list of errors to display
     */
    void displayValidationErrors(ArrayList<ConstraintViolation<?>> perrors);
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
  private final LoginLogoutRemoteServiceAsync service;
  private final SessionData sessionData;

  /**
   * constructor injecting parameters.
   *
   * @param peventBus event bus
   * @param pview page view
   * @param pproxy page proxy
   * @param pservice remote user service
   * @param psessionData session data
   */
  @Inject
  public LoginPresenter(final EventBus peventBus, final LoginPresenter.MyView pview,
      final MyProxy pproxy, final LoginLogoutRemoteServiceAsync pservice,
      final SessionData psessionData) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
    this.service = pservice;
    this.sessionData = psessionData;
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
    this.service.login(this.loginData, new AsyncCallback<UserDto>() {

      @Override
      public void onFailure(final Throwable pcaught) {
        try {
          throw pcaught;
        } catch (final ValidationException e) {
          LoginPresenter.this.getView()
              .displayValidationErrors(e.getValidationErrorSet(LoginPresenter.this.loginData));
        } catch (final Throwable e) {
          Window.alert("Login failed: " + e.getMessage());
        }
      }

      @Override
      public void onSuccess(final UserDto presult) {
        LoginPresenter.this.sessionData.setUser(presult);
      }
    });
  }
}
