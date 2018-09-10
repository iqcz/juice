package upgradingtojava8.chapter08;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineDemo2 {

    public static void main(String... args) {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");
        // evaluate JavaScript file

        try {
            engine.eval(new FileReader("jjstest/test1.js"));
        } catch (FileNotFoundException | ScriptException e) {
            e.printStackTrace();
        }
    }
}
