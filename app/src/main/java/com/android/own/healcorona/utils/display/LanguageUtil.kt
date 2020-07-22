package com.android.healcorona.utils.display

/**
 *Created by Sourav K.P on 20-04-2020
 */
class LanguageUtil(val language: String) {

    companion object {
        const val ENGLISH = "English"
        const val HINDI = "हिंदी"

    }

    enum class LanguagePrefix(val language: String) {
        ENGLISH("en"), HINDI("hi")
    }
}
