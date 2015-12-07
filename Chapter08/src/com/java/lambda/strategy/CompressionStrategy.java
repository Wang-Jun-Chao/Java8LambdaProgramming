package com.java.lambda.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:57
 * All Rights Reserved !!!
 */
public interface CompressionStrategy {
    OutputStream compress(OutputStream data) throws IOException;
}
