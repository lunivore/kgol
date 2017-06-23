package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.GameOfLife
import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells
import junit.framework.Assert.assertEquals
import org.junit.Test

class GameOfLifeControllerBehaviour {

    @Test
    fun shouldToggleCells() {
        // Given we're listening to cell creation events
        var cells = Cells(setOf())
        var events = Events()
        var game = GameOfLifeController(events)

        events.generationEvents.subscribe { cells = it }

        // When we toggle some cells on and off
        events.toggleRequestEvents.push(Cell(1, 1))
        events.toggleRequestEvents.push(Cell(1, 1))
        events.toggleRequestEvents.push(Cell(1, 2))

        // Then we should get the cells generated as a result
        assertEquals(Cells(setOf(Cell(1, 2))), cells)
    }
}