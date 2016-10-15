package de.baywa.tecb2bwebgwt.client.ui.basepage.header;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class BasePageHeaderPresenter
    extends Presenter<BasePageHeaderPresenter.MyView, BasePageHeaderPresenter.MyProxy> {

  public interface MyView extends View {
    void setHeaderText(final String ptext);
  }

  @ProxyStandard
  @NoGatekeeper
  public interface MyProxy extends Proxy<BasePageHeaderPresenter> {
  }

  /**
   * constructor injecting parameters.
   *
   * @param peventBus event bus
   * @param pview view of the page
   * @param pproxy proxy of the page
   */
  @Inject
  public BasePageHeaderPresenter(final EventBus peventBus, final MyView pview,
      final MyProxy pproxy) {
    super(peventBus, pview, pproxy);
  }
}
