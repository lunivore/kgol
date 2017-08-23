package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Population

interface Rules {
    fun apply(block: Population): Population
}