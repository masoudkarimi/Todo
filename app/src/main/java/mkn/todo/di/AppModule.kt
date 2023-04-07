package mkn.todo.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import mkn.todo.base.android.di.ApplicationScope
import mkn.todo.base.android.utils.AppCoroutineDispatchers

@Module
object AppModule {
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @ApplicationScope
    fun provideCoroutineDispatchers() : AppCoroutineDispatchers = AppCoroutineDispatchers(
        io = Dispatchers.IO,
        computation = Dispatchers.Default,
        main = Dispatchers.Main
    )
}