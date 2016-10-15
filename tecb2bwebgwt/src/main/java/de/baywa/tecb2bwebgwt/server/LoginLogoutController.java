package de.baywa.tecb2bwebgwt.server;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;
import de.baywa.tecb2bwebgwt.shared.dto.UserDto;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Login/Logout web service.
 *
 * @author Manfred Tremmel
 */
@RestController
@RequestMapping(value = "/api/rest/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginLogoutController {

  /**
   * login function.
   *
   * @param ploginDto login data
   * @return user dto for logged in user
   */
  @RequestMapping(method = RequestMethod.POST)
  public UserDto login(@Valid @RequestBody final LoginDto ploginDto) {
    final UserDto user = new UserDto();
    user.setUser(ploginDto.getInpUser());
    return user;
  }

  /**
   * logout function.
   */
  @RequestMapping(method = RequestMethod.DELETE)
  public void logout() {
    // TODO Auto-generated method stub
  }

  @RequestMapping(method = RequestMethod.GET)
  public String test() {
    return "test";
  }
}
