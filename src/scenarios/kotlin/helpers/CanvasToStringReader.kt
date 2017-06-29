package helpers

import com.lunivore.kgol.GameOfLife
import javafx.application.Platform
import javafx.scene.SnapshotParameters
import javafx.scene.canvas.Canvas
import javafx.scene.image.WritableImage
import javafx.scene.paint.Color
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.TimeUnit

class CanvasToStringReader {
    /**
     * Takes a JavaFX canvas, reads the central pixel of each square at the game's SCALE,
     * then generates a string representation of that. Currently only works in black (#) and white (.).
     */
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

    /**
     * Takes a fragment of a grid expressed as a string, and expands it to match the width and height
     * of cells in a canvas, assuming that the fragment is at the top left and that all other cells are empty.
     */
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