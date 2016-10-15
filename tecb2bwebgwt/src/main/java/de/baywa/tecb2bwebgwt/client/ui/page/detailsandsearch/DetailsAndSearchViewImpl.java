package de.baywa.tecb2bwebgwt.client.ui.page.detailsandsearch;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the page, gwt implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class DetailsAndSearchViewImpl extends ViewImpl implements DetailsAndSearchPresenter.MyView {

  interface Binder extends UiBinder<Widget, DetailsAndSearchViewImpl> {
  }

  @Inject
  public DetailsAndSearchViewImpl(final Binder puiBinder) {
    super();
    this.initWidget(puiBinder.createAndBindUi(this));
  }
}
