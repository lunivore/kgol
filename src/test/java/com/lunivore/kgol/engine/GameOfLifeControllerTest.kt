package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Population
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*

class GameOfLifeControllerTest{

    @Test
    fun shouldKeepClickedOnCellsLive() {
        val events = Events()
        var controller = GameOfLifeController(events, mock(Rules::class.java))
        var lastNotificationEvent: Population? = null

        events.cellChangeNotificationEvents.subscribe {
            lastNotificationEvent = it
        }

        events.toggleRequestEvents.push(Cell(0,0))
        events.toggleRequestEvents.push(Cell(1,1))

        assertEquals(Population(setOf(Cell(0, 0), Cell(1, 1))), lastNotificationEvent)
    }

    @Test
    fun shouldToggleLiveCellOffWhenClicked() {
        val events = Events()
        var controller = GameOfLifeController(events, mock(Rules::class.java))
        var lastNotificationEvent: Population? = null

        events.cellChangeNotificationEvents.subscribe {
            lastNotificationEvent = it
        }

        events.toggleRequestEvents.push(Cell(0,0))
        events.toggleRequestEvents.push(Cell(0,0))

        assertEquals(Population(setOf()), lastNotificationEvent)
    }


    @Test
    fun shouldApplyTheRules() {
        //given we have a game and some rules
        var rules = mock(Rules::class.java)
        val expectedCells = Population(setOf(Cell(1, 1)))
        `when`(rules.apply(Population(setOf()))).thenReturn(expectedCells)

        val events = Events()
        var controller = GameOfLifeController(events, rules)
        var lastNotificationEvent: Population? = null

        events.cellChangeNotificationEvents.subscribe {
            lastNotificationEvent = it
        }

        //when we move to the next generation
        events.nextGenerationRequestEvents.push(null)

        //then the rules should be applied
        verify(rules).apply(Population(setOf()))
        assertEquals(expectedCells, lastNotificationEvent)
    }

}

