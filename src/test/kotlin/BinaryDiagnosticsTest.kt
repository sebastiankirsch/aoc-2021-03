import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class BinaryDiagnosticsTest {

    @Test
    fun pc_oneliners() {
        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("0"))
        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("1"))

        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("00"))
        assertEquals(2, BinaryDiagnostics.calculatePowerConsumption("01"))
        assertEquals(2, BinaryDiagnostics.calculatePowerConsumption("10"))
        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("11"))

        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("000"))
        assertEquals(6, BinaryDiagnostics.calculatePowerConsumption("001"))
        assertEquals(10, BinaryDiagnostics.calculatePowerConsumption("010"))
        assertEquals(12, BinaryDiagnostics.calculatePowerConsumption("011"))
        assertEquals(12, BinaryDiagnostics.calculatePowerConsumption("100"))
        assertEquals(10, BinaryDiagnostics.calculatePowerConsumption("101"))
        assertEquals(6, BinaryDiagnostics.calculatePowerConsumption("110"))
        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("111"))
    }

    @Test
    fun pc_twoliners() {
        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("""
            0
            0
        """))
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            0
            1
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            1
            0
        """) }
        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("""
            1
            1
        """))

        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("""
            00
            00
        """))
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            00
            01
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            00
            10
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            00
            11
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            01
            00
        """) }
        assertEquals(2, BinaryDiagnostics.calculatePowerConsumption("""
            01
            01
        """))
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            01
            10
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            01
            11
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            10
            00
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            10
            01
        """) }
        assertEquals(2, BinaryDiagnostics.calculatePowerConsumption("""
            10
            10
        """))
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            10
            11
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            11
            00
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            11
            01
        """) }
        assertFailsWith<RuntimeException> {
            BinaryDiagnostics.calculatePowerConsumption("""
            11
            10
        """) }
        assertEquals(0, BinaryDiagnostics.calculatePowerConsumption("""
            11
            11
        """))
    }

    @Test
    fun pc_example() {
        assertEquals(198, BinaryDiagnostics.calculatePowerConsumption("""
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
        """))
    }

    @Test
    fun lsr_oxygenPrefersOne() {
        assertEquals(3 * 1, BinaryDiagnostics.calculateLifeSupportRating("""
            11
            10
            01
        """))
    }

    @Test
    fun lsr_scrubberPrefersZero() {
        assertEquals(7 * 1, BinaryDiagnostics.calculateLifeSupportRating("""
            111
            110
            100
            010
            001
        """))
    }

    @Test
    fun lsr_example() {
        assertEquals(230, BinaryDiagnostics.calculateLifeSupportRating("""
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
        """))
    }

}