package com.lunivore.kgol.model

import org.junit.Assert.*
import org.junit.Test

class CellTest {


    @Test
    fun `a cell with its adjacent cells should be nine cells`() {

        //given a cell
        val cell = Cell(1,1)

        //when we check its adjacent neighbours
        val cellWithAdjacents = cell.withAdjacentCells()

        //then there should be nine of them, and they should all be correct
        assertEquals(9, cellWithAdjacents.size)
    }
}

