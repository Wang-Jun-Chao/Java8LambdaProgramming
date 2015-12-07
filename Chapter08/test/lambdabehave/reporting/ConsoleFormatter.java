package lambdabehave.reporting;

import java.io.PrintStream;

/**
 * Author: 王俊超
 * Date: 2015-12-07 19:10
 * Declaration: All Rights Reserved !!!
 */
public class ConsoleFormatter implements ReportFormatter {

    @Override
    public void format(Report report) {
        report.suites().forEach(suite -> {
            System.out.println(suite.getName());
            System.out.println();
            suite.specifications().forEach(this::printSpecification);
        });
    }

    private void printSpecification(SpecificationReport specification) {
        boolean isSuccess = specification.getResult() == Result.SUCCESS;
        PrintStream out = isSuccess ? System.out : System.err;

        out.print("/tshould ");
        out.print(specification.getDescription());
        if (!isSuccess) {
            out.print("{");
            out.print(specification.getMessage());
            out.print("}");
        }

        out.println();
    }
}
