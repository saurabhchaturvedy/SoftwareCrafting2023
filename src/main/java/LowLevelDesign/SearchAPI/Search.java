package main.java.LowLevelDesign.SearchAPI;

import com.google.gson.Gson;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Search {


    public static List<Integer> processSearchQuery(List<Response> responses, Query query) throws IntrospectionException, ClassNotFoundException {
        String[] attrs = new String[10];
        if (query.fieldName.indexOf(".") > 0) {
            attrs = query.fieldName.split(".");
        }
        else {
            attrs[0]= query.fieldName;
        }
        if (query.operation == Operation.IN) {
            INQueryStrategy inQueryStrategy = new INQueryStrategy();
            List<Integer> matches = inQueryStrategy.fetchMatches(responses, query.value, attrs!=null && attrs.length >= 2,attrs);
            return matches;
        }
        if (query.operation == Operation.MATCH) {
            MATCHQueryStrategy matchQueryStrategy = new MATCHQueryStrategy();
            List<Integer> matches = matchQueryStrategy.fetchMatches(responses, query.value, attrs!=null && attrs.length >= 2,attrs);
            return matches;
        }
        return null;
    }

    public static void main(String[] args) throws IOException, IntrospectionException, ClassNotFoundException {
        URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Response[] response = new Gson().fromJson(reader, Response[].class);
        System.out.println();
        ArrayList<Response> responses = Arrays.stream(response).collect(Collectors.toCollection(ArrayList::new));
        Query query = new Query("website", Operation.MATCH, "contech.com");
        List<Integer> matchedResponses = processSearchQuery(responses, query);
        System.out.println(matchedResponses);
    }
}
