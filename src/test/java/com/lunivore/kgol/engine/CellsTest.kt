package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells
import org.junit.Assert
import org.junit.Test

class CellsTest {

    @Test
    fun `should Calculate Number Of Neighbours For A Cell`() {
        val cells = Cells(setOf())

        Assert.assertEquals(0, cells.numberOfNeighbours(Cell(0,0)))

    }

}