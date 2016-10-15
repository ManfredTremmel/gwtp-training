package de.baywa.tecb2bwebgwt.client.ui.page.sparepartsdocs;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * View of the page, spare parts documentation implementation.
 *
 * @author Manfred Tremmel
 * @version $Rev$, $Date$
 *
 */
public class SparePartsDocsViewImpl extends ViewImpl implements SparePartsDocsPresenter.MyView {

  interface Binder extends UiBinder<Widget, SparePartsDocsViewImpl> {
  }

  @Inject
  public SparePartsDocsViewImpl(final Binder puiBinder) {
    super();
    this.initWidget(puiBinder.createAndBindUi(this));
  }
}
