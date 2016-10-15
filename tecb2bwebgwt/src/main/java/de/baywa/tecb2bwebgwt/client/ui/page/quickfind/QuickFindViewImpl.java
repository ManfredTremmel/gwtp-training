package de.baywa.tecb2bwebgwt.client.ui.page.quickfind;

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
public class QuickFindViewImpl extends ViewImpl implements QuickFindPresenter.MyView {

  interface Binder extends UiBinder<Widget, QuickFindViewImpl> {
  }

  @Inject
  public QuickFindViewImpl(final Binder puiBinder) {
    super();
    this.initWidget(puiBinder.createAndBindUi(this));
  }
}
