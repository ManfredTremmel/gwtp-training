package de.baywa.tecb2bwebgwt.shared.rpc;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;
import de.baywa.tecb2bwebgwt.shared.dto.UserDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.knightsoftnet.validators.shared.exceptions.ValidationException;

@RemoteServiceRelativePath("LoginLogout")
public interface LoginLogoutRemoteService extends RemoteService {
  UserDto login(LoginDto loginDto) throws ValidationException;

  void logout();
}
