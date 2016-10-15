package de.baywa.tecb2bwebgwt.client.ui.page.quickfind;

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
public class QuickFindPresenter
    extends Presenter<QuickFindPresenter.MyView, QuickFindPresenter.MyProxy> {

  public interface MyView extends View {
  }

  @ProxyCodeSplit
  @NameToken(NameTokens.QUICKFIND)
  public interface MyProxy extends ProxyPlace<QuickFindPresenter> {
  }

  @Inject
  public QuickFindPresenter(final EventBus peventBus, final QuickFindPresenter.MyView pview,
      final MyProxy pproxy) {
    super(peventBus, pview, pproxy, BasePagePresenter.SLOT_MAIN_CONTENT);
  }
}
