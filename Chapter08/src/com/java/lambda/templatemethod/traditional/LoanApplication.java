package com.java.lambda.templatemethod.traditional;

import com.java.lambda.templatemethod.ApplicationDenied;

/**
 * Author: 王俊超
 * Date: 2015/12/7 15:13
 * All Rights Reserved !!!
 */
public abstract class LoanApplication {
    public void checkLoanApplication() throws ApplicationDenied {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity() throws ApplicationDenied;

    protected abstract void checkIncomeHistory() throws ApplicationDenied;

    protected abstract void checkCreditHistory() throws ApplicationDenied;

    private void reportFindings() {

    }
}
