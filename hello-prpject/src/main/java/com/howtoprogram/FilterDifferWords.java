package com.howtoprogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Sets;

/**
 * Created by 324779.
 * 比较两个文件中文本内容的不同，把第一个文本中不同的部分挑选出来，
 * 拼成对应的insert语句，
 * 最后写入文件中。
 */
public class FilterDifferWords {

    public static void main(String[] args) throws IOException {
	Path txtFile = Paths.get("/Users/i324779/Documents/test.txt");
	List<String> txtContent = loadContentFromFile(txtFile);

	Path csvFile = Paths.get("/Users/i324779/Documents/test.csv");
	List<String> csvContent = loadContentFromFile(csvFile);
	
	// List 转换为Set是为了文本内容去重
	// 使用Google Guava工具中的Sets类
	Set<String> differContent = Sets.difference(new HashSet<>(txtContent), new HashSet<>(csvContent));

	List<String> insertSqls = spliceSql(differContent);

	writeToFile(insertSqls);
    } // end method main

    /**
     * @param filePath 文件路径
     * @return 读取文件中内容到列表中。
     * @throws IOException
     */
    private static List<String> loadContentFromFile(Path filePath) throws IOException {
	return Files.readAllLines(filePath).stream()
		.flatMap(line -> Stream.of(line.trim())) // 去掉文本中空格
		.collect(Collectors.toList());
    } // end method loadContentFromFile

    /**
     * 	拼装insert语句，使用MYSQL数据库的语法
     * @param differContent 两个文本比较后，第一个文本有，而第二个文本没有的内容。
     * @return 拼装好insert语句的列表
     */
    private static List<String> spliceSql(Set<String> differContent) {
	return differContent.stream()
		.flatMap(line -> Stream.of(String.format(
		"INSERT INTO test(search, replacement, level, expire, create_time) "
		+ "VALUES ('%s', '*', 0, '2099-12-31 23:59:59', now());\r",
		line)))
		.collect(Collectors.toList());
    } // end method spliceSql

    /**
     * 把列表中的sql语句写入文件中
     * @param insertSqls 拼装好insert语句的列表
     * @throws IOException
     */
    private static void writeToFile(List<String> insertSqls) throws IOException {
	Path sqlFile = Paths.get("/Users/i324779/Documents/insertSql.txt");
	Files.write(sqlFile, insertSqls);
    } // end method writeToFile
    
} // end class FilterDifferWords
