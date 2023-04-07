package mkn.todo

import android.app.Application
import mkn.todo.di.ApplicationComponent
import mkn.todo.di.DaggerApplicationComponent
import mkn.todo.tasks.ui.di.TaskUiComponentFactoryProvider
import mkn.todo.tasks.ui.di.TasksUiComponent

class TodoApp: Application(), TaskUiComponentFactoryProvider {
    private val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .bindApplication(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun providerTaskUiComponentFactory(): TasksUiComponent.Factory {
        return appComponent.providerTaskUiComponentFactory()
    }
}