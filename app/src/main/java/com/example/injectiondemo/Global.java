package com.example.injectiondemo;

import android.app.Application;
import android.content.Context;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.config.Module;

public class Global extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Scope applicationScope = Toothpick.openScope(getString(R.string.string_app_scope_name));
        Module contextModule = new Module() {{
            bind(Context.class).toInstance(Global.this);
        }};
        Module dataModule = new ModuleProvider().dataModule();
        applicationScope.installModules(contextModule, dataModule);
    }
}
