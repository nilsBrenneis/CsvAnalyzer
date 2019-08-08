public class BenchResult {

  private String benchmarkName;
  private String vmName;
  private double mean;
  private double deviation;

  BenchResult(double mean, double deviation) {
    this.mean = mean;
    this.deviation = deviation;
  }

  public String getVmName() {
    return vmName;
  }

  public String getBenchmarkName() {
    return benchmarkName;
  }

  double getMean() {
    return mean;
  }

  double getDeviation() {
    return deviation;
  }

  public void setVmName(String vmName) {
    this.vmName = vmName;
  }

  public void setBenchmarkName(String benchmarkName) {
    this.benchmarkName = benchmarkName;
  }

  @Override
  public String toString() {
    return "Benchmark: " + benchmarkName + " | VM: "+ vmName + " | Mean: " + mean + "ms | " + "Deviation: " + deviation + "ms";
  }
}
