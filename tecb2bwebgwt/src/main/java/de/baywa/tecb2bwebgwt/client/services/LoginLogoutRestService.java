package de.baywa.tecb2bwebgwt.client.services;

import de.baywa.tecb2bwebgwt.shared.dto.LoginDto;
import de.baywa.tecb2bwebgwt.shared.dto.UserDto;

import com.gwtplatform.dispatch.rest.shared.RestAction;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("login")
public interface LoginLogoutRestService {

  @POST
  RestAction<UserDto> login(final LoginDto ploginDto);

  @DELETE
  RestAction<Void> logout();
}
