package de.baywa.tecb2bwebgwt.client.ui.page.remindlist;

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
public class RemindListPresenter
    extends Presenter<RemindListPresenter.MyView, RemindListPresenter.MyProxy> {

  public interface MyView extends View {
  }

  @ProxyCodeSplit
  @NameToken(NameTokens.REMINDLIST)
  public interface MyProxy extends ProxyPlace<RemindListPresenter> {
  }

  @Inject
  public RemindListPresenter(final EventBus peventBus, final RemindListPresenter.MyView pview,
      final MyProxy pproxy) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
  }
}
