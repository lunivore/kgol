package com.lunivore.kgol.gui

import com.lunivore.kgol.Events
import com.lunivore.kgol.GameOfLife.Companion.SCALE
import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Population
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color
import javafx.stage.Stage
import org.reactfx.EventStreams


class GameOfLifeApp(val events : Events) : Application() {


    override fun start(stage: Stage) {
        val fxml = javaClass.getResource("/game_of_life.fxml")
        val root = FXMLLoader.load<Parent>(fxml)

        val scene = Scene(root)
        stage.setTitle("Conway's Game of Life")
        stage.setScene(scene)
        stage.show()

        val gameCanvas : Canvas = root.lookup("#gameCanvas") as Canvas
        drawBackgroundAndGridlines(gameCanvas)

        EventStreams.eventsOf(gameCanvas, MouseEvent.MOUSE_CLICKED)
                .subscribe {
                    events.toggleRequestEvents.push(Cell((it.x / SCALE).toInt(), (it.y / SCALE).toInt()))
                }

        val nextButton = root.lookup("#nextGenerationButton")
        EventStreams.eventsOf(nextButton, ActionEvent.ACTION).subscribe { events.nextGenerationRequestEvents.push(null) }

        val clearButton = root.lookup("#clearButton")
        EventStreams.eventsOf(clearButton, ActionEvent.ACTION).subscribe { events.clearRequestEvents.push(null) }

        events.cellChangeNotificationEvents.subscribe {
            clearAndFillLivingCells(gameCanvas, it)
        }
    }

    private fun GameOfLifeApp.clearAndFillLivingCells(gameCanvas: Canvas, population: Population) {
        with(gameCanvas.getGraphicsContext2D()) {
            drawBackgroundAndGridlines(canvas)
            fill = Color.BLACK
            population.cells.forEach {
                fillRect(it.col * SCALE, it.row * SCALE, SCALE, SCALE)
            }
        }
    }

    private fun drawBackgroundAndGridlines(gameCanvas: Canvas) {
        with(gameCanvas.graphicsContext2D) {
            fill = Color.WHITE
            fillRect(0.0, 0.0, gameCanvas.width, gameCanvas.height)

            stroke = Color.LIGHTGRAY
            for (col in 0 until (gameCanvas.width / SCALE).toInt()) {
                strokeLine(col * SCALE, 0.0, col* SCALE, gameCanvas.height)
            }
            for (row in 0 until (gameCanvas.height / SCALE).toInt()) {
                strokeLine(0.0, row * SCALE, gameCanvas.width, row* SCALE)
            }
        }
    }

}

