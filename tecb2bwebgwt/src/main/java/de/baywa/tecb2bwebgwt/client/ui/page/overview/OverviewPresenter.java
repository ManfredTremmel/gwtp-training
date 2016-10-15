package de.baywa.tecb2bwebgwt.client.ui.page.overview;

import de.baywa.tecb2bwebgwt.client.ui.basepage.BasePagePresenter;
import de.baywa.tecb2bwebgwt.client.ui.navigation.NameTokens;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

/**
 * Activity/Presenter of the Start page, implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class OverviewPresenter extends Presenter<OverviewPresenter.MyView, OverviewPresenter.MyProxy> {

  public interface MyView extends View {
  }

  @ProxyCodeSplit
  @NameToken(NameTokens.OVERVIEW)
  public interface MyProxy extends ProxyPlace<OverviewPresenter> {
  }

  @Inject
  public OverviewPresenter(final EventBus pEventBus, final OverviewPresenter.MyView pView, final MyProxy pProxy) {
    super(pEventBus, pView, pProxy, BasePagePresenter.SLOT_MAIN_CONTENT);
  }
}
