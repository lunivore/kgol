package com.lunivore.kgol.scenarios.steps

import com.lunivore.kgol.scenarios.helpers.StringToCanvasPainter
import com.lunivore.stirry.Stirry
import cucumber.api.java8.En
import com.lunivore.kgol.scenarios.helpers.CanvasToStringReader
import com.lunivore.kgol.scenarios.helpers.KGolScenario
import javafx.scene.canvas.Canvas
import org.junit.Assert.assertEquals
import org.junit.Assert.fail

class GridSteps : KGolScenario() {

    init {

        Given("^a grid which looks like$", {grid : String ->
            withCanvas( {StringToCanvasPainter().paintGrid(grid, it) })

        })

        Given("^the game is running$", {
            // Requires nothing as this is already done for every scenario
        })

        Then("^the grid should look like$", { expectedGridFragment : String ->
            withCanvas {
                val grid = CanvasToStringReader().gridFrom(it)
                val expectedGrid = CanvasToStringReader().expandFragmentTo(it, expectedGridFragment)
                assertEquals(expectedGrid, grid)
            }
        });
    }

}

