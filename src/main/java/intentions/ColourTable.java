package intentions;


public class ColourTable {
    public ColourTable(int size) {
        if (size <= 1 ||(size & (size - 1)) != 0) { //bitwise and as all powers of 2 contain exactly 1 bit set to 1
            throw new IllegalArgumentException("palette size must be a power of two .");
        }
    }
    public void add(int rgb) {
        if (rgb < 0x000000 || rgb > 0xFFFFFF) {
            throw new IllegalArgumentException("rgb must be a 24 bit value between 0x000000 and 0xFFFFFF");
        }
}}