package io.github.erha134.easylib.util;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class ObjectNullSafeTest {
    @Test
    void requireNonNull() {
        assertEquals(123, ObjectNullSafe.requireNonNull(123));
        assertThrows(NullPointerException.class,
                () -> ObjectNullSafe.requireNonNull(null));
    }

    @Test
    void testRequireNonNull2() {
        assertEquals(123, ObjectNullSafe.requireNonNull(123, new NullPointerException()));
        assertThrows(IllegalArgumentException.class,
                () -> ObjectNullSafe.requireNonNull(null, (Supplier<Throwable>) IllegalArgumentException::new));
        assertThrows(NullPointerException.class,
                () -> ObjectNullSafe.requireNonNull(null, (Throwable) null));
    }

    @Test
    void requireNonNullOrElse() {
        assertEquals("Hello, World!", ObjectNullSafe.requireNonNullOrElse(null, "Hello, World!"));
        assertThrows(NullPointerException.class,
                () -> ObjectNullSafe.requireNonNullOrElse(null, null));
    }
}
