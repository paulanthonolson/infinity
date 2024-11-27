package Cache;

import java.util.Scanner;

public class Cache{
    
    // Variables

	private String name;
	private int addressSizeBits;
    private int addressSize;
    private int addressSizeBytes;
    private int wordSize;
	private int wordSizeBits;
    private int wordSizeBytes;
    private int wordSizeWords;
    private int numberOfBlocks;
	private int blockSize;
	private int numLines;

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
	}

// Getters

    public String getName() {
        return name;
    }

    public int getAddressSizeBits() {
    return addressSize;
    }

    public int getAddressSizeBytes() {
        return addressSize;
    }

    public int getWordSizeBits() {
        return wordSize;
    }

    public int getWordSizeBytes() {
        return wordSize;
    }

    public int getWordSizeWords() {
        return wordSize;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getNumLines() {
        return numLines;
    }
    
// Methods

    public void print() {
    }

    public void readLocation(int address) {
    }

    public void stats() {
    }

    
}
