package de.baywa.tecb2bwebgwt.client.ui.page.login;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import java.util.ArrayList;

import de.knightsoftnet.validators.client.decorators.UniversalDecorator;
import de.knightsoftnet.validators.client.editor.BeanValidationEditorDriver;
import de.knightsoftnet.validators.client.event.FormSubmitEvent;

public class LoginViewImpl extends ViewImpl implements LoginPresenter.MyView {

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

  private final Driver driver;
  private LoginPresenter presenter;

  @Inject
  public LoginViewImpl(final Driver pdriver, final LoginViewImplUiBinder puiBinder) {
    super();
    this.driver = pdriver;
    this.initWidget(puiBinder.createAndBindUi(this));
    this.driver.initialize(this);
    this.driver.setSubmitButton(this.btLogin);
    this.driver.addFormSubmitHandler(this);
  }

  @Override
  public void setPresenter(final LoginPresenter ppresenter) {
    this.presenter = ppresenter;
  }

  @Override
  public void onFormSubmit(final FormSubmitEvent<LoginDto> pevent) {
    this.presenter.tryToLogin();
  }

  @Override
  public void fillForm(final LoginDto puser) {
    this.driver.edit(puser);

  }

  @Override
  public void setFocusOnFirstWidget() {
    this.inpUser.setFocus(true);
  }

  @Override
  public void displayValidationErrors(final ArrayList<ConstraintViolation<?>> perrors) {
    this.driver.setConstraintViolations(perrors);
  }
}
