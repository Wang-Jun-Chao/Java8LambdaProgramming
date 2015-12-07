package com.java.lambda.templatemethod.lambdas;

import com.java.lambda.templatemethod.ApplicationDenied;

/**
 * Author: 王俊超
 * Date: 2015/12/7 15:17
 * All Rights Reserved !!!
 */
public class LoanApplication {
    private final Criteria identity;
    private final Criteria creditHistory;
    private final Criteria incomeHistory;

    public LoanApplication(Criteria identity,
                           Criteria creditHistory,
                           Criteria incomeHistory) {

        this.identity = identity;
        this.creditHistory = creditHistory;
        this.incomeHistory = incomeHistory;
    }

    public void checkLoanApplication() throws ApplicationDenied {
        identity.check();
        creditHistory.check();
        incomeHistory.check();
        reportFindings();
    }

    private void reportFindings() {
    }
}
