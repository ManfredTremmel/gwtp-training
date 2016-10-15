package de.baywa.tecb2bwebgwt.client.ui.basepage.footer;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class BasePageFooterPresenter
    extends Presenter<BasePageFooterPresenter.MyView, BasePageFooterPresenter.MyProxy> {

  public interface MyView extends View {
    void setPresenter(final BasePageFooterPresenter ppresenter);
  }

  @ProxyStandard
  @NoGatekeeper
  public interface MyProxy extends Proxy<BasePageFooterPresenter> {
  }

  /**
   * constructor injecting parameters.
   *
   * @param peventBus event bus
   * @param pview view of the page
   * @param pproxy proxy of the page
   */
  @Inject
  BasePageFooterPresenter(final EventBus peventBus, final MyView pview, final MyProxy pproxy) {
    super(peventBus, pview, pproxy);
    pview.setPresenter(this);
  }

  public void print() {
    Window.print();
  }
}
