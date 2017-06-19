package com.lunivore.kgol.scenarios

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        format = arrayOf("pretty"),
        glue = arrayOf("com.lunivore.kgol.scenarios.glue"),
        features = arrayOf("."))
class Runner {
}
