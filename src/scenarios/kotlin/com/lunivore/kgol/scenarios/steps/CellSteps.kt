package com.lunivore.kgol.scenarios.steps

import com.lunivore.kgol.scenarios.helpers.KGolScenario
import com.lunivore.kgol.scenarios.helpers.StringToCanvasPainter
import com.lunivore.stirry.Stirry
import com.lunivore.stirry.fireAndStir
import cucumber.api.java8.En
import javafx.scene.canvas.Canvas
import javafx.scene.control.Button
import org.junit.Assert

class CellSteps : KGolScenario() {

    init {
        When("^we step to the next generation$", {
            Stirry.findInRoot<Button> { it.id == "nextGenerationButton" }.value.fireAndStir()
        })

        When("^we toggle the cells at$", {grid : String ->
            withCanvas {StringToCanvasPainter().paintGrid(grid, it) }
        })
    }
}