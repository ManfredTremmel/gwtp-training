package de.baywa.tecb2bwebgwt.client.ui.page.imprint;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the imprint page, gwt implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class ImprintViewImpl extends ViewImpl implements ImprintPresenter.MyView {

  interface Binder extends UiBinder<Widget, ImprintViewImpl> {
  }

  @UiField
  HTML imprintHtml;

  private final ImprintMessages messages;

  /**
   * constructor injecting parameters.
   *
   * @param puiBinder ui binder of the page
   * @param pmessages localized messages
   */
  @Inject
  public ImprintViewImpl(final Binder puiBinder, final ImprintMessages pmessages) {
    super();
    this.initWidget(puiBinder.createAndBindUi(this));
    this.messages = pmessages;
  }

  @Override
  public void setHtml(final String pbranchId) {
    this.imprintHtml.setHTML(this.messages.imprintPage(pbranchId));
  }
}
