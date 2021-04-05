package com.employeefeedback;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HighestFeedback {

	public static void highestFeedback(int[] metlife, int[] hartford, int size) {
		int[] feedback;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();

		for (int i = 1; i < metlife.length; i++) {
			m.put(metlife[i - 1], metlife[i]);
			i = i + 1;
		}
		for (int j = 1; j < hartford.length; j++) {
			if (m.containsKey(hartford[j - 1])) {
				if (m.get(hartford[j - 1]) < hartford[j])
					m.put(hartford[j - 1], hartford[j]);
			} else {
				m.put(hartford[j - 1], hartford[j]);
			}
			j = j + 1;
		}
		feedback = new int[m.entrySet().size() * 2];
		int k = 0;
		for (Entry<Integer, Integer> map : m.entrySet()) {
			feedback[k] = map.getKey();
			System.out.println(feedback[k]);
			k++;
			feedback[k] = map.getValue();
			System.out.println(feedback[k]);
			if (k < m.entrySet().size() * 2) {
				k++;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		boolean flag = false;
		if (size < 0) {
			System.out.println("invalid size");
		} else {
			int[] metlife = new int[size];
			int[] hartford = new int[size];
			for (int i = 0; i < metlife.length; i++) {
				metlife[i] = sc.nextInt();
				if (metlife[i] < 0) {
					System.out.println("invalid number");
					flag = true;
					break;
				}

			}
			for (int i = 0; i < hartford.length; i++) {
				hartford[i] = sc.nextInt();
				if (hartford[i] < 0) {
					System.out.println("invalid number");
					flag = true;
					break;
				}

			}
			if (!flag)
				highestFeedback(metlife, hartford, size);
		}

	}
}
