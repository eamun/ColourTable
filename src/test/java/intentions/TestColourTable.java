package intentions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestColourTable {
    @Test
    void TestPaletteSize() {
        assertDoesNotThrow(() -> new ColourTable(16));
    }
}
