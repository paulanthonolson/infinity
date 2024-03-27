package recursion;

import java.io.File;

public class DirectoryTree {
    public static void main(String[] args) {
        scanDirectory(new File("."), "");
    }

    public static void scanDirectory(File root, String indent) {
        System.out.println(indent + root);
        indent += "    ";
        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                scanDirectory(file, indent);
            } else if (file.isFile()) {
                System.out.println(indent + file.getName() + " " + file.length());
            }
        }
    }
}
