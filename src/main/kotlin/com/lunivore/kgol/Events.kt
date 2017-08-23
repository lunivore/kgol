package com.lunivore.kgol

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Population
import org.reactfx.EventSource

class Events {

    /**
     * Requests from the GUI to toggle cells at a given column and row
     */
    val toggleRequestEvents = EventSource<Cell>()

    /**
     * Requests from the GUI to clear all cells from the grid
     */
    val clearRequestEvents = EventSource<Unit>()

    /**
     * Requests from the GUI to create the next generation of cells
     */
    val nextGenerationRequestEvents = EventSource<Unit>()

    /**
     * Notifications from the engine to the GUI that the cells in the grid have changed
     */
    val cellChangeNotificationEvents = EventSource<Population>()
}