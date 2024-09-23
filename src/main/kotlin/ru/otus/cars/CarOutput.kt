package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int


    /**
     * Уровень бензина, который доступен водителю
     *
     */
    fun getFuelContents(): Int
}