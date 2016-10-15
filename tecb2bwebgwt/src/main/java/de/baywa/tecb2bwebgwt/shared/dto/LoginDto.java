package de.baywa.tecb2bwebgwt.shared.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class LoginDto implements Serializable {
  private static final long serialVersionUID = -5055908276783782627L;

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
