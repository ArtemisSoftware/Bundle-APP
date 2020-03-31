package com.artemissoftware.bundleapp.todolist

import io.realm.RealmObject

open class ToDoItem : RealmObject(){

    var name = ""
    var important = false
}