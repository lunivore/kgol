package com.lunivore.kgol.model

data class Population(val cells: Set<Cell>) {
    companion object {
        val EMPTY = Population(setOf())
    }

    fun numberOfNeighbours(cell: Cell): Int {

        return cells
                .filter { it != cell }
                .filter { it.col >= cell.col - 1 && it.col <= cell.col + 1 }
                .filter { it.row >= cell.row - 1 && it.row <= cell.row + 1 }
                .count()


    }

    fun lifeCandidates(): Set<Cell> {
        return cells.flatMap{it.withAdjacentCells()}.toSet()
    }

    fun  contains(cell: Cell): Boolean {
        return cells.contains(cell)
    }
}