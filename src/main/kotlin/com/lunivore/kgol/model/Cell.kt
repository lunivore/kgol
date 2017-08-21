package com.lunivore.kgol.model

data class Cell(val col: Int, val row: Int)

data class Cells(val cells: Set<Cell>) {
    companion object {
        val EMPTY = Cells(setOf())
    }

    fun numberOfNeighbours(it: Cell): Int {
        return 0
    }
}

