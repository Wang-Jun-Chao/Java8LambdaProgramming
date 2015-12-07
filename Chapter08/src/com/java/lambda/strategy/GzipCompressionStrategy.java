package com.java.lambda.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:58
 * All Rights Reserved !!!
 */
public class GzipCompressionStrategy  implements CompressionStrategy {

    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new GZIPOutputStream(data);
    }

}
