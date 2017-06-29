package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells

/**
 * This is the main engine class for the Game of Life. It controls the interactions between the GUI and the other
 * classes in the engine (if they're needed).
 */
class GameOfLifeController(val events : Events, val rules : IDecideCellFate = BasicGolRules()) {
    var cells = mutableSetOf<Cell>()
    init {
        events.toggleRequestEvents.subscribe {
            if (!cells.remove(it)) cells.add(it)
            events.cellChangeNotificationEvents.push(Cells(cells))
        }

        events.nextGenerationRequestEvents.subscribe {
            cells = rules.generate(cells).toMutableSet()
            events.cellChangeNotificationEvents.push(Cells(cells))
        }
    }
}