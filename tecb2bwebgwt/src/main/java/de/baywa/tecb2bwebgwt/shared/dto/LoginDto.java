package de.baywa.tecb2bwebgwt.shared.dto;

public class LoginDto {
  private String inpUser;
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
