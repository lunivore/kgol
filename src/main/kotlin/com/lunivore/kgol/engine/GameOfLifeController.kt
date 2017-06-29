package com.lunivore.kgol.engine

import com.lunivore.kgol.Events
import com.lunivore.kgol.model.Cells

/**
 * This is the main engine class for the Game of Life. It controls the interactions between the GUI and the other
 * classes in the engine (if they're needed).
 */
class GameOfLifeController(val events : Events) {
    init {
        events.toggleRequestEvents.subscribe {
            throw UnsupportedOperationException("Implement me and connect the other events too! " +
                    "Use .push on events to tell the GUI if something changed.")
        }
    }


}