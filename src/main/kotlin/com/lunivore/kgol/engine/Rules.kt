package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Population

interface Rules {
    fun apply(population: Population): Population
}