package com.mislbd.testautomation.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUtils {

	public static void sleep(final long millis) throws IllegalArgumentException {
		try {
			Thread.sleep(millis);
		} catch (final InterruptedException e) {
		}
	}

	public static int randomBetween(final int min, final int max) {

		if (min > max) {
			throw new IllegalArgumentException("The minimum number is greater than the maximal number!");
		}

		final Random random = new Random();
		return random.nextInt(max - min + 1) + min;

	}

	public static List<Integer> randomBetweenList(final int min, final int max, final int numberOfValues) {

		if (min > max) {
			throw new IllegalArgumentException("The minimum number is greater than the maximal number!");
		}

		if (numberOfValues < 1) {
			throw new IllegalArgumentException("The number of values is smaller than one!");
		}

		final List<Integer> list = new ArrayList<>();

		int index = 0;
		loop: while (index < numberOfValues) {

			final Integer random = Integer.valueOf(randomBetween(min, max));

			for (final Integer number : list) {

				if (number.equals(random) && number != null) {
					continue loop;
				}

			}

			list.add(random);
			index++;

		}

		return list;

	}

	public static String isDuplicatePresent(final List<String> list) {

		final int size = list.size();

		if (list.isEmpty() || size == 0) {
			throw new NullPointerException("List is empty!");
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (list.get(i).equals(list.get(j)) && i != j) {
					return list.get(i);
				}
			}
		}

		return null;

	}

	public static boolean isAllEquals(final List<String> list) {

		final int size = list.size();

		if (list.isEmpty() || size == 0) {
			throw new NullPointerException("List is empty!");
		}

		boolean isAllEquals = false;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (list.get(i).equals(list.get(j))) {
					isAllEquals = true;
				} else {
					return false;
				}
			}
		}

		return isAllEquals;

	}

	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {

		return Period.between(birthDate, currentDate).getYears();

	}

	public static String birthDay(String string){

		String[] parts = string.split("-");
		String dayPart = parts[0];
		int dayInt = Integer.parseInt(dayPart);
		String dayString = Integer.toString(dayInt);

		return dayString;

	}

	public static String birthMonth(String string){

		String[] parts = string.split("-");
		String monthPart = parts[1];
		int actualMonth = Integer.parseInt(monthPart) - 1;
		String actualMonthInString = Integer.toString(actualMonth);

		return actualMonthInString;
	}

	public static String birthYear(String string){

		String[] parts = string.split("-");
		String yearPart = parts[2];

		return yearPart;
	}

	public static String day(String string){

		String[] parts = string.split("/");
		String dayPart = parts[1];
		int dayInt = Integer.parseInt(dayPart);
		String dayString = Integer.toString(dayInt);

		return dayString;

	}

	public static String month(String string){

		String[] parts = string.split("/");
		String monthPart = parts[0];
		int actualMonth = Integer.parseInt(monthPart) - 1;
		String actualMonthInString = Integer.toString(actualMonth);

		return actualMonthInString;
	}

	public static String year(String string){

		String[] parts = string.split("/");
		String yearPart = parts[2];

		return yearPart;
	}




}
