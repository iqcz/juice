package com.guava.chapter2.charsets;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.google.common.base.Charsets;

public class CharsetsTest {

    @Test
    public void testCharsets() {
        byte[] bytes = null;
        try {
            bytes = "foobarbaz".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            //This really can't happen UTF-8 must be supported
        }

        byte[] bytes2 = "foobarbaz".getBytes(Charsets.UTF_8);
        System.out.println(Charsets.UTF_8.name());
        System.out.println(Charsets.UTF_8.displayName());
        System.out.println(Charsets.UTF_8.aliases());

        assertThat(bytes, is(bytes2));
    }
}
