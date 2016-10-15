package de.baywa.tecb2bwebgwt.server.rpc;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;
import de.baywa.tecb2bwebgwt.shared.dto.UserDto;
import de.baywa.tecb2bwebgwt.shared.rpc.LoginLogoutRemoteService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.servlet.annotation.WebServlet;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import de.knightsoftnet.validators.shared.exceptions.ValidationException;

@WebServlet(urlPatterns = {"/TecB2BWebGwt/LoginLogout"})
public class LoginLogoutServiceServlet extends RemoteServiceServlet
    implements LoginLogoutRemoteService {

  private static final long serialVersionUID = -5456494592625944692L;

  @Override
  public UserDto login(final LoginDto ploginDto) throws ValidationException {
    final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    final UserDto user = new UserDto();

    final Set<ConstraintViolation<LoginDto>> cv1 = validator.validate(ploginDto);

    if (cv1.isEmpty()) {
      user.setUser(ploginDto.getInpUser());
    } else {
      throw new ValidationException(cv1);
    }
    return user;
  }

  @Override
  public void logout() {
    // TODO Auto-generated method stub
  }
}
