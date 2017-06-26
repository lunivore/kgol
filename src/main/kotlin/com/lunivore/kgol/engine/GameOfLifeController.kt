package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells

class GameOfLifeController(val events : Events, val rules : IDecideCellFate = BasicGolRules()) {

    var cells = mutableSetOf<Cell>()
    init {
        events.toggleRequestEvents.subscribe {
            if (!cells.remove(it)) cells.add(it)
            events.generationEvents.push(Cells(cells))
        }

        events.generationRequestEvents.subscribe {
            cells = rules.generate(cells).toMutableSet()
            events.generationEvents.push(Cells(cells))
        }
    }
}