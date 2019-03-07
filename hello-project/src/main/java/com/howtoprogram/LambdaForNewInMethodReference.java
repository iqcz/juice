package com.howtoprogram;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 构造方法的方法引用
 * @author i324779
 *
 */
public class LambdaForNewInMethodReference {

    public static void main(String[] args) {

	List<WebModuleDto> dtos = new ArrayList<>();
	WebModuleDto dto1 = new WebModuleDto();
	dto1.setId(1);
	dto1.setName("zhangsan");

	WebModuleDto dto2 = new WebModuleDto();
	dto2.setId(2);
	dto2.setName("lisi");

	WebModuleDto dto3 = new WebModuleDto();
	dto3.setId(3);
	dto3.setName("wangwu");

	dtos.add(dto1);
	dtos.add(dto2);
	dtos.add(dto3);

	List<WebModule> result = dtos.stream()
		.map(WebModule::new)
		.collect(Collectors.toList());
	System.out.println(result);
    }

}

class WebModule {
    private int id;
    private String name;

    public WebModule(WebModuleDto dto) {
	this.id = dto.getId();
	this.name = dto.getName();
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}

class WebModuleDto {
    private int id;
    private String name;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}