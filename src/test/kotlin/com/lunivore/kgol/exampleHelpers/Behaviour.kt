package com.lunivore.kgol.exampleHelpers

import org.mockito.Mockito

open class Behaviour {
    internal fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }
    private fun <T> uninitialized(): T = null as T
}