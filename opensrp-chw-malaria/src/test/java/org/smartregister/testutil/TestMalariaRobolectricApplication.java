package org.smartregister.testutil;

import android.app.Application;

import org.smartregister.Context;
import org.smartregister.CoreLibrary;

public class TestMalariaRobolectricApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Context ctx = Context.getInstance();
            ctx.updateApplicationContext(getApplicationContext());
            // Initialize SmartRegister Core so Activities can access it in tests
            CoreLibrary.init(ctx);
        } catch (Throwable ignored) {
            // Keep tests resilient even if core init is partially unavailable
        }
    }
}

