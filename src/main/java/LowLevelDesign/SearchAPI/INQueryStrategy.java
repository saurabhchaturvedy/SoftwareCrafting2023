package main.java.LowLevelDesign.SearchAPI;

import java.util.List;

public class INQueryStrategy implements QueryStrategy{
    @Override
    public List<Integer> fetchMatches(List<Response> responses,String value,boolean isNestedQuery,String...fieldName) {
        return null;
    }
}
