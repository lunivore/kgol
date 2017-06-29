package com.lunivore.kgol.scenarios.steps

import com.lunivore.kgol.GameOfLife
import com.lunivore.stirry.Stirry
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java8.En

class Hooks constructor() : En {

    lateinit var gameOfLife : GameOfLife

    @Before
    fun initializeStirry() {
        System.out.println("Initializing Stirry...")
        Stirry.initialize()
        gameOfLife = GameOfLife()
        Stirry.startApp(gameOfLife)
    }

    @After
    fun closeStirry() {
        System.out.println("Stopping Stirry...")
        Stirry.stop()
    }
}
