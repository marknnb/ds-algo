##  Java Utility metods
   ```java
// array initialisation.

   int[] outputArray = new int[inputArray.length]

   int [] array = {1,2,3,4};

   int[] outputArray = new int[]{1,2,3,4};


----------------------------------

// Sorting algo used in Java
  Java8 and before --> Quicksort.
  Now --> Timsort

----------------------------------

// How to sort array?. All methods.

  Arrays.sort(outputArray) --> in place 

  sortingArrays.stream(outputArray)
  .sorted()
  .toArray() --> using stream and new Array

  // Sort employees by name
  Arrays.sort(employees, Comparator.comparing(Employee::getName)); --> for objects

----------------------------------

// Get key of max value in Map

// 1
String key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

//2
Comparator<Map.Entry<String, Integer>> byValue = Map.Entry.comparingByValue();

Map.Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), byValue);

String keyWithMaxValue = maxEntry.getKey();

//3
Map.Entry<String, Integer> maxEntry = null;
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
        maxEntry = entry;
    }
}
String keyWithMaxValue = maxEntry.getKey();


----------------------------------

//how to check element is there in the array.

 Arrays.toList(array_name).contains(number_to_search)

 array_name => must be Integer array it can not be primitive array otherwise it will create 

list of array 

----------------------------------

// some map functions. need to understand this method
  - map.getOrdefault(key,default_value);
  - map.merge(key, 3, Integer::sum); 
  
----------------------------------
// sum all elements in an aaray

int sum = Arrays.stream(array_name).sum();
----------------------------------





  ```
// How to sort List in java8.
// Syntax of array creation.
//how to craete subarray out of array