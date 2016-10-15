package de.baywa.tecb2bwebgwt.client.ui.page.login;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
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

public class LoginViewImpl extends Composite implements Editor<LoginDto> {

  private static LoginViewImplUiBinder uiBinder = GWT.create(LoginViewImplUiBinder.class);

  @UiField
  TextBox inpUser;

  @UiField
  PasswordTextBox inpPwd;

  @UiField
  Button btLogin;

  interface LoginViewImplUiBinder extends UiBinder<HTMLPanel, LoginViewImpl> {
  }

  interface Driver extends SimpleBeanEditorDriver<LoginDto, LoginViewImpl> {
  }

  private final Driver driver = GWT.create(Driver.class);
  private final LoginDto login = new LoginDto();

  public LoginViewImpl() {
    this.initWidget(LoginViewImpl.uiBinder.createAndBindUi(this));
    this.driver.initialize(this);
    this.driver.edit(this.login);
  }

  @UiHandler("btLogin")
  final void onLogin(final ClickEvent pevent) {
    this.driver.flush();
    Window.alert(
        "Klicked login, User: " + this.login.getInpUser() + ", Passord: " + this.login.getInpPwd());
  }
}
