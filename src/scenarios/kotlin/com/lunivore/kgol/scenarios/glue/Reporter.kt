package com.lunivore.kgol.scenarios.glue

import com.lunivore.kgol.GameOfLife
import javafx.application.Platform
import javafx.scene.SnapshotParameters
import javafx.scene.canvas.Canvas
import javafx.scene.image.WritableImage
import javafx.scene.paint.Color
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.TimeUnit

class Reporter {
    fun gridFrom(canvas: Canvas): String {
        val image = WritableImage(canvas.width.toInt(), canvas.height.toInt())

        var queue = ArrayBlockingQueue<Boolean>(1)
        Platform.runLater {
            canvas.snapshot(SnapshotParameters(), image)
            queue.put(true)
        }
        queue.poll(1L, TimeUnit.SECONDS)

        var grid = ""

        for (row: Int in 0..((canvas.height / GameOfLife.SCALE).toInt() - 1)) {
            for(col : Int in 0..((canvas.width / GameOfLife.SCALE).toInt() - 1)) {
                val color = image.pixelReader.getColor(toPixelCoord(col), toPixelCoord(row))
                grid = grid.plus(if (color == Color.BLACK) '#' else '.')
            }
            grid = grid.plus(System.getProperty("line.separator"))
        }
        grid = grid.trimEnd()
        return grid
    }

    private fun toPixelCoord(col: Int) = ((col * GameOfLife.SCALE) + (GameOfLife.SCALE / 2)).toInt()

    fun  expandFragmentTo(canvas: Canvas, expectedGridFragment: String): String {
        var fragmentLines = expectedGridFragment.trimIndent().lines()
        var grid = ""

        for (row: Int in 0..((canvas.height / GameOfLife.SCALE).toInt() - 1)) {
            for(col : Int in 0..((canvas.width / GameOfLife.SCALE).toInt() - 1)) {
                if(row >= fragmentLines.size || col >= fragmentLines[row].length) {
                    grid = grid.plus('.')
                }
                else {
                    grid = grid.plus(fragmentLines[row][col])
                }
            }
            grid = grid.plus(System.getProperty("line.separator"))
        }
        grid = grid.trimEnd()
        return grid
    }

}