package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells
import org.junit.Assert.*
import org.junit.Test

class BasicRulesTest {

    @Test
    fun shouldKillCellsWithLessThan2Neighbours() {
        // given I have one cell and a basic rule set
        val rules = BasicRules()
        val cells = Cells(setOf(Cell(0,0)))

        //when I apply the rules
        val newCells = rules.apply(cells)

        //then the cell should die
        assertEquals(Cells(setOf()), newCells)
    }

    @Test
    fun `should Keep cells alive if they have 2 or 3 neighbours`() {

    }

    @Test
    fun `should kill cells with more 3 neighbours`() {}

    @Test
    fun `should create cells if they have 3 neighbours in an empty space`() {

    }
}