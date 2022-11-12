package main.java.LowLevelDesign.SearchAPI;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MATCHQueryStrategy implements QueryStrategy {
    @Override
    public List<Integer> fetchMatches(List<Response> responses, String value, boolean isNestedQuery, String... fields) throws IntrospectionException, ClassNotFoundException {

        Class<?> c = Class.forName("main.java.LowLevelDesign.SearchAPI.Response");
        Method[] methods = c.getMethods();
        Response response = new Response();
        List<PropertyDescriptor> beanGettersList = Arrays.asList(Introspector.getBeanInfo(response.getClass(), Object.class).getPropertyDescriptors());
        List<String> queryFields = new ArrayList<>();

      //  responses.stream().map(Response::getAddress).filter(x->x.)

        String output = fields[0].substring(0, 1).toUpperCase().concat(fields[0].substring(1));


        List<PropertyDescriptor> collect = beanGettersList.stream().filter(p -> p.getReadMethod().getName().equals("get".concat(output))).collect(Collectors.toList());
        System.out.println(collect.size());
        Method readMethod = collect.get(0).getReadMethod();
        List<Integer> ids = responses.stream().filter(x -> {
            try {
                return readMethod.invoke(x).equals(value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }).map(Response::getId).collect(Collectors.toList());

        return ids;
    }
}
