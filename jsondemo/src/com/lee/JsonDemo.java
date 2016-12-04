package com.lee;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ���^�ɂ�role����������ڣ��t����ӣ��������ڣ�ȫ����ӣ�
 * �������һ��role���t�����һ��role��
 * @author TurtusLi
 *
 */
public class JsonDemo {

	public static void main(String[] args) {

		JSONArray roles = new JSONArray();

		JSONObject mkkRole = new JSONObject();
		mkkRole.put("role", "MKK");

		JSONObject zbp001Role = new JSONObject();
		zbp001Role.put("role", "ZBP001");

		// roles.add(mkkRole);
		// roles.add(zbp001Role);

		List<String> rolesList = new ArrayList<>();
//		rolesList.add("MKK");
		rolesList.add("ZBP001");
//		rolesList.add("Other");

		String role = "";
		for (int i = 0; i < rolesList.size(); i++) {
			role += rolesList.get(i) + ",";
		}
		System.out.println(role);

		if (!role.contains("MKK") && !role.contains("ZBP001")) {
			System.out.println("MKK & ZBP001");
		} else if (role.contains("MKK") && !role.contains("ZBP001")) {
			System.out.println("ZBP001");
		} else if (role.contains("ZBP001") && !role.contains("MKK")) {
			System.out.println("MKK");
		} else {
			System.out.println("Other");
		}

	}

}
