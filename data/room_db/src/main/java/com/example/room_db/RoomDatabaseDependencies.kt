package com.example.room_db

import android.content.Context

interface RoomDatabaseDependencies {
    fun provideContext(): Context
}