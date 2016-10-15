package de.baywa.tecb2bwebgwt.client.ui.page.login;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

import de.knightsoftnet.validators.client.decorators.UniversalDecorator;
import de.knightsoftnet.validators.client.editor.BeanValidationEditorDriver;
import de.knightsoftnet.validators.client.event.FormSubmitEvent;
import de.knightsoftnet.validators.client.event.FormSubmitHandler;

public class LoginViewImpl extends Composite
    implements Editor<LoginDto>, FormSubmitHandler<LoginDto> {

  private static LoginViewImplUiBinder uiBinder = GWT.create(LoginViewImplUiBinder.class);

  @UiField
  UniversalDecorator<String> inpUser;

  @UiField
  UniversalDecorator<String> inpPwd;

  @UiField
  Button btLogin;

  interface LoginViewImplUiBinder extends UiBinder<HTMLPanel, LoginViewImpl> {
  }

  interface Driver extends BeanValidationEditorDriver<LoginDto, LoginViewImpl> {
  }

  private final Driver driver = GWT.create(Driver.class);
  private final LoginDto login = new LoginDto();

  public LoginViewImpl() {
    this.initWidget(LoginViewImpl.uiBinder.createAndBindUi(this));
    this.driver.initialize(this);
    this.driver.setSubmitButton(this.btLogin);
    this.driver.addFormSubmitHandler(this);
    this.driver.edit(this.login);
  }

  @Override
  public void onFormSubmit(final FormSubmitEvent<LoginDto> pevent) {
    Window.alert(
        "Klicked login, User: " + this.login.getInpUser() + ", Passord: " + this.login.getInpPwd());
  }
}
