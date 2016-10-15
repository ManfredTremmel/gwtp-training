package de.baywa.tecb2bwebgwt.client.ui.page.privacy;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the privacy page, gwt implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class PrivacyViewImpl extends ViewImpl implements PrivacyPresenter.MyView {

  interface Binder extends UiBinder<Widget, PrivacyViewImpl> {
  }

  @UiField
  HTML privacyHtml;

  private final PrivacyMessages messages;

  /**
   * constructor injecting parameters.
   *
   * @param puiBinder ui binder of the page
   * @param pmessages localized messages
   */
  @Inject
  public PrivacyViewImpl(final Binder puiBinder, final PrivacyMessages pmessages) {
    super();
    this.initWidget(puiBinder.createAndBindUi(this));
    this.messages = pmessages;
  }

  @Override
  public void setHtml(final String pbranchId) {
    this.privacyHtml.setHTML(this.messages.privacyPage(pbranchId));
  }
}
