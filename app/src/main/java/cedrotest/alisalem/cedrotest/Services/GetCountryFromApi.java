//package cedrotest.alisalem.cedrotest.Services;
//
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import cedrotest.alisalem.cedrotest.Model.Country;
//import cedrotest.alisalem.cedrotest.R;
//
///**
// * Created by hamza on 27/12/17.
// */
//
//public class GetCountryFromApi {
//
//
//    void jsonParse(String url){
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>()  {
//            @Override
//            public void onResponse(JSONArray response) {
//                try {
////                    JSONArray jsonArray= response.getJSONArray( "");
////                    System.out.print("ok "+jsonArray);
//
//                    for (int i= 0; i< response.length();i++) {
//                        JSONObject countries = response.getJSONObject(i);
//                        String countyName= countries.getString("name");
//                        String countyCapitale= countries.getString("capital");
//                        list.add(new Country(R.drawable.tunis,countyName,countyCapitale));
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//        mQueue.add(jsonArrayRequest);
//    }
//}
