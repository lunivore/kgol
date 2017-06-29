package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.GameOfLife
import com.lunivore.kgol.exampleHelpers.Behaviour
import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class GameOfLifeControllerBehaviour : Behaviour() {

    @Test
    fun shouldToggleCells() {
        // Given we're listening to cell creation events
        var cells = Cells(setOf())
        var events = Events()
        var game = GameOfLifeController(events)

        events.cellChangeNotificationEvents.subscribe { cells = it }

        // When we toggle some cells on and off
        events.toggleRequestEvents.push(Cell(1, 1))
        events.toggleRequestEvents.push(Cell(1, 1))
        events.toggleRequestEvents.push(Cell(1, 2))

        // Then we should get the cells generated as a result
        assertEquals(Cells(setOf(Cell(1, 2))), cells)
    }

    @Test
    fun shouldApplyRulesToCells() {
        // Given a set of rules which always leaves just one cell alive at 1, 1
        var rules = mock(IDecideCellFate::class.java)
        val expectedCells = setOf(Cell(1, 1))
        `when`(rules.generate(any())).thenReturn(expectedCells)

        // And a game with some cells in it...
        val events = Events()
        var game = GameOfLifeController(events, rules)
        events.toggleRequestEvents.push(Cell(4, 3))
        events.toggleRequestEvents.push(Cell(2, 8))

        // ...that we're listening to
        var cells = Cells(setOf())
        events.cellChangeNotificationEvents.subscribe { cells = it }

        // When we step to the next generation
        events.nextGenerationRequestEvents.push(null)

        // Then the rules should have been applied
        assertEquals(Cells(expectedCells), cells)
    }
}