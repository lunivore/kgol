package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.model.Cells

class GameOfLifeController(val events : Events) {
    init {
        events.toggleRequestEvents.subscribe {
            throw UnsupportedOperationException("Implement me and connect the other events too!")
        }
    }


}