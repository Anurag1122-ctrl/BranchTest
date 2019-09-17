package com.branchtest;

import android.app.Application;

import io.branch.referral.Branch;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Branch.enableDebugMode();
        Branch.enableLogging();
        Branch.enableSimulateInstalls();
        Branch.enableTestMode();
        Branch.getAutoTestInstance(this);
    }
}
