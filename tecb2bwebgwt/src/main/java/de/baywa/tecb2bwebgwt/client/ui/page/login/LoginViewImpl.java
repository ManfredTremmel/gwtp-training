package de.baywa.tecb2bwebgwt.client.ui.page.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class LoginViewImpl extends Composite {

  private static LoginViewImplUiBinder uiBinder = GWT.create(LoginViewImplUiBinder.class);

  @UiField
  TextBox inpUser;

  @UiField
  PasswordTextBox inpPwd;

  @UiField
  Button btLogin;

  interface LoginViewImplUiBinder extends UiBinder<HTMLPanel, LoginViewImpl> {
  }

  public LoginViewImpl() {
    this.initWidget(LoginViewImpl.uiBinder.createAndBindUi(this));
  }

  @UiHandler("btLogin")
  final void onLogin(final ClickEvent pevent) {
    final String usr = this.inpUser.getValue();
    final String pwd = this.inpPwd.getValue();
    Window.alert("Klicked login, User: " + usr + ", Passord: " + pwd);
  }
}
