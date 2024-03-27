package in_class;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ch10_TextFileWriteSample 
{
  public static void main(String[] args) throws IOException 
  {
     FileOutputStream fileStream = null;
     PrintWriter outFS = null;

     // Try to open file
     fileStream = new FileOutputStream("myoutfile.txt");
     outFS = new PrintWriter(fileStream);

     // Arriving here implies that the file can now be written
     // to, otherwise an exception would have been thrown.
     
     System.out.println("begin printing data to the file");
     
     outFS.println("Hello");
     outFS.println("1 2 3");

     System.out.println("done printing data to the file");
     
     // Done with file, so try to close
     // Note that close() may throw an IOException on failure
     outFS.close();
  }
}
/*
Contents of
myoutfile.txt:
Hello
1 2 3
*/
