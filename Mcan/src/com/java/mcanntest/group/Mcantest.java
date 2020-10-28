package com.java.mcanntest.group;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Mcantest {

	public int getHighestNumberFromCollection(Integer[] inputCollection) {
		List<Integer> listOfIntegers = Arrays.asList(inputCollection);
		Integer max = listOfIntegers.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

		return max;
	}

	public List<String> getStringsInCollectionThatContainsInputString(String search, String[] inputCollectionArray) {
		List<String> inputCollection = Arrays.asList(inputCollectionArray);
		List<String> collectionToReturn = inputCollection.stream().filter(str -> str.trim().contains(search))
				.collect(Collectors.toList());

		return collectionToReturn;
	}

	public HashMap<String, Integer> getOccurenceOfStringInCollection(String[] inputCollectionArray) {
		HashMap<String, Integer> mapToCalculate = new HashMap<String, Integer>();
		HashMap<String, Integer> mapToReturn = new HashMap<String, Integer>();

		List<String> inputCollection = Arrays.asList(inputCollectionArray);
		for (String stringToCheck : inputCollection) {
			if (mapToCalculate.containsKey(stringToCheck)) {
				mapToCalculate.put(stringToCheck, mapToCalculate.get(stringToCheck) + 1);
			} else {
				mapToCalculate.put(stringToCheck, 1);
			}
		}

		int maxValueInMap = (Collections.max(mapToCalculate.values()));
		for (Entry<String, Integer> entry : mapToCalculate.entrySet()) {
			if (entry.getValue() == maxValueInMap) {
				mapToReturn.put(entry.getKey(), entry.getValue());
			}
		}

		return mapToReturn;
	}

	public static void main(String[] args) {
		Mcantest mcantest = new Mcantest();

		// 1st item Given
		Integer[] inputCollection = new Integer[5];
		inputCollection[0] = 1;
		inputCollection[1] = 2;
		inputCollection[2] = 3;
		inputCollection[3] = 4;
		inputCollection[4] = 9;
		// Then
		System.out
				.println("getHighestNumberFromCollection: " + mcantest.getHighestNumberFromCollection(inputCollection));

		// 2nd item Given
		String[] inputCollection2 = new String[8];
		inputCollection2[0] = "anastacia";
		inputCollection2[1] = "bravo";
		inputCollection2[2] = "banana";
		inputCollection2[3] = "cabana";
		inputCollection2[4] = "elevator";
		inputCollection2[5] = "date";
		inputCollection2[6] = "vapor";
		inputCollection2[7] = "late";
		// Then
		System.out.println("getStringsInCollectionThatContainsInputString 1: "
				+ mcantest.getStringsInCollectionThatContainsInputString("ana", inputCollection2));
		System.out.println("getStringsInCollectionThatContainsInputString 2: "
				+ mcantest.getStringsInCollectionThatContainsInputString("mmm", inputCollection2));

		/*
		 * // 1st item Given Data #1 Input - “the”, “quick”, “brown”, “fox”, “jumps”,
		 * “over”, “the”,“lazy”,“dog” Output - “the”, 2
		 */
		String[] inputCollection3 = new String[9];
		inputCollection3[0] = "the";
		inputCollection3[1] = "quick";
		inputCollection3[2] = "brown";
		inputCollection3[3] = "fox";
		inputCollection3[4] = "jumps";
		inputCollection3[5] = "over";
		inputCollection3[6] = "the";
		inputCollection3[7] = "lazy";
		inputCollection3[8] = "dog";

		// then
		System.out.println(
				"getOccurenceOfStringInCollection 1: " + mcantest.getOccurenceOfStringInCollection(inputCollection3));

		/*
		 * // 1st item Given Data #2 Input - “rain”, “rain”, “go”, “away”, “come”,
		 * “again”, “another”, “day” Output - “rain”, 2
		 */
		String[] inputCollection4 = new String[8];
		inputCollection4[0] = "rain";
		inputCollection4[1] = "rain";
		inputCollection4[2] = "go";
		inputCollection4[3] = "away";
		inputCollection4[4] = "come";
		inputCollection4[5] = "again";
		inputCollection4[6] = "another";
		inputCollection4[7] = "day";

		// then
		System.out.println(
				"getOccurenceOfStringInCollection 2: " + mcantest.getOccurenceOfStringInCollection(inputCollection4));

	}
}
