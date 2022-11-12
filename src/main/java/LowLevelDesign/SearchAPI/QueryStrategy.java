package main.java.LowLevelDesign.SearchAPI;

import java.beans.IntrospectionException;
import java.util.List;

public interface QueryStrategy {

    List<Integer> fetchMatches(List<Response> responses,String value,boolean isNestedQuery,String...fieldName) throws IntrospectionException, ClassNotFoundException;
}
