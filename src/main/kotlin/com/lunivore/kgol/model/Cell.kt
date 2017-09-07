package com.lunivore.kgol.model

data class Cell(val col: Int, val row: Int) {
    fun withAdjacentCells(): Set<Cell> {
        val withAdjacentCells = setOf<Cell>();

        val first = listOf<Int>(-1, 0, 1)
        val second = listOf<Int>(-1, 0, 1)

        return first.map { f -> second.map { s -> Cell(col + f, row + s) } }.flatten().toSet()

    }
}

