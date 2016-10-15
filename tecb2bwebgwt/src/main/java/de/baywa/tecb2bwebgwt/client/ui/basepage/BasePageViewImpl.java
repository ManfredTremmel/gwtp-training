package de.baywa.tecb2bwebgwt.client.ui.basepage;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the CLOP BasePage.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class BasePageViewImpl extends ViewImpl implements BasePagePresenter.MyView {

  /**
   * view interface.
   */
  interface BasePageViewUiBinder extends UiBinder<Widget, BasePageViewImpl> {
  }

  @UiField
  SimplePanel header;

  @UiField
  SimplePanel navigation;

  @UiField
  SimplePanel footer;

  @UiField
  SimplePanel container;

  /**
   * constructor injecting fields.
   *
   * @param pUiBinder ui binder of the page
   */
  @Inject
  public BasePageViewImpl(final BasePageViewUiBinder pUiBinder) {
    super();

    this.initWidget(pUiBinder.createAndBindUi(this));

    this.bindSlot(BasePagePresenter.SLOT_HEADER, this.header);
    this.bindSlot(BasePagePresenter.SLOT_NAVIGATION, this.navigation);
    this.bindSlot(BasePagePresenter.SLOT_FOOTER, this.footer);
    this.bindSlot(BasePagePresenter.SLOT_MAIN_CONTENT, this.container);
  }
}
