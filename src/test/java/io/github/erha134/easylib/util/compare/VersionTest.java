package io.github.erha134.easylib.util.compare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {
    @Test
    void compareTo() {
        Version v1 = new Version("1.0.0");
        Version v2 = new Version("1.0.1");
        assertTrue(v1.compareTo(v2) < 0);

        Version v3 = new Version("1.0.0.0");
        Version v4 = new Version("1.0.0");
        assertEquals(0, v3.compareTo(v4));

        Version v5 = new Version("1.0.0.1");
        Version v6 = new Version("1.0.0");
        assertTrue(v5.compareTo(v6) > 0);
    }
}
