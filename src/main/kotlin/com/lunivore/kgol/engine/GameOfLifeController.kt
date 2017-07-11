package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells

/**
 * This is the main engine class for the Game of Life. It controls the interactions between the GUI and the other
 * classes in the engine (if they're needed).
 */
class GameOfLifeController {
    val events: Events

    constructor(events: Events, rules: Rules = BasicRules()) {
        this.events = events
        this.liveCells = mutableSetOf<Cell>()
        events.toggleRequestEvents.subscribe {
            if (!liveCells.add(it)) {
                liveCells.remove(it)
            }
            events.cellChangeNotificationEvents.push(Cells(liveCells))
        }
        events.nextGenerationRequestEvents.subscribe {
            this.liveCells = rules.apply(Cells(liveCells)).cells.toMutableSet()
            events.cellChangeNotificationEvents.push(Cells(liveCells))
        }
    }

    var liveCells: MutableSet<Cell>
}


