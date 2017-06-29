package com.lunivore.kgol.scenarios.steps

import com.lunivore.kgol.scenarios.helpers.StringToCanvasPainter
import com.lunivore.stirry.Stirry
import cucumber.api.java8.En
import javafx.scene.canvas.Canvas
import org.junit.Assert

class CellSteps : En {

    init {
        When("^we step to the next generation$", {
            Stirry.buttonClick { it.id == "nextGenerationButton" }
        })

        When("^we toggle the cells at$", {grid : String ->
            var canvas = Stirry.find<Canvas> { it.id == "gameCanvas" }
            if (canvas == null) {
                Assert.fail("Could not find Canvas")
            } else {
                StringToCanvasPainter().paintGrid(grid, canvas)
            }
        })
    }
}