package ru.otus.cars

/**
 * Бензобак
 */
open class Tank {
    /**
     * Вместимость [литры]
     */
    open val capacity: Int = 0

    /**
     * Текущее количество топлива [литры]
     */
    var contents: Int = 0

    /**
     * Возвращает уровень топлива
     */
    fun getFuelContents(): Int {
        return contents
    }

    /**
     * Заправить топливо
     */
    open fun receiveFuel(liters: Int): Unit {
        if (contents + liters > capacity) {
            throw Throwable("Перелив") //TODO:
        }

        contents += liters
    }
}
