package de.baywa.tecb2bwebgwt.shared.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginDto {
  @NotEmpty
  private String inpUser;
  @NotEmpty
  private String inpPwd;

  public final String getInpUser() {
    return this.inpUser;
  }

  public final void setInpUser(final String pinpUser) {
    this.inpUser = pinpUser;
  }

  public final String getInpPwd() {
    return this.inpPwd;
  }

  public final void setInpPwd(final String pinpPwd) {
    this.inpPwd = pinpPwd;
  }
}
