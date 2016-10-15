package de.baywa.tecb2bwebgwt.client.ui.basepage.footer;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the base page footer.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class BasePageFooterImpl extends ViewImpl implements BasePageFooterPresenter.MyView {

  interface Binder extends UiBinder<Widget, BasePageFooterImpl> {
  }

  private BasePageFooterPresenter presenter;

  /**
   * constructor injecting fields.
   *
   * @param puiBinder ui binder of the page
   */
  @Inject
  public BasePageFooterImpl(final Binder puiBinder) {
    super();
    this.initWidget(puiBinder.createAndBindUi(this));
  }

  @Override
  public final void setPresenter(final BasePageFooterPresenter ppresenter) {
    this.presenter = ppresenter;
  }

  @UiHandler("print")
  final void clickedPrint(final ClickEvent pclickEvent) {
    this.presenter.print();
  }
}
