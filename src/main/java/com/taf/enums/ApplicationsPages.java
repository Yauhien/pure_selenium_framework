package com.taf.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplicationsPages {
  LANDING_PAGE("/"),
  LOGIN_PAGE("/app/login"),
  REGISTRATION_PAGE("/app/signUp"),
  DETAILS_PAGE("/app/details"),
  NEW_USER_PAGE("/app/newUser"),
  PROFILE_PAGE("/app/profile");

  private final String field;
}
