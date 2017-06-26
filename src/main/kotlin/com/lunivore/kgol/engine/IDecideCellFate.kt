package com.lunivore.kgol.engine

import com.lunivore.kgol.model.Cell
import com.lunivore.kgol.model.Cells

interface IDecideCellFate {
    fun generate(cells : Set<Cell>) : Set<Cell>
}