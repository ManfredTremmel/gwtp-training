package de.baywa.tecb2bwebgwt.client.ui.page.detailsandsearch;

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
public class DetailsAndSearchPresenter
    extends Presenter<DetailsAndSearchPresenter.MyView, DetailsAndSearchPresenter.MyProxy> {

  public interface MyView extends View {
  }

  @ProxyCodeSplit
  @NameToken(NameTokens.DETAILSANDSEARCH)
  public interface MyProxy extends ProxyPlace<DetailsAndSearchPresenter> {
  }

  @Inject
  public DetailsAndSearchPresenter(final EventBus peventBus,
      final DetailsAndSearchPresenter.MyView pview, final MyProxy pproxy) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
  }
}
