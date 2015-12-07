package com.java.lambda.templatemethod;

/**
 * Author: 王俊超
 * Date: 2015/12/7 15:11
 * All Rights Reserved !!!
 */
public interface Company {
    void checkIdentity() throws ApplicationDenied;

    void checkProfitAndLoss() throws ApplicationDenied;

    void checkHistoricalDebt() throws ApplicationDenied;
}
