package positionallistexamples;

import java.io.IOException;

public class PS3Load {
    public static void main(String[] args) {
        try {
            ProgramOfStudy ps = ProgramOfStudy.load("ProgramOfStudy.csc");
            System.out.println("Loaded from disk");
            System.out.println(ps);
        } catch (IOException e) {
            System.out.println("Load failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
