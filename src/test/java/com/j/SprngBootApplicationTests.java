package com.j;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprngBootApplicationTests {

	@Test
	public void contextLoads() {
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");
		list1.add("6");
		list1.add("7");
		int start = 3;
		int count = 3;
		int length = list1.size();
		int startIndex = (start - 1) * count;
		if (startIndex > length) {
			return;
		}
		int endIndex = start * count;
		if (endIndex > length) {
			endIndex = length;
		}
		System.out.println("hafhsfjls:" + JSON.toJSONString(list1.subList(startIndex, endIndex)));
	}

}
