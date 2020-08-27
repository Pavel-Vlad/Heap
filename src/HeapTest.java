import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    Heap heap = new Heap();
    int[][] arrays = {
            null,
            {44,432,45,46,47,58,69,7,8,93,9,76,5,334,365},
            {}
    };

    @ParameterizedTest(name = "num array:{0} depth:{1} -> length:{2}")
    @CsvSource({
            "0, 0, 0",
            "1, 1, 3",
            "2, 1, 3"
    })
    void makeHeap(int array, int depth, int length) {
        heap.MakeHeap(arrays[array], depth);
        if (array == 0)
            assertNull(heap.HeapArray);
        else
            assertEquals(heap.HeapArray.length, length);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "0, -1",
            "1, 432",
            "2, -1"
    })
    void getMax(int array, int expectedRes) {
        int[] candidate = arrays[array];
        heap.MakeHeap(candidate, 2);
        assertEquals(heap.GetMax(), expectedRes);
    }

    // проверка добавления недопустимого ключа
    @Test
    void add2() {
        heap.MakeHeap(arrays[2], 0);
        assertFalse(heap.Add(-1));
    }

    // добавление ключа в непольностью заполненную кучу
    @Test
    void add3() {
        heap.MakeHeap(arrays[1], 6);
        assertTrue(heap.Add(11));
    }

    // добавление ключа в заполненную кучу
    @Test
    void add4() {
        heap.MakeHeap(arrays[1], 1);
        System.out.println(Arrays.toString(heap.HeapArray));
        assertFalse(heap.Add(11));
        System.out.println(Arrays.toString(heap.HeapArray));
    }
}









/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
/*


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }
}*/
