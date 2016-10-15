package de.baywa.tecb2bwebgwt.client;

import de.baywa.tecb2bwebgwt.client.ui.page.login.LoginViewImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TecB2BWebGwt implements EntryPoint {

  /**
   * This is the entry point method.
   */
  @Override
  public void onModuleLoad() {
    final LoginViewImpl view = GWT.create(LoginViewImpl.class);
    RootPanel.get().add(view);
  }
}
