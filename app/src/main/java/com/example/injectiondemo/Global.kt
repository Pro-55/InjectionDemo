package com.example.injectiondemo

import android.app.Application
import android.content.Context
import toothpick.Toothpick
import toothpick.config.Module

class Global : Application() {
    override fun onCreate() {
        super.onCreate()

        val applicationScope = Toothpick.openScope(getString(R.string.string_app_scope_name))
        val contextModule = object : Module() {
            init {
                bind(Context::class.java).toInstance(this@Global)
            }
        }
        val dataModule = ModuleProvider().dataModule()
        applicationScope.installModules(contextModule, dataModule)
    }
}
