package mkn.todo

import android.app.Application
import mkn.todo.di.ApplicationComponent
import mkn.todo.di.DaggerApplicationComponent

class TodoApp: Application() {
    private val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .bindApplication(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}