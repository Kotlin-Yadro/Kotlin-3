package ru.otus.cars

sealed class AppError : Throwable() {
    object BangException : AppError()
}