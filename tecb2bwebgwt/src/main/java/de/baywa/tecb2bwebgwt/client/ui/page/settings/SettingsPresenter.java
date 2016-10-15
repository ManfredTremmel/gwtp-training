package de.baywa.tecb2bwebgwt.client.ui.page.settings;

import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePagePresenter;
import de.baywa.tecb2bwebgwt.client.ui.navigation.NameTokens;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

/**
 * Activity/Presenter of the settings.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class SettingsPresenter
    extends Presenter<SettingsPresenter.MyView, SettingsPresenter.MyProxy> {

  public interface MyView extends View {
    void setPresenter(SettingsPresenter pActivity);
  }

  @ProxyCodeSplit
  @NameToken(NameTokens.SETTINGS)
  @NoGatekeeper
  public interface MyProxy extends ProxyPlace<SettingsPresenter> {
  }

  @Inject
  public SettingsPresenter(final EventBus pEventBus, final SettingsPresenter.MyView pView,
      final MyProxy pProxy) {
    super(pEventBus, pView, pProxy, BasePagePresenter.SLOT_MAIN_CONTENT);
    this.getView().setPresenter(this);
  }

  public final void changeLanguage(final String pLanguage) {
    Cookies.setCookie(LocaleInfo.getLocaleCookieName(), pLanguage);
    Window.Location.reload();
  }
}
