package mkn.todo.di

import android.app.Application
import com.example.room_db.RoomDatabaseComponent
import com.example.room_db.di.DatabaseSubcomponentsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, DatabaseSubcomponentsModule::class]
)
interface ApplicationComponent {

    fun databaseComponent(): RoomDatabaseComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(application: Application): Builder

        fun build(): ApplicationComponent
    }
}