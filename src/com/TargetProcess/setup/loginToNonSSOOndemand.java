package com.TargetProcess.setup;

import java.net.MalformedURLException;

/**
 * Created by okolotovich on 12/5/17.
 */
public class loginToNonSSOOndemand extends Setup {


    //On demand Non-SSO creds
    public static final String NON_SSO_ACCOUNT = "o";
    public static final String NON_SSO_USER_NAME = "admin";
    public static final String NON_SSO_PASSWORD = "123";

    String accountName;
    String userName;
    String password;

    public loginToNonSSOOndemand() throws MalformedURLException {
        super();
    }


}
