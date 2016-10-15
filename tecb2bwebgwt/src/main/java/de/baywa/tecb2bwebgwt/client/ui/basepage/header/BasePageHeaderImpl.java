package de.baywa.tecb2bwebgwt.client.ui.basepage.header;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.InlineHyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the base page header.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class BasePageHeaderImpl extends ViewImpl implements BasePageHeaderPresenter.MyView {

  interface Binder extends UiBinder<Widget, BasePageHeaderImpl> {
  }

  @UiField
  InlineHyperlink anchorfield;

  /**
   * constructor injecting fields.
   *
   * @param puiBinder ui binder of the page
   */
  @Inject
  public BasePageHeaderImpl(final Binder puiBinder) {
    super();
    this.initWidget(puiBinder.createAndBindUi(this));
  }

  @Override
  public final void setHeaderText(final String ptext) {
    this.anchorfield.setText(ptext);
  }
}
