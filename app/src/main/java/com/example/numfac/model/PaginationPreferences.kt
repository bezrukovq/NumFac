package com.example.numfac.model

import android.content.Context
import android.content.SharedPreferences

object PaginationPreferences {
    private const val NAME = "SpinKotlin"
    private const val MODE = Context.MODE_PRIVATE
    private const val DEFAULTPAGINATION = 5
    private lateinit var preferences: SharedPreferences

    private var PAGINATION_SIZE = Pair("pagination_size",
        DEFAULTPAGINATION
    )

    fun init(context: Context?) {
        context?.let {
            preferences = context.getSharedPreferences(
                NAME,
                MODE
            )
        }
    }

    var paginationSize: Int
        get() = preferences.getInt(PAGINATION_SIZE.first, PAGINATION_SIZE.second)
        set(int) = preferences.edit {
            it.putInt(PAGINATION_SIZE.first, int)
        }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }
}
