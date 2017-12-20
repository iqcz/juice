package lambdasinaction.mydemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author i324779
 * 在不用重新启动服务器的情况下加载修改的配置信息：
 * 主要用途如下：
 * 1，计算的公式，参数需要修改
 * 2，返回静态的字符串，
 * 3，加载配置
 * 4，sql语句
 * 5. JSON data etc
 */
public class JavaInvokeJS {

    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
	ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
	Bindings bind = engine.createBindings();
	bind.put("factor", 0);
	engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);

	// 输入方式
	try (Scanner input = new Scanner(System.in);) {
	    while (input.hasNextInt()) {
		int first = input.nextInt();
		int second = input.nextInt();

		System.out.println("输入的参数是：" + first + ", " + second);
		engine.eval(new FileReader("src/main/java/lambdasinaction/mydemo/model.js"));

		if (engine instanceof Invocable) {
		    Invocable in = (Invocable) engine;
		    // 执行 js函数
		    Double result = (Double) in.invokeFunction("formula", first, second);
		    System.out.println("运算结果是：" + result.intValue());
		    
		    String ids = (String) in.invokeFunction("allArtile");
		    System.out.println("运算结果是：" + ids);
		}
	    }
	}
    }
}