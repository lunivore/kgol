package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cells

class BasicRules : Rules {
    override fun apply(block: Cells): Cells {
        return Cells(block.cells
                .filter { block.numberOfNeighbours(it) == 2 }
                .toSet()
        )
    }

}