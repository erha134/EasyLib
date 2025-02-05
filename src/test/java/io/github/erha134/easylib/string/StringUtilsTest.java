package io.github.erha134.easylib.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    void isEmpty() {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty("123"));
    }

    @Test
    void testToString() {
        assertEquals("null", StringUtils.toString(null));
        assertEquals("123", StringUtils.toString(123));
    }
}
