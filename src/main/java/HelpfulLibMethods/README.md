
# Helpful lib methods for coding problems/interviews




## Installation

Convert list to array

```bash
 String[] strings = list.stream().toArray(String[]::new);
```

Convert array to list

```bash
 Arrays.stream(numbers).boxed().collect(Collectors.toList());
```

Sort a Map by values

```bash
 Map<String,Person> map = new HashMap<>();
map.put("g",new Person(5, "EE", 51, Person.SEX.FEMALE, "A"));
map.put("a",new Person(4, "DD", 25, Person.SEX.MALE, "D"));
map.put("e",new Person(3, "CC", 44, Person.SEX.FEMALE,"B"));

Map<String,Person> sortedNewMap = map.entrySet().stream().sorted((e1,e2)->
        e1.getValue().getLocation().compareTo(e2.getValue().getLocation()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));
sortedNewMap.forEach((key,val)->{
    System.out.println(key+ " = "+ val.toString());
});

OR 

map.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
        .limit(10) 
        .forEach(System.out::println);
```

Sort map by Key using Comparator

```bash
 Comparator<Name> byName = (Name o1, Name o2)-> o1.getFirstName().compareTo(o2.getFirstName());
		
LinkedHashMap<Name, Integer> sortedMap = map.entrySet().stream()
                                            .sorted(Map.Entry.<Name,Integer>comparingByKey(byName))
                                            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
```
    