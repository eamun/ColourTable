package intentions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


class TestColourTable {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, 16, 32, 2048})//valid palette sizes
    void TestValidPaletteSize(int size) {
        assertDoesNotThrow(() -> new ColourTable(size));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, 0, -4, -1})//invalid palette sizes
    void TestInvalidPaletteSize(int size){
        assertThrows(IllegalArgumentException.class,() -> new ColourTable(size));
    }

    ColourTable table = new ColourTable(4);//creating an instance to add colors to
    @Test
    void testAddValidColor() {
        int validColor = 0x0F0F0F;
        assertDoesNotThrow(() -> table.add(validColor));
    }
    @Test
    void testAddInvalidColor() {
        int InvalidColor = 0xFFFFFFF;
        assertThrows(IllegalArgumentException.class,() -> table.add(InvalidColor));
    }
    @Test
    void testCapacity(){
        assertDoesNotThrow(() -> {
            table.add(0x000000); // 1. black
            table.add(0xFFFFFF); // 2. white
            table.add(0xfff8e7); // 3. cosmic latte
            table.add(0xf0f8ff); // 4. alice blue
            //table.add(0x32cd32);
        });

        assertThrows(IllegalStateException.class,() -> table.add(0x32cd32));
        //5. lime green, this addition should go over the capacity of "table" throwing an exception
    }
}
