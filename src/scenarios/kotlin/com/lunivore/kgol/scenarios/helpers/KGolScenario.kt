package com.lunivore.kgol.scenarios.helpers

import com.lunivore.stirry.Stirry
import cucumber.api.java8.En
import javafx.scene.canvas.Canvas
import org.junit.Assert

open class KGolScenario : En {
    protected fun withCanvas(job: (Canvas) -> Unit): Unit {
        var foundCanvas = Stirry.findInRoot<Canvas> { it.id == "gameCanvas" }
        if (foundCanvas.succeeded) {
            job(foundCanvas.value)
        } else {
            Assert.fail("Could not find Canvas")
        }
    }
}