package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Population
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BasicRulesTest {

    @Test
    fun shouldKillCellsWithLessThan2Neighbours() {
        // given I have one cell and a basic rule set
        val rules = BasicRules()
        val cells = Population(setOf(Cell(0, 0)))

        //when I apply the rules
        val newCells = rules.apply(cells)

        //then the cell should die
        assertEquals(Population.EMPTY, newCells)
    }

    @Test
    fun `should Keep cells alive if they have 2 neighbours`() {
        //given I have three cells in a row and a basic rule set
        val rules = BasicRules()
        val cells = Population(setOf(Cell(2, 2), Cell(3, 3), Cell(4, 4)))

        //when I apply the rules
        val newCells = rules.apply(cells)

        //then the cell in the middle should live
        assertTrue("Should contain cell 3,3 but doesn't!", newCells.cells.contains(Cell(3, 3)))
    }

    @Test
    fun `should Keep cells alive if they have 3 neighbours`() {
        //given I have a cell with 3 neighbours
        val rules = BasicRules()
        val cells = Population(setOf(Cell(2, 2), Cell(3, 3), Cell(4, 4), Cell(3, 4)))

        //when I apply the rules
        val newCells = rules.apply(cells)

        //then the cell in the middle should live
        assertTrue("Should contain cell 3,3 but doesn't!", newCells.cells.contains(Cell(3, 3)))
    }

    @Test
    fun `should create a live cell if it has 3 neighbours` () {
        //given I am a cell with 3 neighbours
        val rules = BasicRules()
        val cells = Population(setOf(Cell(2, 2), Cell(4, 4), Cell(3, 4)))

        //when I apply the rules
        val newCells = rules.apply(cells)

        //then the cell in the middle should come to life!!!
        assertTrue("Should contain cell 3,3 but doesn't!", newCells.cells.contains(Cell(3, 3)))
    }
}