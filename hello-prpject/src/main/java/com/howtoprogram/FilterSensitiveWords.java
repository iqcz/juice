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
 */
public class FilterSensitiveWords {
    // 分解方法,每个功能写一个方法
    // 使用三个神器
    public static void main(String[] args) throws IOException {

	Path sensitiveWordFile = Paths.get("/Users/User/Downloads/敏感词全2017-10-11-01.txt");
	List<String> newSensitiveWords = new ArrayList<>();

	newSensitiveWords = Files.readAllLines(sensitiveWordFile).stream().flatMap(line -> Stream.of(line.trim()))
		.collect(Collectors.toList());

	System.out.println(newSensitiveWords.size());

	Path sensitiveWordCsvFile = Paths.get("/Users/User/Downloads/jc_sensitivity.csv");
	List<String> sensitiveWords = Files.readAllLines(sensitiveWordCsvFile).stream()
		.flatMap(line -> Stream.of(line.trim())).collect(Collectors.toList());

	System.out.println(sensitiveWords.size());

	Set<String> txt = new HashSet<>(newSensitiveWords);
	Set<String> csv = new HashSet<>(sensitiveWords);
	// differ
	Set<String> differSensitiveWords = Sets.difference(txt, csv);
	System.out.println(differSensitiveWords.size());

	// INSERT INTO jc_sensitivity (search, replacement, level, expire, create_time)
	// VALUES ('测试敏感词', '*', 0, '2099-12-31 23:59:59', now());

	List<String> insertSqls = differSensitiveWords.stream().flatMap(line -> Stream.of(String.format(
		"INSERT INTO jc_sensitivity (search, replacement, level, expire, create_time) VALUES ('%s', '*', 0, '2099-12-31 23:59:59', now());\r",
		line))).collect(Collectors.toList());

	// write to file
	Path sensitiveWordsSql = Paths.get("/Users/User/Downloads/sensitiveWordsSql.txt");
	Files.write(sensitiveWordsSql, insertSqls);
    }
}
