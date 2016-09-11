package nl.vinyamar.algorithms.tktest;

import java.util.HashMap;
import java.util.Map;

public class Date {

	public static int calcNumberOfDays(int startMonth, int startDay, int endMonth, int endDay, boolean leapYear){

		Map<Integer, Integer> months = getValidMonthSpecs(leapYear);

		checkInput(startMonth, startDay, endMonth, endDay, months);

		int result = calcDayNumber(endMonth, endDay, months) - calcDayNumber(startMonth, startDay, months);
		System.out.println(result);
		return result;
	}

	private static int calcDayNumber(int startMonth, int startDay, Map<Integer, Integer> months) {
		int dayNum = 0;
		for(int i =1; i <= startMonth; i++) {
			if (i < startMonth) {
				dayNum = dayNum + months.get(i);
			}
			if (i == startMonth) {
				dayNum = dayNum + startDay;
			}
		}
		return dayNum;
	}

	private static Map<Integer, Integer> getValidMonthSpecs(boolean leapYear) {
		Map<Integer,Integer> months = new HashMap<>();
		months.put(1,31);
		months.put(2,leapYear? 29 : 28);
		months.put(3,31);
		months.put(4,30);
		months.put(5,31);
		months.put(6,30);
		months.put(7,31);
		months.put(8,31);
		months.put(9,30);
		months.put(10,31);
		months.put(11,30);
		months.put(12,31);
		return months;
	}

	private static void checkInput(int startMonth, int startDay, int endMonth, int endDay, Map<Integer, Integer> months) {
		if (!months.containsKey(startMonth)) {
			throw new IllegalArgumentException(String.format("startMonth %s specified is incorrect", startMonth));
		} else if (startDay < 1  || startDay > months.get(startMonth)) {
			throw new IllegalArgumentException(String.format("startDay %s specified is incorrect", startDay));
		}
		if (!months.containsKey(endMonth)) {
			throw new IllegalArgumentException(String.format("endMonth %s specified is incorrect", endMonth));
		} else if (endDay < 1  || endDay > months.get(endMonth)) {
			throw new IllegalArgumentException(String.format("endDay %s specified is incorrect", endDay));
		}
	}

	public static void main(String[] args) {
		System.out.println(calcNumberOfDays(1, 1, 12, 31, false) == 364);
		System.out.println(calcNumberOfDays(1, 1, 12, 31, true) == 365);
		System.out.println(calcNumberOfDays(11, 1, 12, 1, false) == 30);
		System.out.println(calcNumberOfDays(2, 1, 3, 1, true) == 29);
	}
}
