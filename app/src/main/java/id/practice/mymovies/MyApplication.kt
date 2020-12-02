package id.practice.mymovies

import android.app.Application
import id.practice.mymovies.di.component.ApplicationComponent
import id.practice.mymovies.di.component.DaggerApplicationComponent
import id.practice.mymovies.di.module.AppModule
import id.practice.mymovies.di.module.NetworkModule

class MyApplication: Application() {

    var appComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(BuildConfig.API_BASE_URL))
                .build()
    }
}