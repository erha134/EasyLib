package io.github.erha134.easylib.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFormatterTest {
    @Test
    void format() {
        assertEquals("awa! Hello, World! awa!", StringFormatter.format("{1}! Hello, {}! {}!", "World", "awa"));
    }
}
