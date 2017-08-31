package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Population

class BasicRules : Rules {
    override fun apply(population: Population): Population {
        return Population(population.cells.map{it.withAdjacentCells()}.flatten()
                .filter { population.numberOfNeighbours(it) == 2 || population.numberOfNeighbours(it) == 3}
                .toSet()
        )
    }

}