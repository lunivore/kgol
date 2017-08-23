package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Population
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class PopulationTest {

    @Test
    fun `should Calculate that a cell has no neighbours in an empty population`() {
        val cells = Population.EMPTY

        assertEquals(0, cells.numberOfNeighbours(Cell(0, 0)))
    }

    @Test
    fun `should calculate neighbours for cell with one neighbour`() {
        val population = Population(setOf(Cell(1, 1)))

        assertEquals(1, population.numberOfNeighbours(Cell(0, 1)))
    }

    @Test
    fun `should not include target in count of neighbours`() {
        val population = Population(setOf(Cell(1, 1), Cell(1, 2)))

        assertEquals(1, population.numberOfNeighbours(Cell(1, 1)))
    }

    @Test
    fun `should not include non-neighbour cells in count of neighbours`() {
        val population = Population(setOf(Cell(1, 1), Cell(1, 2), Cell(4, 4)))

        assertEquals(1, population.numberOfNeighbours(Cell(1, 1)))
    }

}