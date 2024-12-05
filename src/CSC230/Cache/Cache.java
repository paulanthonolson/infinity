package Cache;

public class Cache {

	// Variables
	
    private String name;
    private int numLines;
    private int blockSize;
    
    private int addressSizeBits;
    private int tagSize;
    private int blockNumberSize;
    private int offsetSize;
    private int blockAddressSize;
    
    private int wordSizeBits;
    private int wordSizeBytes;
    private int wordSizeWords;
    
    private int addressSizeBytes;
    
    private int totalMemorySizeWords;
    private long totalMemorySizeBytes;
    
    private int totalCacheSize;
    
    private int[] tags;
    private boolean[] validBits;
    
    private int totalRequests;
    private int totalHits;
    private int totalMisses;

    private int blockSizeBytes;
    private int blockAddress;
    private int blockNumberIndex;
    private int tag;
    private int offset;
    
    // Constructor

    public Cache(String name, int addressSize, int wordSize, int blockSize, int numLines) {
        this.name = name;
        this.numLines = numLines;
        this.blockSize = blockSize;
        
        this.wordSizeBits = wordSize;
        this.wordSizeBytes = wordSize / 8;
        this.wordSizeWords = wordSize;
        
        this.addressSizeBits = addressSize;
        this.addressSizeBytes = addressSize / 8;
        
        this.offsetSize = log2(blockSize * (wordSize / 8));
        this.blockNumberSize = log2(numLines);
        this.tagSize = addressSize - blockNumberSize - offsetSize;
        this.blockAddressSize = addressSizeBits - log2(blockSize);
        
        this.totalCacheSize = numLines * (tagSize + 1 + (blockSize * wordSize));
        this.totalMemorySizeWords = 1 << (addressSize - log2(wordSize/8));
        this.totalMemorySizeBytes = (long)totalMemorySizeWords * (wordSize/8);
        
        this.tags = new int[numLines];
        this.validBits = new boolean[numLines];
    }
    
    // Getters
    
    public String getName() { 
    return name; 
    }
    
    public int getAddressSizeBits() { 
    return addressSizeBits; 
    }
    
    public int getAddressSizeBytes() { 
    return addressSizeBytes; 
    }
    
    public int getWordSizeBits() { 
    return wordSizeBits; 
    }
    
    public int getWordSizeBytes() { return wordSizeBytes; 
    }
    
    public int getWordSizeWords() { 
    return wordSizeWords; 
    }
    
    public int getBlockSizeBits() { 
    return wordSizeBits * blockSize; 
    }
    
    public int getBlockSizeBytes() { 
    return (wordSizeBits / 8) * blockSize; 
    }
    
    public int getNumberOfBlocks() { 
    return numLines; 
    }
    
    public int getOffsetSize() { 
    return offsetSize; 
    }
    
    public int getBlockAddressSize() { 
    return blockAddressSize; 
    }
    
    public int getBlockNumberSize() { 
    return blockNumberSize; 
    }
    
    public int getTotalCacheSize() { 
    return totalCacheSize; 
    }
    
    public int getTotalMemorySizeWords() { 
    return totalMemorySizeWords; 
    }
    
    // Methods

    public void readLocation(int address) {
        totalRequests++;
        
        blockSizeBytes = getBlockSizeBytes();
        blockAddress = address / blockSizeBytes;
        blockNumberIndex = blockAddress % numLines;
        tag = address >> (offsetSize + blockNumberSize);
        offset = address % blockSizeBytes;
        
        boolean isHit = validBits[blockNumberIndex] && tags[blockNumberIndex] == tag;
        
        if (isHit) {
            totalHits++;
        } else {
            totalMisses++;
            tags[blockNumberIndex] = tag;
            validBits[blockNumberIndex] = true;
        }
        
        printAddressBreakdown(address, blockAddress, offset, blockNumberIndex, tag, isHit);
    }

    public void print() {
        System.out.println("~~~~~~~~~~~~ CSC230 Cache Size Report ~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~ Paul Olson - Fall 2024 ~~~~~~~~~~~~");
        System.out.println("Memory : " + totalMemorySizeWords + " words of " + wordSizeBits + " bits (" + totalMemorySizeBytes + " bytes)");
        System.out.println("Cache : " + numLines + " lines with " + tagSize + " bits of tag, 1 bit for the valid flag and " + blockSize + " words of data each (" + totalCacheSize + " bits)");
    }

    public void stats() {
        double hitRatio;
        double missRatio;

        if (totalRequests == 0) {
            hitRatio = 0;
            missRatio = 0;
        } else {
            hitRatio = (totalHits * 100.0) / totalRequests;
            missRatio = (totalMisses * 100.0) / totalRequests;
        }

        System.out.println("**********");
        System.out.println("********** CSC 230 Cache Status Report");
        System.out.println("********** Paul Olson - Fall 2024");
        System.out.println("**********");
        System.out.println("\tRequests: " + totalRequests);
        System.out.printf("\tHits : %d (%.1f%%)\n", totalHits, hitRatio);
        System.out.printf("\tMisses : %d (%.1f%%)\n", totalMisses, missRatio);
    }

    private void printAddressBreakdown(int address, int blockAddress, int offset, int blockNumberIndex, int tag, boolean isHit) {
        System.out.println("Read Mem : " + address + " (" + toBinary(address, addressSizeBits) + ")");
        System.out.println("\tBlock Address : " + blockAddress + " (" + toBinary(blockAddress, blockAddressSize) + ")");
        System.out.println("\tOffset : " + offset + " (" + toBinary(offset, offsetSize) + ")");
        System.out.println("\tBlock Number : " + blockNumberIndex + " (" + toBinary(blockNumberIndex, blockNumberSize) + ")");
        System.out.println("\tTag : " + tag + " (" + toBinary(tag, tagSize) + ")");
        System.out.println("\tResult : " + (isHit ? "** Hit **" : "** Miss **"));
    }

    private int log2(int x) {
        return (int)(Math.log(x) / Math.log(2));
    }

    private String toBinary(int x, int size) {
        return String.format("%32s", Integer.toBinaryString(x))
                .replace(' ', '0')
                .substring(32 - size);
    }

  
}