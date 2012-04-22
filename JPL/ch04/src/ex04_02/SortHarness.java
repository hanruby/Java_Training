package ex04_02;

public interface SortHarness {
    SortMetrics sort(Object[] data);
    SortMetrics getMetrics();
}
