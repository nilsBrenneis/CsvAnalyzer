import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class CsvReader {

  private final String fileName;

  CsvReader(String fileName) {
    this.fileName = fileName;
  }

  BenchResult getBenchResult(ArrayList<Double> values) {
    double sum = 0.0;
    for(double value : values) {
      sum += value;
    }

    int countValues = values.size();
    double deviation = 0.0;
    double mean = sum / countValues;
    for(double num: values) {
      deviation += Math.pow(num - mean, 2);
    }
    return new BenchResult(mean, Math.sqrt(deviation/countValues));
  }

  ArrayList<Double> getMilliSecListFromCsv() {
    ArrayList<Double> milliSecResults = new ArrayList<>();
    int nanoSecColumn = 1;
    String splitBy = ",";
    BufferedReader br = null;
    String line;
    String benchmarkName;

    try {
      br = new BufferedReader(new FileReader(fileName));
      br.readLine(); //read first row with column names
      while ((line = br.readLine()) != null) {
        String singleNanoSecResult = line.split(splitBy)[nanoSecColumn];
        double singleMilliSecResult = Double.parseDouble(singleNanoSecResult) / 1000000;
        milliSecResults.add(singleMilliSecResult);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return milliSecResults;
  }
}
