package com.lunivore.kgol.model

data class Cell(val col: Int, val row: Int) {
    fun potentialNeighbours() : Set<Cell> {
        return setOf(
        Cell(col - 1, row - 1),
        Cell(col - 1, row),
        Cell(col - 1, row + 1),
        Cell(col, row - 1),
        Cell(col, row + 1),
        Cell(col + 1, row - 1),
        Cell(col + 1, row),
        Cell(col + 1, row + 1))
    }
}

data class Cells(val cells: Set<Cell>)

