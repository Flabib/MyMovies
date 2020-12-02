package id.practice.mymovies.di.component

import dagger.Component
import id.practice.mymovies.di.module.AppModule
import id.practice.mymovies.di.module.NetworkModule
import id.practice.mymovies.ui.main.pages.movie.MovieFragment
import id.practice.mymovies.ui.main.pages.tv.TVFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(movieFragment: MovieFragment)
    fun inject(tvFragment: TVFragment)
}