package com.java.lambda.templatemethod.lambdas;

/**
 * Author: 王俊超
 * Date: 2015/12/7 15:18
 * All Rights Reserved !!!
 */
public class CompanyLoanApplication extends LoanApplication {
    public CompanyLoanApplication(Company company) {
        super(company::checkIdentity,
                company::checkHistoricalDebt,
                company::checkProfitAndLoss);
    }
}
