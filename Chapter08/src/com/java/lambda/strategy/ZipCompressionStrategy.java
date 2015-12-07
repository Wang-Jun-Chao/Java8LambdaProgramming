package com.java.lambda.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:59
 * All Rights Reserved !!!
 */
public class ZipCompressionStrategy implements CompressionStrategy {

    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new ZipOutputStream(data);
    }

}
