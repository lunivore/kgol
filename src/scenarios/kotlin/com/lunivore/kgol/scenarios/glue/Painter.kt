package com.lunivore.kgol.scenarios.glue

import com.lunivore.kgol.GameOfLife
import javafx.event.Event
import javafx.scene.canvas.Canvas
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent

class Painter {
    private data class Cell(val col : Int, val row : Int)
    private val NO_CELL = Cell(-1, -1)

    fun  paintGrid(grid: String, canvas: Canvas) {

        val cells = grid.trimIndent().lines()
                .mapIndexed { row, line -> line.mapIndexed { col, char ->
                    if (char == '#') Cell(col, row) else NO_CELL
                }}.flatten().filter{it != NO_CELL}

        cells.forEach {
            fireMouseEvent(it, canvas)
        }
    }

    private fun fireMouseEvent(cell: Cell, canvas: Canvas) {
        val (x, y) = Pair(scale(cell.col), scale(cell.row))
        val withinScreen = canvas.localToScreen(x, y)

        Event.fireEvent(canvas, MouseEvent(MouseEvent.MOUSE_CLICKED,
                x, y,
                withinScreen.x, withinScreen.y,
                MouseButton.PRIMARY, 1,
                false, false, false, false, true,
                false, false, false, false, false,
                null))
    }

    private fun  scale(value: Int): Double {
        return (value * GameOfLife.SCALE) + (GameOfLife.SCALE / 2.0)
    }


}