package com.lunivore.kgol

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells
import org.reactfx.EventSource

class Events {
    val toggleRequestEvents = EventSource<Cell>()
    val clearRequestEvents = EventSource<Unit>()
    val generationRequestEvents = EventSource<Unit>()
    val generationEvents = EventSource<Cells>()
}