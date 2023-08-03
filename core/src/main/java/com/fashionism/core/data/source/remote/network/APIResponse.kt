@file:Suppress("unused", "unused")

package com.fashionism.core.data.source.remote.network

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused")
sealed class APIResponse<out R> {

    data class Success<out T>(val data: T) : APIResponse<T>()

    data class Error(val errorMessage: String) : APIResponse<Nothing>()

    object Empty : APIResponse<Nothing>()

}