package de.baywa.tecb2bwebgwt.client.ui.page.privacy;

import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePagePresenter;
import de.baywa.tecb2bwebgwt.client.ui.navigation.NameTokens;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

/**
 * Activity/Presenter of the privacy page, implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class PrivacyPresenter extends Presenter<PrivacyPresenter.MyView, PrivacyPresenter.MyProxy> {

  public interface MyView extends View {
    /**
     * set html value of privacy page.
     *
     * @param pbranchId branch id to get html for
     */
    void setHtml(String pbranchId);
  }

  @ProxyCodeSplit
  @NameToken(NameTokens.PRIVACY)
  @NoGatekeeper
  public interface MyProxy extends ProxyPlace<PrivacyPresenter> {
  }

  /**
   * constructor injecting parameters.
   *
   * @param peventBus event bus
   * @param pview page view
   * @param pproxy page proxy
   */
  @Inject
  public PrivacyPresenter(final EventBus peventBus, final PrivacyPresenter.MyView pview,
      final MyProxy pproxy) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
    this.getView().setHtml(StringUtils.EMPTY);
  }
}
