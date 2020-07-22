package com.android.own.healcorona.data.model

/**
 *Created by Sourav K.P on 21-04-2020
 */
class DashboardMenu {

    var id: Int = 0

    var name: String? = null

    var image: Int? = null

    enum class Menu(val id: Int) {
        INDIA_UPDATES(1),
        WORLD_UPDATES(2),
        SYMPTOMS(3),
        PRECAUTIONS(4),
    }
}