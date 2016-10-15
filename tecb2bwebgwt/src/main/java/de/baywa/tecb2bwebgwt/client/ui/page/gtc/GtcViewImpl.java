package de.baywa.tecb2bwebgwt.client.ui.page.gtc;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the Start page, gwt implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class GtcViewImpl extends ViewImpl implements GtcPresenter.MyView {

  interface Binder extends UiBinder<Widget, GtcViewImpl> {
  }

  @UiField
  HTML gtcHtml;

  private final GtcMessages messages;

  /**
   * constructor injecting parameters.
   *
   * @param puiBinder ui binder of the page
   * @param pmessages localized messages
   */
  @Inject
  public GtcViewImpl(final Binder puiBinder, final GtcMessages pmessages) {
    super();
    this.initWidget(puiBinder.createAndBindUi(this));
    this.messages = pmessages;
  }

  @Override
  public void setHtml(final String pbranchId) {
    this.gtcHtml.setHTML(this.messages.gtcPage(pbranchId));
  }
}
