import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


  public static void main(String[] args) {
    File[] directories = new File("/home/nils/Programme/RenaissanceBench/results/").listFiles(File::isDirectory);
    for (File folder: directories) {
      printPerBenchmark(folder.getName());
    }
  }

  public static void printPerBenchmark(String benchmarkName) {
    printCsvAnalysis("/home/nils/Programme/RenaissanceBench/results/" + benchmarkName + "/jh.csv");
    printCsvAnalysis("/home/nils/Programme/RenaissanceBench/results/" + benchmarkName + "/ce.csv");
    printCsvAnalysis("/home/nils/Programme/RenaissanceBench/results/" + benchmarkName + "/ee.csv");
    System.out.println();
  }

  public static void printCsvAnalysis(String fileName) {
    CsvReader reader = new CsvReader(fileName);
    ArrayList<Double> resultsInMilliSecs = reader.getMilliSecListFromCsv();
    BenchResult resultForPlot = reader.getBenchResult(resultsInMilliSecs);

    String[] fileNameSplit = fileName.split("/");
    String benchmark = fileNameSplit[6];
    String vmName = fileNameSplit[7].split("\\.")[0];

    resultForPlot.setBenchmarkName(benchmark);
    resultForPlot.setVmName(vmName);

    System.out.println(resultForPlot.toString());
  }
}
