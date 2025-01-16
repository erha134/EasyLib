package io.github.erha134.easylib.util;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectNullSafeTest {
    @Test
    public void requireNonNull() {
        assertEquals(123, ObjectNullSafe.requireNonNull(123));
        assertThrows(NullPointerException.class,
                () -> ObjectNullSafe.requireNonNull(null));
    }

    @Test
    public void testRequireNonNull2() {
        assertEquals(123, ObjectNullSafe.requireNonNull(123, new NullPointerException()));
        assertThrows(IllegalArgumentException.class,
                () -> ObjectNullSafe.requireNonNull(null, (Supplier<Throwable>) IllegalArgumentException::new));
        assertThrows(NullPointerException.class,
                () -> ObjectNullSafe.requireNonNull(null, (Throwable) null));
    }

    @Test
    public void requireNonNullOrElse() {
        assertEquals("Hello, World!", ObjectNullSafe.requireNonNullOrElse(null, "Hello, World!"));
        assertThrows(NullPointerException.class,
                () -> ObjectNullSafe.requireNonNullOrElse(null, null));
    }
}
