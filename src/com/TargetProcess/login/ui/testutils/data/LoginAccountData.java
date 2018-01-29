package com.TargetProcess.login.ui.testutils.data;

/**
 * Created by okolotovich on 11/17/17.
 */
public enum LoginAccountData {
    NON_SSO_ON_DEMAND("okolotovichrules", "admin", "123"),
    NON_SSO_ON_SITE("ios.tpminsk.by", "admin", "admin"),
    SSO_ON_DEMAND("android", "4testtommy@gmail.com", "Okta181373"),
    SSO_ON_SITE("android.tpondemand.com", "4testtommy@gmail.com", "Okta181373");

    private String mAccountName;
    private String mLogin;
    private String mPassword;

    LoginAccountData(String accountName, String login, String password) {
        mAccountName = accountName;
        mLogin = login;
        mPassword = password;
    }

    public String getAccountName() {
        return mAccountName;
    }

    public String getLogin() {
        return mLogin;
    }

    public String getPassword() {
        return mPassword;
    }
}
