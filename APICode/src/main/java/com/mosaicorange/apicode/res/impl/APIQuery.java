package com.mosaicorange.apicode.res.impl;

/**
 * @author João Miguel Pinto
 * Email: mosaicorange@outlook.com
 * GitHub: https://github.com/MosaicOrange/Portfolio
 * LinkedIn: https://www.linkedin.com/in/mosaicorange
 *
 * Please feel free to reach out if you have any questions
*/

import com.mosaicorange.apicode.res.Innovator;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparing;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

@Path("/")
public class APIQuery {

    @GET
    @Path("/palindromes")
    @Produces({MediaType.TEXT_PLAIN})
    public String String(@QueryParam("search") String searchTerm, @QueryParam("limit") String limit) throws IOException, Exception {
        String addr = "https://api.nasa.gov/patents/content?query=" + searchTerm + "&limit=" + limit + "&api_key=DEMO_KEY";
        JSONObject json = (JSONObject) new JSONTokener(IOUtils.toString(new URL(addr))).nextValue();
        
        return this.getInnovators(json).toString();
    }

    private static List<Innovator> processJSON(JSONObject jsonObject0) {
        List<Innovator> innovators = new ArrayList<>();
        Innovator inventor;

        JSONArray jsonArray0 = jsonObject0.getJSONArray("results");
        for(int i = 0; i < jsonArray0.length(); i++) {
            JSONObject jsonObject1 = jsonArray0.getJSONObject(i);
            JSONArray jsonArray1 = jsonObject1.getJSONArray("innovator");
            for(int j = 0; j < jsonArray1.length(); j++) {
                inventor = new Innovator();
                JSONObject jsonObject2 = jsonArray1.getJSONObject(j);
                inventor.setLastName(jsonObject2.getString("lname"));
                inventor.setFirstName(jsonObject2.getString("fname"));
                innovators.add(inventor);
            }
        }
        return innovators;
    }

    private JSONArray getInnovators(JSONObject jsonObj) throws Exception {
        List<Innovator> innovators = APIQuery.processJSON(jsonObj);
        Collections.sort(innovators, comparing(Innovator::getPalindromes));
        Collections.reverse(innovators);
        JSONObject jsonOutput = new JSONObject();
        JSONArray jsonParse = new JSONArray();
        for (Innovator i : innovators) {
            jsonOutput = new JSONObject();
            jsonOutput.put("name", i.getName());
            jsonOutput.put("count", i.getPalindromes());
            jsonParse.put(jsonOutput);
        }

        return jsonParse;
    }
}
