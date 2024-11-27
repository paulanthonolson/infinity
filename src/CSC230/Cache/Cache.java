package Cache;

import java.util.Scanner;

public class Cache{
    
    // Variables

	private String name;
	private int addressSize;
	private int wordSize;
	private int blockSize;
	private int numLines;

// Constructor

	public Cache(String name, int addressSize, int wordSize, int blockSize, int numLines) {
		this.name = name;
		this.addressSize = addressSize;
		this.wordSize = wordSize;
		this.blockSize = blockSize;
		this.numLines = numLines;
	}

// Getters

    public String getName() {
        return name;
    }

    public int getAddressSize() {
        return addressSize;
    }

    public int getWordSize() {
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
