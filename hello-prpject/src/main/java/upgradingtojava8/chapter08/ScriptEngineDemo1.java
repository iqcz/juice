package upgradingtojava8.chapter08;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineDemo1 {

    public static void main(String... args) {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("nashorn");

        try {
            engine.eval("print('A taste of Nashorn');");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
