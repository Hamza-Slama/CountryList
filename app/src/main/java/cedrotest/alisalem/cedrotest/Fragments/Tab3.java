package cedrotest.alisalem.cedrotest.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import cedrotest.alisalem.cedrotest.Activities.CedroCounties;
import cedrotest.alisalem.cedrotest.Adapter.MyCountryAdapter;
import cedrotest.alisalem.cedrotest.Model.Country;
import cedrotest.alisalem.cedrotest.R;

/**
 * Created by seifkhirouni on 21/12/2017.
 */

public class Tab3 extends Fragment {
    public Button button3;
    private TextView textViewResult;
    private ImageView ig_countries;
    private RequestQueue mQueue;
    private ArrayList<Country> liste_visited;
    MyCountryAdapter myCounterAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);
        GridView grid = (GridView) rootView.findViewById(R.id.grid_country_tab_visited);
        liste_visited = new ArrayList<Country>();
        mQueue = Volley.newRequestQueue(rootView.getContext());
        final String url = "https://restcountries.eu/rest/v2/all?fields=name;capital;population;flag;region";
//        jsonParse(url);
//        System.out.println("liste_visited.size()) G =  "+liste_visited.size());
        liste_visited.add(new Country("https://restcountries.eu/data/abw.svg","countyName","countyCapitale","countyRegion","countyPopulatio"));
        liste_visited.add(new Country("https://restcountries.eu/data/abw.svg","countyName","countyCapitale","countyRegion","countyPopulatio"));
        liste_visited.add(new Country("https://restcountries.eu/data/abw.svg","countyName","countyCapitale","countyRegion","countyPopulatio"));
        liste_visited.add(new Country("https://restcountries.eu/data/abw.svg","countyName","countyCapitale","countyRegion","countyPopulatio"));
        liste_visited.add(new Country("https://restcountries.eu/data/abw.svg","countyName","countyCapitale","countyRegion","countyPopulatio"));
        liste_visited.add(new Country("https://restcountries.eu/data/abw.svg","countyName","countyCapitale","countyRegion","countyPopulatio"));


        MyCountryAdapter myCounterAdapter = new MyCountryAdapter(rootView.getContext(), liste_visited);
        grid.setAdapter(myCounterAdapter);
        myCounterAdapter.notifyDataSetChanged();

        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.fragment_tab3);

        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        jsonParse(url);
                        ((CedroCounties) getActivity()).refreshNow();
                        System.out.println("Tab 3 ( Refrech) = "+liste_visited.size());

//                        Toast.makeText(getContext(), "Refresh Layout working", Toast.LENGTH_LONG).show();
                    }
                }
        );
        return rootView;
    }

    public void jsonParse(String url){
        //todo :shit !!
        liste_visited = new ArrayList<Country>();
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
                        liste_visited.add(new Country(countyFlag,countyName,countyCapitale,countyRegion,countyPopulation));
                    }
                    System.out.println("Tab 3 ( jsonSize) =  "+liste_visited.size());
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
