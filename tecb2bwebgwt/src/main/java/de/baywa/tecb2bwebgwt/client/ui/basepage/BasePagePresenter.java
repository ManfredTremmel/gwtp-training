package de.baywa.tecb2bwebgwt.client.ui.basepage;

import de.baywa.tecb2bwebgwt.client.ui.basepage.footer.BasePageFooterPresenter;
import de.baywa.tecb2bwebgwt.client.ui.basepage.header.BasePageHeaderPresenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

import de.knightsoftnet.navigation.client.ui.navigation.NavigationPresenter;

/**
 * Activity/Presenter of the base page, implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class BasePagePresenter
    extends Presenter<BasePagePresenter.MyView, BasePagePresenter.MyProxy> {

  public interface MyView extends View {
  }

  @ProxyStandard
  @NoGatekeeper
  public interface MyProxy extends Proxy<BasePagePresenter> {
  }

  private final BasePageHeaderPresenter basePageHeaderPresenter;
  private final NavigationPresenter navigationPresenter;
  private final BasePageFooterPresenter basePageFooterPresenter;

  /**
   * Use this in leaf presenters, inside their {@link #revealInParent} method.
   */
  public static final NestedSlot SLOT_MAIN_CONTENT = new NestedSlot();

  public static final PermanentSlot<BasePageHeaderPresenter> SLOT_HEADER = new PermanentSlot<>();
  public static final PermanentSlot<NavigationPresenter> SLOT_NAVIGATION = new PermanentSlot<>();
  public static final PermanentSlot<BasePageFooterPresenter> SLOT_FOOTER = new PermanentSlot<>();

  /**
   * constructor injecting parameters.
   *
   * @param pEventBus event bus
   * @param pView view of the page
   * @param pProxy proxy of the page
   * @param pBasePageHeaderPresenter presenter of the base page header
   * @param pNavigationPresenter presenter of the navigation
   * @param pBasePageFooterPresenter presenter of the base page footer
   */
  @Inject
  public BasePagePresenter(final EventBus pEventBus, final BasePagePresenter.MyView pView,
      final MyProxy pProxy, final BasePageHeaderPresenter pBasePageHeaderPresenter,
      final NavigationPresenter pNavigationPresenter,
      final BasePageFooterPresenter pBasePageFooterPresenter) {
    super(pEventBus, pView, pProxy, RevealType.Root);
    this.basePageHeaderPresenter = pBasePageHeaderPresenter;
    this.navigationPresenter = pNavigationPresenter;
    this.basePageFooterPresenter = pBasePageFooterPresenter;
  }


  @Override
  protected void onBind() {
    super.onBind();
    this.setInSlot(BasePagePresenter.SLOT_HEADER, this.basePageHeaderPresenter);
    this.setInSlot(BasePagePresenter.SLOT_NAVIGATION, this.navigationPresenter);
    this.setInSlot(BasePagePresenter.SLOT_FOOTER, this.basePageFooterPresenter);
  }
}
