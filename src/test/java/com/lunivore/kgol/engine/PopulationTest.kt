package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Population
import org.junit.Assert
import org.junit.Assert.*
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
    @Test
    fun `should return the full list of candidates for life`() {
        val population = Population(setOf(Cell(1, 1), Cell(1, 2)))

        val expected = setOf<Int>(0,1,2).flatMap { a-> setOf(0,1,2,3).map{Cell(a, it)} }.toSet()
        assertEquals(expected, population.lifeCandidates())
    }

    @Test
    fun `should tell us if it contains a particular cell`() {
        val population = Population(setOf(Cell(1, 1)))

        assertTrue(population.contains(Cell(1, 1)))
        assertFalse(population.contains(Cell(1, 2)))
    }

}