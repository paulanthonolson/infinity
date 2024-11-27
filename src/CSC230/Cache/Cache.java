package Cache;

import java.util.Scanner;

public class Cache{
    
    // Variables

	private String name;
	private int addressSize;
    private int addressSizeBits;
    private int addressSizeBytes;
    private int wordSize = 1;
	private int wordSizeBits;
    private int wordSizeBytes;
    private int wordSizeWords;
    private int numberOfBlocks;
	private int blockSize;
	private int numLines;
    private int offsetSize;
    private int blockNumberSize;
    private int tagSize;
    private int totalCacheSize;
    private int totalMemorySize;
    private int blockAddress;
    private int blockAddressSize;
    private int blockNumberIndex;
    private int tag;
    private int offset;

// Constructor

	public Cache(String name, int addressSize, int wordSize, int blockSize, int numLines) {
		this.name = name;
		this.addressSizeBits = addressSize;
        this.addressSizeBytes = addressSize;
		this.wordSizeBits = wordSize;
        this.wordSizeBytes = wordSize;
        this.wordSizeWords = wordSize;
		this.blockSize = blockSize;
		this.numLines = numLines;
        this.offsetSize = log2(blockSize);
        this.blockAddressSize = (addressSize - log2(blockSize));
	}

// Getters

    public String getName() {
        return name;
    }

    public int getAddressSizeBits() {
    return addressSize;
    }

    public int getAddressSizeBytes() {
        return addressSize / 8;
    }

    public int getWordSizeBits() {
        return wordSizeBits;
    }

    public int getWordSizeBytes() {
        return wordSize / 8;
    }

    public int getWordSizeWords() {
        return wordSize;
    }

    public int getBlockSizeBits() {
        return wordSize * blockSize;
    }

    public int getBlockSizeBytes() {
        return (wordSizeBits / 8) * blockSize;
    }

    public int getNumLines() {
        return numLines;
    }

    public int getOffsetSize() {
        return offsetSize;
    }
    
// Methods

    public void print() {
    }

    public void readLocation(int address) {
    }

    public void stats() {
    }

    public int log2(int x) {
        
        return (int)(Math.log(x)/Math.log(2));
    }

    
}
