package com.packt.mvneclipse.javainanutshell;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 如何使用 Nashorn 从 Java 中运行 JavaScript:
 * @author TurtusLi
 *
 */
public class ScriptEngineManagerExample {

    public static void main(String[] args) {

	ScriptEngineManager m = new ScriptEngineManager();
	ScriptEngine e = m.getEngineByName("nashorn");

	try {
	    e.eval("print('Hello World!');");
	} catch (final ScriptException se) {
	    se.printStackTrace();
	}
    }

}
