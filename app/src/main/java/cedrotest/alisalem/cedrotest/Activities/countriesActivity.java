package cedrotest.alisalem.cedrotest.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cedrotest.alisalem.cedrotest.Adapter.MyCountryAdapter;
import cedrotest.alisalem.cedrotest.Model.Country;
import cedrotest.alisalem.cedrotest.R;

public class countriesActivity extends AppCompatActivity {
    private TextView textViewResult;
    private ImageView ig_countries;
    private RequestQueue mQueue;
    public ArrayList<Country> list ;
    MyCountryAdapter myCounterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

//        System.out.println("list.size())1 "+list.size());
        GridView grid = (GridView)findViewById(R.id.grid_country);

        mQueue= Volley.newRequestQueue(this);
        String url ="https://restcountries.eu/rest/v2/all?fields=name;capital;population;flag;region";
        jsonParse(url);
//        System.out.println("list.size()) G =  "+list.size());
        MyCountryAdapter myCounterAdapter =  new MyCountryAdapter(this,list);
        grid.setAdapter(myCounterAdapter);
    }

    public void jsonParse(String url){
        //todo :shit !!
        list = new ArrayList<Country>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>()  {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i= 0; i< response.length();i++) {
                        JSONObject countries = response.getJSONObject(i);
//                        System.out.println("countries : "+countries);
                        String countyFlag= countries.getString("flag");
                        String countyName= countries.getString("name");
                        String countyCapitale= countries.getString("capital");
                        String countyRegion= countries.getString("region");
                        String countyPopulation= countries.getString("population");
                        list.add(new Country(countyFlag,countyName,countyCapitale,countyRegion,countyPopulation));
                    }
                    System.out.println("list.size()) json =  "+list.size());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mQueue.add(jsonArrayRequest);
    }
}
