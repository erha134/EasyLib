package io.github.erha134.easylib.util;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationUtils {
    public static <T> Iterator<T> toIterator(Enumeration<T> enumeration) {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override
            public T next() {
                return enumeration.nextElement();
            }
        };
    }
}
