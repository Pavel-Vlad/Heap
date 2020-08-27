import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    Heap heap = new Heap();
    int[][] arrays = {
            null,
            { 110, 90,40, 70,80, 30,10, 20,50, 60,65, 31,29, 11,9 },
            //{432,44,45,46,47,58,69,7,8,93,9,76,5,334,365},
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
            "1, 110",
            "2, -1"
    })
    void getMax(int array, int expectedRes) {
        int[] candidate = arrays[array];
        heap.MakeHeap(candidate, 3);
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
