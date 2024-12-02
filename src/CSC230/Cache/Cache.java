package Cache;

public class Cache{
    
    // Variables

	private String name;
	private int addressSize = 0;
    private int addressSizeBits = 0;
    private int addressSizeBytes = 0;
    private int wordSize = 1;
	private int wordSizeBits = 0;
    private int wordSizeBytes = 0;
    private int wordSizeWords = 0;
    private int numberOfBlocks = 0;
    private int numLines = 0;
	private int blockSize = 0;
	private int offsetSize = 0;
    private int blockNumberSize = 0;
    private int tagSize = 0;
    private int totalCacheSize = 0;
    private int totalMemorySize = 0;
    private long totalMemorySizeBytes = 0;
    private int totalMemorySizeWords = 0;
    private int blockAddress = 0;
    private int blockAddressSize = 0;
    private int blockNumberIndex = 0;
    private int tag = 0;
    private int offset = 0;
    private int[] tags;
    private boolean[] validBits;
    private int totalRequests = 0;
    private int totalHits = 0;
    private int totalMisses = 0;

// Constructor

	public Cache(String name, int addressSize, int wordSize, int blockSize, int numLines) {
		this.name = name;
        this.addressSize = addressSize;
		this.addressSizeBits = addressSize;
        this.addressSizeBytes = addressSize / 8;
        this.wordSize = wordSize;
		this.wordSizeBits = wordSize;
        this.wordSizeBytes = wordSize / 8;
        this.wordSizeWords = wordSize;
		this.blockSize = blockSize;
        this.numLines = numLines;
        this.numberOfBlocks = numLines;
		this.offsetSize = log2(blockSize * (wordSize / 8));
        this.blockAddressSize = (addressSizeBits - log2(blockSize));
        this.blockNumberSize = log2(numLines);
        this.tagSize = (addressSize - blockNumberSize - offsetSize);
        this.totalCacheSize = numLines * (tagSize + 1 + (blockSize * wordSize));
        this.totalMemorySizeWords = 1 << (addressSize - log2(wordSize/8));
        this.totalMemorySizeBytes = (long)totalMemorySizeWords * (wordSize/8);
        this.totalMemorySize = totalMemorySizeWords;
        this.tags = new int[numberOfBlocks];
        this.validBits = new boolean[numberOfBlocks];
	}

// Getters

    public String getName() {
        return name;
    }

    public int getAddressSize() {
        return addressSize;
    }

    public int getAddressSizeBits() {
    return addressSize;
    }

    public int getAddressSizeBytes() {
        return addressSizeBytes;
    }

    public int getWordSize() {
        return wordSize;
    }

    public int getWordSizeBits() {
        return wordSizeBits;
    }

    public int getWordSizeBytes() {
        return wordSizeBytes;
    }

    public int getWordSizeWords() {
        return wordSizeWords;
    }

    public int getBlockSizeBits() {
        return wordSize * blockSize;
    }

    public int getBlockSizeBytes() {
        return (wordSizeBits / 8) * blockSize;
    }

    public int getNumberofBlocks() {
        return numLines;
    }

    public int getOffsetSize() {
        return offsetSize;
    }

    public int getblockAddressSize() {
        return blockAddressSize;
    }

    public int getblockNumberSize() {
        return blockNumberSize;
    }

    public int getTotalCacheSize() {
        return totalCacheSize;
    }

    public int getTotalMemorySize() {
        return totalMemorySize;
    }
    
// Methods

    public void print() {
        System.out.println("~~~~~~~~~~~~ CSC230 Cache Size Report ~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~ Paul Olson - Fall 2024 ~~~~~~~~~~~~");
        System.out.println("Memory : " + totalMemorySizeWords + " words of " + wordSize + " bits (" + totalMemorySizeBytes + " bytes)");
        System.out.println("Cache : " + numLines + " lines with " + tagSize + " bits of tag, 1 bit for the valid flag and " + blockSize + " words of data each (" + totalCacheSize + " bits)");
    }

    public void readLocation(int address) {
        totalRequests++;

        offset = address & ((1 << offsetSize) - 1);
        blockNumberIndex = (address >> offsetSize) & ((1 << blockNumberSize) -1);
        tag = address >> (offsetSize + blockNumberSize);
        blockAddress = address >> offsetSize;

        boolean isHit = validBits[blockNumberIndex] && tags[blockNumberIndex] == tag;

        if (isHit) {
            totalHits++;
        } else {
            totalMisses++;
            tags[blockNumberIndex] = tag;
            validBits[blockNumberIndex] = true;
        }

        System.out.println("Read Mem : " + address + " (" + binary(address, addressSize) + ")");
        System.out.println("\tBlock Address : " + blockAddress + " (" + binary(blockAddress, blockAddressSize) + ")");
        System.out.println("\tOffset : " + offset + " (" + binary(offset, offsetSize) + ")");
        System.out.println("\tBlock Number : " + blockNumberIndex + " (" + binary(blockNumberIndex, blockNumberSize) + ")");
        System.out.println("\tTag : " + tag + " (" + binary(tag, tagSize) + ")");
        System.out.println("\tResult : " + (isHit ? "** Hit **" : "** Miss **"));
    }

    public void stats() {
        double hitRatio = totalRequests == 0 ? 0 : (totalHits * 100.0) / totalRequests;
        double missRatio = totalRequests == 0 ? 0 : (totalMisses * 100.0) / totalRequests;

        System.out.println("**********");
        System.out.println("********** CSC 230 Cache Status Report");
        System.out.println("********** Paul Olson - Fall 2024");
        System.out.println("**********");
        System.out.println("\tRequests: " + totalRequests);
        System.out.printf("\tHits : %d (%.1f%%)\n", totalHits, hitRatio);
        System.out.printf("\tMisses : %d (%.1f%%)\n", totalMisses, missRatio);
    }

    private int log2(int x) {
        
        return (int)(Math.log(x)/Math.log(2));
    }

    private String binary(int x, int size) {
        return String.format("%32s", Integer.toBinaryString(x))
            .replace(' ', '0')
            .substring(32-size);
    }

    
}
