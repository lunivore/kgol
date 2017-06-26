package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cell
import junit.framework.Assert.assertFalse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BasicGolRulesBehaviour() {

    @Test
    fun shouldKillCellsWithNoNeighbours() {
        // Given a cell with no neighbours
        val cell = Cell(3, 4)

        // When the rules are used to create the next generation
        val result = BasicGolRules().generate(setOf(cell))

        // Then that cell should die
        assertTrue(result.isEmpty())
    }

    @Test
    fun shouldKillCellsWithOneNeighbour() {
        // Given cells with one neighbour each
        val cells = setOf(Cell(3, 3), Cell(3, 4))

        // When the rules are used to create the next generation
        val result = BasicGolRules().generate(cells)

        // Then that cell should die
        assertTrue(result.isEmpty())
    }

    @Test
    fun shouldKeepCellsWithTwoNeighboursAlive() {
        // Given cells with two neighbours each
        val cells = setOf(Cell(3, 3), Cell(2, 4), Cell(4, 4), Cell(2, 5), Cell(4, 5), Cell(3, 6))

        // When the rules are used to create the next generation
        val result = BasicGolRules().generate(cells)

        // Then the cells should all live
        assertEquals(cells, result)
    }

    @Test
    fun shouldKeepCellsWithThreeNeighboursAlive() {
        // Given cells with three neighbours each
        val cells = setOf(Cell(3, 3), Cell(3, 4), Cell(4, 3), Cell(4, 4))

        // When the rules are used to create the next generation
        val result = BasicGolRules().generate(cells)

        // Then the cells should all live
        assertEquals(cells, result)
    }

    @Test
    fun shouldKillCellsWithMoreThanThreeNeighbours() {
        // Given a cell with more than 3 neighbours
        val cellToDie = Cell(3, 3)
        val neighbours = setOf(Cell(3, 2), Cell(2, 3), Cell(4, 3), Cell(3, 4))

        // When the rules are used to create the next generation
        val result = BasicGolRules().generate(neighbours.plus(cellToDie))

        // Then the doomed cell should die
        assertFalse(result.contains(cellToDie))
    }

    @Test
    fun shouldCreateCellsInEmptySpacesWithThreeNeighbours() {
        // Given an empty cell with three neighbours
        val cells = setOf(Cell(3, 3), Cell(5, 4), Cell(3, 5))

        // When the rules are used to create the next generation
        val result = BasicGolRules().generate(cells)

        // Then the cell between them should be born
        assertEquals(setOf(Cell(4, 4)), result)
    }

}
