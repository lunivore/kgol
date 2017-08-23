package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Population

class BasicRules : Rules {
    override fun apply(block: Population): Population {
        return Population(block.cells
                .filter { block.numberOfNeighbours(it) == 2 || block.numberOfNeighbours(it) == 3}
                .toSet()
        )
    }

}