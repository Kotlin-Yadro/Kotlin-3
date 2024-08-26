package ru.otus.cars

abstract class TankMouth() {
    var isOpened: Boolean = false
        private set
    fun open() {
        isOpened = true
    }
    fun close() {
        isOpened = false
    }

}