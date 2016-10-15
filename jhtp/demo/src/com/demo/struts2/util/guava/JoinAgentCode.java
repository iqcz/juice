package com.demo.struts2.util.guava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinAgentCode {

	public static void main(String[] args) {

		Map<String, String> m1 = new HashMap<>();
		m1.put("AppNum", "10001");
		m1.put("PolicyId", "20001");
		m1.put("Owner", "admin");
		m1.put("Message", "OK");

		Map<String, String> m2 = new HashMap<>();
		m2.put("AppNum", "10002");
		m2.put("PolicyId", "20002");
		m2.put("Owner", "guest");
		m2.put("Message", "Failed");

		Map<String, String> m3 = new HashMap<>();
		m3.put("AppNum", "10003");
		m3.put("PolicyId", "20003");
		m3.put("Owner", "admin");
		m3.put("Message", "OK");

		Map<String, String> m4 = new HashMap<>();
		m4.put("AppNum", "10004");
		m4.put("PolicyId", "20004");
		m4.put("Owner", "lzl");
		m4.put("Message", "NS");

		Map<String, String> m5 = new HashMap<>();
		m5.put("AppNum", "10005");
		m5.put("PolicyId", "20005");
		m5.put("Owner", "zbz");
		m5.put("Message", "SX");

		Map<String, String> m6 = new HashMap<>();
		m6.put("AppNum", "10006");
		m6.put("PolicyId", "20006");
		m6.put("Owner", "wbx");
		m6.put("Message", "ch");

		List<Map<String, String>> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);

		List<PolicyIssue> ipList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			PolicyIssue ip = new PolicyIssue();

			Map<String, String> iMap = new HashMap<>();
			iMap = list.get(i);

			String iAppNum = iMap.get("AppNum");
			String iPolicyId = iMap.get("PolicyId");
			ip.setAppNum(iAppNum);
			ip.setPolicyId(iPolicyId);
			ip.setOwner(iMap.get("Owner"));
			ip.setMessage(iMap.get("Message"));

			for (int j = list.size() - 1; j > i; j--) {
				Map<String, String> jMap = new HashMap<>();
				jMap = list.get(j);

				String jAppNum = jMap.get("AppNum");
				String jPolicyId = jMap.get("PolicyId");

				if (iAppNum.equals(jAppNum) && iPolicyId.equals(jPolicyId)) {
					ip.setOwner(ip.getOwner() + ", " + jMap.get("Owner"));
					list.remove(j);
				}
			}
			ipList.add(ip);
		}

		System.out.println(ipList);
	}

}
