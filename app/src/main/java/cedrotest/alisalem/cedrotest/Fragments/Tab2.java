package cedrotest.alisalem.cedrotest.Fragments;

import android.content.Intent;
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
import cedrotest.alisalem.cedrotest.Activities.countriesActivity;
import cedrotest.alisalem.cedrotest.Adapter.MyCountryAdapter;
import cedrotest.alisalem.cedrotest.Model.Country;
import cedrotest.alisalem.cedrotest.R;

/**
 * Created by seifkhirouni on 21/12/2017.
 */

public class Tab2 extends Fragment {
    public Button button3;
    private TextView textViewResult;
    private ImageView ig_countries;
    private RequestQueue mQueue;
    private ArrayList<Country> list ;
    MyCountryAdapter myCounterAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2, container, false);
    /*    Button button3 = (Button) rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent j=new Intent(view.getContext(), countriesActivity.class);
                startActivity(j);
            }



        });*/
        GridView grid = (GridView)rootView.findViewById(R.id.grid_country_tab);

        mQueue= Volley.newRequestQueue(rootView.getContext());
        final String url ="https://restcountries.eu/rest/v2/all?fields=name;capital;population;flag;region";
        jsonParse(url);
//        System.out.println("list.size()) G =  "+list.size());
       /* list.add(new Country(R.drawable.tunis,"countyName","countyCapitale","countyRegion","countyPopulatio"));
        list.add(new Country(R.drawable.tunis,"countyName","countyCapitale","countyRegion","countyPopulatio"));
        list.add(new Country(R.drawable.tunis,"countyName","countyCapitale","countyRegion","countyPopulatio"));
        list.add(new Country(R.drawable.tunis,"countyName","countyCapitale","countyRegion","countyPopulatio"));
        list.add(new Country(R.drawable.tunis,"countyName","countyCapitale","countyRegion","countyPopulatio"));
        list.add(new Country(R.drawable.tunis,"countyName","countyCapitale","countyRegion","countyPopulatio"));
        list.add(new Country(R.drawable.tunis,"countyName","countyCapitale","countyRegion","countyPopulatio"));
        list.add(new Country(R.drawable.tunis,"countyName","countyCapitale","countyRegion","countyPopulatio"));*/
        MyCountryAdapter myCounterAdapter =  new MyCountryAdapter(rootView.getContext(),list);
        grid.setAdapter(myCounterAdapter);


        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.fragment_tab2);

        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        jsonParse(url);
                        ((CedroCounties) getActivity()).refreshNow();
                        System.out.println("Tab 2 ( Refrech) = "+list.size());
//                        Toast.makeText(getContext(), "Refresh Layout working", Toast.LENGTH_LONG).show();
                    }
                }
        );
        return rootView;
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
                    System.out.println("Tab 2 ( jsonSize) = "+list.size());
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
