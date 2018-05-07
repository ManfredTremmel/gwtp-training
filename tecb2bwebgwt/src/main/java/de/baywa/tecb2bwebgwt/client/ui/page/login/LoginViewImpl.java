package de.baywa.tecb2bwebgwt.client.ui.page.login;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;

import javax.inject.Inject;

import de.knightsoftnet.gwtp.spring.client.rest.helper.AbstractViewWithErrorHandling;
import de.knightsoftnet.validators.client.decorators.UniversalDecorator;
import de.knightsoftnet.validators.client.editor.BeanValidationEditorDriver;
import de.knightsoftnet.validators.client.event.FormSubmitEvent;

public class LoginViewImpl extends AbstractViewWithErrorHandling<LoginPresenter, LoginDto>
    implements LoginPresenter.MyView {

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

  @Inject
  public LoginViewImpl(final Driver pdriver, final LoginViewImplUiBinder puiBinder) {
    super(pdriver);
    this.initWidget(puiBinder.createAndBindUi(this));
    this.driver.initialize(this);
    this.driver.setSubmitButton(this.btLogin);
    this.driver.addFormSubmitHandler(this);
  }

  @Override
  public void onFormSubmit(final FormSubmitEvent<LoginDto> pevent) {
    this.presenter.tryToLogin();
  }

  @Override
  public void showMessage(final String pmessage) {
    // TODO Auto-generated method stub
  }
}
