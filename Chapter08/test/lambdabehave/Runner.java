package lambdabehave;

import lambdabehave.example.StackSpec;
import lambdabehave.reporting.*;

/**
 * Author: 王俊超
 * Date: 2015-12-07 19:28
 * Declaration: All Rights Reserved !!!
 */
public enum Runner {
    current;

    private final Report report;

    private Runner() {
        report = new Report();
    }

    void recordSuccess(String suite, String specification) {
        report.newSpecification(suite, new SpecificationReport(specification));
    }

    void recordFailure(String suite, String specification, AssertionError cause) {
        SpecificationReport specificationReport = new SpecificationReport(
                specification, Result.FAILURE, cause.getMessage());
        report.newSpecification(suite, specificationReport);
    }
    private void printReport() {
        ReportFormatter formatter = new ConsoleFormatter();
        formatter.format(report);
    }

    private void run(Class<StackSpec> stackSpecClass) {
        try {
            stackSpecClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    void recordError(String suite, String specification, Throwable cause) {
        cause.printStackTrace();
        SpecificationReport specificationReport = new SpecificationReport(
                specification, Result.ERROR, cause.getMessage());
        report.newSpecification(suite, specificationReport);
    }

    public static void main(String[] args) {
        current.run(StackSpec.class);
        current.printReport();
    }
}
