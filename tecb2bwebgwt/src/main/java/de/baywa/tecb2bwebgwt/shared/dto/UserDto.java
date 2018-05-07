package de.baywa.tecb2bwebgwt.shared.dto;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

import de.knightsoftnet.gwtp.spring.shared.models.User;

public class UserDto implements Serializable, User {
  private static final long serialVersionUID = 6580037177274322029L;

  private String user;
  private String firstName;
  private String lastName;

  public String getUser() {
    return this.user;
  }

  public void setUser(final String puser) {
    this.user = puser;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(final String pfirstName) {
    this.firstName = pfirstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(final String plastName) {
    this.lastName = plastName;
  }

  @Override
  public void setUserName(final String puserName) {
    this.user = puserName;
  }

  @Override
  public String getUserName() {
    return this.user;
  }

  @Override
  public boolean isLoggedIn() {
    return StringUtils.isNotEmpty(this.user);
  }
}
