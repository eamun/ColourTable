package intentions;


public class ColourTable {
    private final int[] colors; // list to store colors
    private final int capacity; // Max number of colors
    private int size; // current number of colors

    public ColourTable(int size) {
        if (size <= 1 ||(size & (size - 1)) != 0) { //bitwise and as all powers of 2 contain exactly 1 bit set to 1
            throw new IllegalArgumentException("palette size must be a power of two .");
        }
        this.capacity = size; // max capacity=size
        this.colors = new int[size]; // make an array of "size"
        this.size = 0;
    }
    public void add(int rgb) {
        if (rgb < 0x000000 || rgb > 0xFFFFFF) {
            throw new IllegalArgumentException("rgb must be a 24 bit value between 0x000000 and 0xFFFFFF");
        }
        else  if (size >= capacity) {
            throw new IllegalStateException("palette is full. Cant add more colors.");
        }
        colors[size] = rgb;
        size++;
    }
}