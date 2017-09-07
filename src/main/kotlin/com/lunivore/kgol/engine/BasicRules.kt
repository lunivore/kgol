package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Population

class BasicRules : Rules {
    override fun apply(population: Population): Population {
        return Population(population.lifeCandidates()
                .filter {
                    val livingCellWithTwoNeighbours = population.contains(it) && population.numberOfNeighbours(it) == 2
                    val cellWithThreeNeighbours = population.numberOfNeighbours(it) == 3
                    livingCellWithTwoNeighbours || cellWithThreeNeighbours
                }
                .toSet()
        )
    }

}