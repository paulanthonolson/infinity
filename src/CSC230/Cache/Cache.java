package Cache;

public class Cache {
    
    private final String name;
    private final int addressSize;
    private final int wordSize;
    private final int blockSize;
    private final int numLines;
    
    private final int offsetSize;
    private final int blockNumberSize;
    private final int tagSize;
    private final int totalCacheSize;
    private final long totalMemorySizeBytes;
    
    private final int[] tags;
    private final boolean[] validBits;
    private int totalRequests = 0;
    private int totalHits = 0;
    private int totalMisses = 0;

    // Constructor
    public Cache(String name, int addressSize, int wordSize, int blockSize, int numLines) {
        this.name = name;
        this.addressSize = addressSize;
        this.wordSize = wordSize;
        this.blockSize = blockSize;
        this.numLines = numLines;
        
        this.offsetSize = log2(blockSize * (wordSize / 8));
        this.blockNumberSize = log2(numLines);
        this.tagSize = addressSize - blockNumberSize - offsetSize;
        this.totalCacheSize = numLines * (tagSize + 1 + (blockSize * wordSize));
        int totalMemorySizeWords = 1 << (addressSize - log2(wordSize/8));
        this.totalMemorySizeBytes = (long)totalMemorySizeWords * (wordSize/8);
        
        this.tags = new int[numLines];
        this.validBits = new boolean[numLines];
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
    public int getNumberOfLines() { 
        return numLines; 
    }
    public int getTotalCacheSize() { 
        return totalCacheSize; 
    }
    public int getWordSizeBytes() { 
        return wordSize / 8; 
    }
    public int getBlockSizeBytes() { 
        return getWordSizeBytes() * blockSize; 
    }

    // Methods
    public void print() {
        System.out.println("~~~~~~~~~~~~ CSC230 Cache Size Report ~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~ Paul Olson - Fall 2024 ~~~~~~~~~~~~");
        System.out.println("Memory : " + (totalMemorySizeBytes / getWordSizeBytes()) + 
                         " words of " + wordSize + " bits (" + totalMemorySizeBytes + " bytes)");
        System.out.println("Cache : " + numLines + " lines with " + tagSize + 
                         " bits of tag, 1 bit for the valid flag and " + blockSize + 
                         " words of data each (" + totalCacheSize + " bits)");
    }

    public void readLocation(int address) {
        totalRequests++;
        
        int blockSizeBytes = getBlockSizeBytes();
        int blockAddress = address / blockSizeBytes;
        int blockNumberIndex = blockAddress % numLines;
        int tag = address >> (offsetSize + blockNumberSize);
        int offset = address % blockSizeBytes;
        
        boolean isHit = validBits[blockNumberIndex] && tags[blockNumberIndex] == tag;
        
        if (isHit) {
            totalHits++;
        } else {
            totalMisses++;
            tags[blockNumberIndex] = tag;
            validBits[blockNumberIndex] = true;
        }

        System.out.println("Read Mem : " + address + " (" + binary(address, addressSize) + ")");
        System.out.println("\tBlock Address : " + blockAddress + " (" + 
                         binary(blockAddress, addressSize - offsetSize) + ")");
        System.out.println("\tOffset : " + offset + " (" + binary(offset, offsetSize) + ")");
        System.out.println("\tBlock Number : " + blockNumberIndex + " (" + 
                         binary(blockNumberIndex, blockNumberSize) + ")");
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
        System.out.printf("\tHits : %d (%.15f%%)\n", totalHits, hitRatio);
        System.out.printf("\tMisses : %d (%.15f%%)\n", totalMisses, missRatio);
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