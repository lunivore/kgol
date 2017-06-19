package com.lunivore.kgol

import com.lunivore.kgol.engine.GameOfLifeController
import com.lunivore.kgol.gui.GameOfLifeApp
import javafx.application.Application
import javafx.stage.Stage

class GameOfLife : Application() {

    override fun start(stage: Stage) {
        val events = Events()
        val controller = GameOfLifeController(events)
        GameOfLifeApp(events).start(stage)
    }

    companion object {
        @JvmStatic val SCALE = 20.0

        @JvmStatic fun main(args: Array<String>) {
            Application.launch(GameOfLife::class.java, *args)
        }
    }
}

