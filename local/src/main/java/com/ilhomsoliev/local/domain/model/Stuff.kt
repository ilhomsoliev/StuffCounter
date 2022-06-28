package com.ilhomsoliev.local.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stuff(
    @PrimaryKey val id: Int? = null,
    var name:String,
    var count:Int,
    var color:Long,
    var defaultValue:Int,
    var resetValue:Int,
    var increaseBy:Int,
    var decreaseBy:Int
)