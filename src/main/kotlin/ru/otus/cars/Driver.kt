package ru.otus.cars

interface Driver<in T: Car> {
    fun drive(car: T)
}