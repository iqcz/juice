package com.packt.java8inaction.bufferdemo;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadTwoLines implements BufferedReaderProcessor {

    @Override
    public String process(BufferedReader b) throws IOException {
	return b.readLine() + b.readLine();
    }

}
