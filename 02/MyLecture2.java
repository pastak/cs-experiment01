import java.util.*;
import java.io.*;

public class MyLecture2 {
  public String[] classTimes = {"Mo1", "Mo2", "Tu1", "Tu2", "We3", "Th1"};

  public String[] readFile(String intputFileName) {
    ArrayList<String> lines = new ArrayList<>();
    try {
      File inputFile = new File(intputFileName);
      Scanner sc = new Scanner(inputFile);
      while (sc.hasNext()) {
        String line = sc.next();
        lines.add(line);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Filename: " + intputFileName + "is not found");
      return null;
    }
    return lines.toArray(new String[0]);
  }

  public void outputFile (String outputFileName, String[] lines) {
    try {
      File outputFile = new File(outputFileName);
      FileWriter writer = new FileWriter(outputFile);
      for(int i = 0; i < lines.length; i++) {
        String line = lines[i];
        String classTime = classTimes[i];
        writer.write(classTime + "\t" + line + "\n");
        writer.flush();
      }
    } catch (IOException ex) {
      System.out.println("Failed to write file");
    }
  }

  public void convert(String inputFileName, String outputFileName) {
    outputFile(outputFileName, readFile(inputFileName));
  }
}
