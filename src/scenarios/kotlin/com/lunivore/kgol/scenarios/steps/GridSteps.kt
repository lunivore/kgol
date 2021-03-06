package com.lunivore.kgol.scenarios.steps

import com.lunivore.kgol.scenarios.helpers.StringToCanvasPainter
import com.lunivore.stirry.Stirry
import cucumber.api.java8.En
import com.lunivore.kgol.scenarios.helpers.CanvasToStringReader
import javafx.scene.canvas.Canvas
import org.junit.Assert.assertEquals
import org.junit.Assert.fail

class GridSteps : En {

    init {

        Given("^a grid which looks like$", {grid : String ->
            var canvas = Stirry.find<Canvas> { it.id == "gameCanvas" }
            if (canvas == null) {
                fail("Could not find Canvas")
            } else {
                StringToCanvasPainter().paintGrid(grid, canvas)
            }
        })

        Given("^the game is running$", {
            // Requires nothing as this is already done for every scenario
        })

        Then("^the grid should look like$", { expectedGridFragment : String ->
            var canvas = Stirry.find<Canvas> { it.id == "gameCanvas" }
            if (canvas == null) {
                fail("Could not find Canvas")
            } else {
                val grid = CanvasToStringReader().gridFrom(canvas)
                val expectedGrid = CanvasToStringReader().expandFragmentTo(canvas, expectedGridFragment)
                assertEquals(expectedGrid, grid)
            }
        });
    }

    private fun stopKotlinOptimizationThatMessesUpCucumber() {
        this
    }

}

