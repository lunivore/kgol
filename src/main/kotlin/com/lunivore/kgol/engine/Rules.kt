package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cells

interface Rules {
    fun apply(block: Cells): Cells
}