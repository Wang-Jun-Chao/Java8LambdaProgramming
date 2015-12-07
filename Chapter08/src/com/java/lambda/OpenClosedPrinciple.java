package com.java.lambda;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: 王俊超
 * Date: 2015/12/7 15:32
 * All Rights Reserved !!!
 */
public class OpenClosedPrinciple {
    public void asHigherOrderFunctions() {
        ThreadLocal<DateFormat> localFormatter = ThreadLocal.withInitial(SimpleDateFormat::new);

        DateFormat formatter = localFormatter.get();
        AtomicInteger threadId = new AtomicInteger();

        ThreadLocal<Integer> localId = ThreadLocal.withInitial(threadId::getAndIncrement);
        int idForThisThread = localId.get();
    }
}
