package de.baywa.tecb2bwebgwt.client.ui.page.overview;

import com.google.gwt.uibinder.client.UiBinder;
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
public class OverviewViewImpl extends ViewImpl implements OverviewPresenter.MyView {

  interface Binder extends UiBinder<Widget, OverviewViewImpl> {
  }

  @Inject
  public OverviewViewImpl(final Binder pUiBinder) {
    super();
    this.initWidget(pUiBinder.createAndBindUi(this));
  }
}
