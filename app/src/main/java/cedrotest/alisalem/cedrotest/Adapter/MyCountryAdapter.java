package cedrotest.alisalem.cedrotest.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.master.glideimageview.GlideImageView;

import java.util.ArrayList;

import cedrotest.alisalem.cedrotest.Model.Country;
import cedrotest.alisalem.cedrotest.R;

/**
 * Created by hamza on 27/12/17.
 */

public class MyCountryAdapter extends BaseAdapter {
    Context context;
    ArrayList<Country> listOfCountry ;
    SparseBooleanArray mCheckedIds = new SparseBooleanArray();


    public MyCountryAdapter(Context c,ArrayList<Country> listOfCountry){
        context = c;
        this.listOfCountry = listOfCountry;
    }

    @Override
    public int getCount() {
        return listOfCountry.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfCountry.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View v =  inflater.inflate(R.layout.country_ticket,null);
        TextView tv_countries_ = v.findViewById(R.id.tv_countries);
        CheckBox checkbox_visited_country = v.findViewById(R.id.checkbox_visited_country);
        TextView tv_capitale = v.findViewById(R.id.tv_capitale);
        WebView wb = (WebView) v.findViewById(R.id.ig_countries_web);

        final Country  temp = listOfCountry.get(position);
        wb.setInitialScale(22);
        wb.loadUrl(temp.getFlag());
        tv_countries_.setText(temp.getName());
        tv_capitale.setText(temp.getCapital());

        checkbox_visited_country.setChecked( mCheckedIds.get(position));
        final int pos = position;
        checkbox_visited_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                checkCheckBox(pos,!mCheckedIds.get(pos));
            }
        });


        tv_countries_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_alert_dialog);
                dialog.setTitle(temp.getName());
                WebView wb = (WebView) dialog.findViewById(R.id.ig_countries_web_dialog);
                wb.setInitialScale(15);
                wb.loadUrl(temp.getFlag());
                TextView capital = (TextView) dialog.findViewById(R.id.dialog_text_capital);
                capital.setText("Capital : "+temp.getCapital());
                TextView region = (TextView) dialog.findViewById(R.id.dialog_text_region);
                region.setText("Region : "+temp.getRegion());
                TextView population = (TextView) dialog.findViewById(R.id.dialog_text_population);
                population.setText("Population : "+temp.getPopulation());

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        return v;
    }

    public void checkCheckBox  (Integer pos,Boolean value){
        if(value){
            mCheckedIds.put(pos,true);
        }else{
            mCheckedIds.delete(pos);
        }
        notifyDataSetChanged();
    }
}