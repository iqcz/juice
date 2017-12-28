package crazy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 比较两个文本文件的不同
 * @author Yanxue Li
 LineNumberReader usage
 *
 */
public class CompareFileTool {

    public static void main(String[] args) {
	File file1 = new File("src/file1.txt");
	File file2 = new File("src/file2.txt");

	try (FileReader reader1 = new FileReader(file1);
		FileReader reader2 = new FileReader(file2);
		LineNumberReader lnr1 = new LineNumberReader(reader1);
		LineNumberReader lnr2 = new LineNumberReader(reader2)) {

	    String line1 = lnr1.readLine();
	    String line2 = lnr2.readLine();

	    while ((null != line1) && (null != line2)) {
		if (!line1.equals(line2)) {
		    System.out.println(file1.getName() + "和文" + file2.getName() + "在第" + lnr1.getLineNumber() + "行不同：");
		    System.out.println(file1.getName() + "：" + line1);
		    System.out.println(file2.getName() + "：" + line2);
		    System.out.println();
		}
		line1 = lnr1.readLine();
		line2 = lnr1.readLine();
	    }

	    if ((null == line1) && (null != line2)) {
		System.out.println("从第" + lnr1.getLineNumber() + "起，" + file1.getName() + "已经结束。");
	    }

	    if ((null != line1) && (null == line2)) {
		System.out.println("从第" + lnr2.getLineNumber() + "起，" + file2.getName() + "已经结束。");
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
