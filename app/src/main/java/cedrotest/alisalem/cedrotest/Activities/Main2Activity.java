package cedrotest.alisalem.cedrotest.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import cedrotest.alisalem.cedrotest.R;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        ImageView ig_countries_ = (ImageView) findViewById(R.id.ig1);
        WebView wb = (WebView) findViewById(R.id.webview);

        wb.loadUrl("https://restcountries.eu/data/afg.svg");
        wb.setInitialScale(50);


//        Picasso.with(this).load("http://icons.iconarchive.com/icons/icons8/windows-8/256/Files-Jpg-icon.png").into(ig_countries_);
//        Glide.with(this).load("http://icons.iconarchive.com/icons/icons8/windows-8/256/Files-Jpg-icon.png").into(ig_countries_);
//        Glide.with(this).load("https://restcountries.eu/data/ata.svg").into(ig_countries_);

//        GlideImageView glideImageView = (GlideImageView) findViewById(R.id.glide_image_view);
//        glideImageView.loadImageUrl("http://icons.iconarchive.com/icons/icons8/windows-8/256/Files-Jpg-icon.png");
//////        glideImageView.loadImageUrl("https://restcountries.eu/data/ata.svg");


     /*   RequestBuilder  requestBuilder = GlideApp.with(this)
　　　　.as(PictureDrawable.class)
　　　　.placeholder(R.drawable.image_loading)
　　　　.error(R.drawable.image_error)
　　　　.transition(withCrossFade())
　　　　.listener(new SvgSoftwareLayerSetter());
　　Uri uri = Uri.parse("http://www.clker.com/cliparts/u/Z/2/b/a/6/android-toy-h.svg");
　　requestBuilder.load(uri).into(ig_countries_);*/



//        StringRequest stringRequest = new StringRequest("https://restcountries.eu/data/ata.svg",new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    SVG svg = SVG.getFromString(response);
////                    View view = getView();
////                    if(view != null){
//                    ImageView target = (ImageView)findViewById(R.id.ig1);
//                            Glide.with(getApplicationContext()).load(svg).into(target);
////                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        },new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                Log.d(Globals.TAG,"Fehler "+error);
//            }
//        });
//        RequestQueue queue = Volley.newRequestQueue(this);
//        stringRequest.setShouldCache(true);
//        queue.add(stringRequest);



//         requestBuilder = Glide.with(this)
//                .using(Glide.buildStreamModelLoader(Uri.class, this), InputStream.class)
//                .from(Uri.class)
//                .as(SVG.class)
//                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
//                .sourceEncoder(new StreamEncoder())
//                .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
//                .decoder(new SvgDecoder())
//                .placeholder(R.drawable.tunis)
//                .error(R.drawable.tunis)
//                .animate(android.R.anim.fade_in)
//                .listener(new SvgSoftwareLayerSetter<Uri>());
//
//        Uri uri = Uri.parse(dashBoardSummaryArrayList.get(0).getIcon());
//        requestBuilder
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .load(uri)
//                .into(ig_countries_);

    }




//    private class HttpImageRequestTask extends AsyncTask<Void, Void, Drawable> {
//        @Override
//        protected Drawable doInBackground(Void... params) {
//            try {
//
//
//                final URL url = new URL("http://upload.wikimedia.org/wikipedia/commons/e/e8/Svg_example3.svg");
//                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                InputStream inputStream = urlConnection.getInputStream();
//                SVG svg = SVGParser.getSVGFromInputStream(inputStream);
//                Drawable drawable = svg.createPictureDrawable();
//                return drawable;
//            } catch (Exception e) {
//                Log.e("MainActivity", e.getMessage(), e);
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Drawable drawable) {
//            // Update the view
//            updateImageView(drawable);
//        }
//    }
//    @SuppressLint("NewApi")
//    private void updateImageView(Drawable drawable){
//        ImageView ig_countries_ = (ImageView) findViewById(R.id.ig1);
//        if(drawable != null){
//
//            // Try using your library and adding this layer type before switching your SVG parsing
//            ig_countries_.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//            ig_countries_.setImageDrawable(drawable);
//        }
//    }
}
