package main.java.LowLevelDesign.SearchAPI;

public class Query {

    String fieldName;
    Operation operation;
    String value;

    public Query(String fieldName, Operation operation, String value) {
        this.fieldName = fieldName;
        this.operation = operation;
        this.value = value;
    }
}
