package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells

class BasicGolRules : IDecideCellFate {
    override fun generate(cells: Set<Cell>): Set<Cell> {

        val result = mutableSetOf<Cell>()
        cells.flatMap { it.potentialNeighbours().plus(it) }.forEach {
            val neighbourCount = it.potentialNeighbours()
                    .filter { cells.contains(it) }
                    .count()
            if ((neighbourCount == 2 && cells.contains(it)) || neighbourCount == 3) {
                result.add(it)
            }
        }
        return result
    }

}