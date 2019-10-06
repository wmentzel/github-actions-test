package com.randomlychosenbytes.kotlintest

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle

@TestInstance(Lifecycle.PER_CLASS)
class DummyTest {
    @Test
    fun `test the truth`() {
        assertTrue(true)
    }
}
