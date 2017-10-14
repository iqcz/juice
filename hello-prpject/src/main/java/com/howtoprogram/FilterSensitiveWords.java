package com.howtoprogram;

import com.google.common.collect.Sets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by User on 13/10/2017.
 * 比较两个文件中文本内容的不同，把第一个文本中不同的部分挑选出来，
 * 拼成对应的insert语句，
 * 最后写入文件中。
 */
public class FilterSensitiveWords {
 
    public static void main(String[] args) throws IOException {
	Path sensitiveWordFile = Paths.get("/Users/User/Downloads/test.txt");
	List<String> newSensitiveWords = loadContentFromFile(sensitiveWordFile);

	Path sensitiveWordCsvFile = Paths.get("/Users/User/Downloads/test.csv");
	List<String> sensitiveWords = loadContentFromFile(sensitiveWordCsvFile);

	// List 转换为Set是为了文本内容去重
	Set<String> txt = new HashSet<>(newSensitiveWords);
	Set<String> csv = new HashSet<>(sensitiveWords);

	// 使用Google Guava工具中的方法，Sets.difference方法比较第一个参数和第二个参数的不同，
	// 并返回第一个参数里的不在第二个参数里的内容。
	Set<String> differSensitiveWords = Sets.difference(txt, csv);
	// FYI: Sets 中还有很多关于集合的操作，例如求交集，并集等，非常实用。

	// 拼装insert 语句，使用MYSQL数据库
	List<String> insertSqls = differSensitiveWords.stream()
		.flatMap(line -> Stream.of(String.format(
		"INSERT INTO test(search, replacement, level, expire, create_time) VALUES ('%s', '*', 0, '2099-12-31 23:59:59', now());\r",
		line)))
		.collect(Collectors.toList());

	// 把拼装好的sql语句写入文件中。
	Path sensitiveWordsSql = Paths.get("/Users/User/Downloads/sensitiveWordsSql.txt");
	Files.write(sensitiveWordsSql, insertSqls);
    }

    private static List<String> loadContentFromFile(Path sensitiveWordFile) throws IOException {
	List<String> newSensitiveWords = new ArrayList<>();
	newSensitiveWords = Files.readAllLines(sensitiveWordFile).stream()
		.flatMap(line -> Stream.of(line.trim())) // 去掉文本中空格
		.collect(Collectors.toList());

	return newSensitiveWords;
    }
}
