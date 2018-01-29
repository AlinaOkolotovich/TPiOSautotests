package com.TargetProcess;

import com.TargetProcess.setup.AddUS;
import com.TargetProcess.setup.Setup;

import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        boolean isSSO;
        Setup test = new Setup(isSSO=false);
        test.stopServer();




    }
}
