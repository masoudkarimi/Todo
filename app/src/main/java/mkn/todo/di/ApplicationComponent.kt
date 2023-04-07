package mkn.todo.di

import android.app.Application
import com.example.room_db.di.RoomDatabaseModule
import com.example.room_db.di.RoomDatabaseBinder
import dagger.BindsInstance
import dagger.Component
import mkn.todo.base.android.di.ApplicationScope
import com.example.room_db.di.DatabaseComponent
import mkn.todo.tasks.ui.di.TaskListSubcomponentModule
import mkn.todo.tasks.ui.di.TaskUiComponentFactoryProvider

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        RoomDatabaseBinder::class,
        RoomDatabaseModule::class,
        TaskListSubcomponentModule::class
    ]
)
abstract class ApplicationComponent : DatabaseComponent, TaskUiComponentFactoryProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(application: Application): Builder

        fun build(): ApplicationComponent
    }
}