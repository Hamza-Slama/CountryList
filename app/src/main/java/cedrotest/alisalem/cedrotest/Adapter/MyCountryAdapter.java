package cedrotest.alisalem.cedrotest.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View v =  inflater.inflate(R.layout.country_ticket,null);
//        ImageView ig_countries_ = v.findViewById(R.id.ig_countries_);
        TextView tv_countries_ = v.findViewById(R.id.tv_countries);
        TextView tv_capitale = v.findViewById(R.id.tv_capitale);
        WebView wb = (WebView) v.findViewById(R.id.ig_countries_web);

        final Country  temp = listOfCountry.get(position);
//        ig_countries_.setImageResource(temp.getFlag());

//        wb.setInitialScale(50);
        wb.setInitialScale(22);
      /*  wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wb.setScrollbarFadingEnabled(false);*/
        wb.loadUrl(temp.getFlag());
//        onScaleChanged(WebView, float, float).
        tv_countries_.setText(temp.getName());
        tv_capitale.setText(temp.getCapital());
//        ImageView imageView = (ImageView) v.findViewById(R.id.my_image_view);

//        Glide.with(context).load("https://lh6.ggpht.com/9SZhHdv4URtBzRmXpnWxZcYhkgTQurFuuQ8OR7WZ3R7fyTmha77dYkVvcuqMu3DLvMQ=w300").into(ig_countries_);

//        Glide.with(context).load("https://restcountries.eu/data/dza.svg").into(ig_countries_);
//        GlideImageView glideImageView = (GlideImageView) v.findViewById(R.id.glide_image_view);
//        glideImageView.loadImageUrl("https://restcountries.eu/data/dza.svg");
        tv_countries_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_alert_dialog);
                dialog.setTitle(temp.getName());
                WebView wb = (WebView) dialog.findViewById(R.id.ig_countries_web_dialog);
                wb.setInitialScale(15);
                wb.loadUrl(temp.getFlag());
                // set the custom dialog components - text, image and button
                TextView capital = (TextView) dialog.findViewById(R.id.dialog_text_capital);
                capital.setText("Capital : "+temp.getCapital());
                TextView region = (TextView) dialog.findViewById(R.id.dialog_text_region);
                region.setText("Region : "+temp.getRegion());
                TextView population = (TextView) dialog.findViewById(R.id.dialog_text_population);
                population.setText("Population : "+temp.getPopulation());

//                TextView capital = (TextView) dialog.findViewById(R.id.dialog_text_capital);
//                capital.setText("Android custom dialog example!");
//                ImageView country_flag = (ImageView) dialog.findViewById(R.id.dialog_image_country);ig_countries_web_dialog
////                image.setImageResource(R.drawable.tunis);
//                Glide.with(context).load(temp.getFlag()).into(country_flag);

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
}