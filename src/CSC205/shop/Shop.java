package shop;

import queue.*;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;

public class Shop {
    public static void main(String[] args) {
        final String SEP = "================  ";
        Scanner scnr = new Scanner(System.in);
        FileInputStream fis = null;
        Scanner inFS = null;
        String inputFileName = "shopitems.txt";
        FileOutputStream fos = null;
        PrintWriter outFS = null;
        String item = null;
        String category = null;
        String outputFileName = "shoplist.txt";

        QueueInterface<String>[] categories = new ArrayQueue[4];
        for (int i = 0; i < 4; i++) {
            categories[i] = new ArrayQueue<>();
        }

        try {
            fis = new FileInputStream(inputFileName);
            inFS = new Scanner(fis);
            fos = new FileOutputStream(outputFileName);
            outFS = new PrintWriter(fos);

            String[] categoryNames = new String[4];
            int categoryIndex = 0;
            int distinctCategories = 0;

            while (inFS.hasNextLine() && distinctCategories < 4) {
                String line = inFS.nextLine().trim();
                String[] parts = line.split("\\s+", 2);
                if (parts.length >= 2) {
                    String newCategory = parts[0].trim();
                    int existingIndex = getCategoryIndex(newCategory, categoryNames);

                    if (existingIndex == -1) {
                        categoryNames[categoryIndex] = newCategory;
                        categories[categoryIndex].enqueue(parts[1].trim());
                        categoryIndex++;
                        distinctCategories++;
                    } else {
                        categories[existingIndex].enqueue(parts[1].trim());
                    }
                }
            }

            while (inFS.hasNextLine()) {
                String line = inFS.nextLine().trim();
                int firstSpaceIndex = line.indexOf(' ');

                if (firstSpaceIndex != -1) {
                    category = line.substring(0, firstSpaceIndex).trim();
                    item = line.substring(firstSpaceIndex + 1).trim();

                    categoryIndex = getCategoryIndex(category, categoryNames);

                    if (categoryIndex >= 0 && categoryIndex < distinctCategories) {
                        categories[categoryIndex].enqueue(item);
                    } else {
                        System.out.println(category + " is not a valid area of the store, " + item + " skipped.");
                    }
                }
            }

            int[] originalSizes = new int[distinctCategories];

            for (int i = 0; i < distinctCategories; i++) {
                originalSizes[i] = categories[i].size();
                outFS.printf("%-18s", categoryNames[i]);
            }

            outFS.println();

            for (int i = 0; i < distinctCategories; i++) {
                outFS.print(SEP);
            }
            outFS.println();

            QueueInterface<String>[] tempCategories = new ArrayQueue[distinctCategories];
            for (int i = 0; i < distinctCategories; i++) {
                tempCategories[i] = new ArrayQueue<>();
            }

            int maxItemCount = getMaxItemCount(categories);

            for (int j = 0; j < maxItemCount; j++) {
                for (int i = 0; i < distinctCategories; i++) {
                    QueueInterface<String> categoryQueue = categories[i];
                    QueueInterface<String> tempCategoryQueue = tempCategories[i];

                    if (!categoryQueue.isEmpty()) {
                        item = categoryQueue.dequeue();
                        outFS.printf("%-18.16s", item);
                        tempCategoryQueue.enqueue(item);
                    } else {
                        outFS.printf("%-18s", "");
                    }
                }
                outFS.println();
            }

            for (int i = 0; i < distinctCategories; i++) {
                outFS.print(SEP);
            }
            outFS.println();

            for (int i = 0; i < distinctCategories; i++) {
                outFS.printf("%-18d", originalSizes[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e.getMessage());
        } catch (IOError e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            if (inFS != null) {
                inFS.close();
            }
            if (outFS != null) {
                outFS.close();
            }
        }
        scnr.close();
    }

    private static int getMaxItemCount(QueueInterface<String>[] categories) {
        int maxItemCount = 0;
        for (int i = 0; i < categories.length; i++) {
            maxItemCount = Math.max(maxItemCount, categories[i].size());
        }
        return maxItemCount;
    }

    private static int getCategoryIndex(String category, String[] categoryNames) {
        for (int i = 0; i < categoryNames.length; i++) {
            if (category.equals(categoryNames[i])) {
                return i;
            }
        }
        return -1;
    }
}
