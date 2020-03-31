package com.artemissoftware.bundleapp.todolist

import android.app.Application
import io.realm.Realm

public class TodDoList : Application(){

    public override fun onCreate(){
        super.onCreate()
        Realm.init(this)
    }
}