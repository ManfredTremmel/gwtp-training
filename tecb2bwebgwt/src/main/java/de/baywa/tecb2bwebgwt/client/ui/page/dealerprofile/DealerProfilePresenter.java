package de.baywa.tecb2bwebgwt.client.ui.page.dealerprofile;

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
 * Activity/Presenter of the page, implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class DealerProfilePresenter
    extends Presenter<DealerProfilePresenter.MyView, DealerProfilePresenter.MyProxy> {

  public interface MyView extends View {
  }

  @ProxyCodeSplit
  @NameToken(NameTokens.DEALERPROFILE)
  public interface MyProxy extends ProxyPlace<DealerProfilePresenter> {
  }

  @Inject
  public DealerProfilePresenter(final EventBus peventBus, final DealerProfilePresenter.MyView pview,
      final MyProxy pproxy) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
  }
}
