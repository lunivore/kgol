package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class GameOfLifeControllerTest{

    @Test
    fun shouldKeepClickedOnCellsLive() {
        val events = Events()
        var controller = GameOfLifeController(events)
        var lastNotificationEvent: Cells? = null

        events.cellChangeNotificationEvents.subscribe {
            lastNotificationEvent = it
        }

        events.toggleRequestEvents.push(Cell(0,0))
        events.toggleRequestEvents.push(Cell(1,1))

        assertEquals(Cells(setOf(Cell(0,0), Cell(1,1))), lastNotificationEvent)
    }

    @Test
    fun shouldToggleLiveCellOffWhenClicked() {
        val events = Events()
        var controller = GameOfLifeController(events)
        var lastNotificationEvent: Cells? = null

        events.cellChangeNotificationEvents.subscribe {
            lastNotificationEvent = it
        }

        events.toggleRequestEvents.push(Cell(0,0))
        events.toggleRequestEvents.push(Cell(0,0))

        assertEquals(Cells(setOf()), lastNotificationEvent)
    }


    @Test
    fun shouldApplyTheRules() {


        //given we have a game and some rules
        val events = Events()
        var controller = GameOfLifeController(events)
        var lastNotificationEvent: Cells? = null

        var rules = mock(Rules::class.java)

        //when we move to the next generation
        events.nextGenerationRequestEvents.push(null)

        //then the rules should be applied
        verify(rules).apply(Cells(setOf()))

    }

}

interface Rules {
    fun apply(block: Cells)

}
