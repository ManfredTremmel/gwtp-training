package de.baywa.tecb2bwebgwt.client.ui.page.logout;

import com.google.gwt.user.client.ui.Label;
import com.gwtplatform.mvp.client.ViewImpl;

public class LogoutView extends ViewImpl implements LogoutPresenter.MyView {

  public LogoutView() {
    super();
    this.initWidget(new Label());
  }
}
