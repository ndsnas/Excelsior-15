package com.example.navi.excelsior_15;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.navi.excelsior_15.Network.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Navi on 4/12/2015.
 */
public class AdapterGallery extends RecyclerView.Adapter<AdapterGallery.ViewHolderGallery> {

    private LayoutInflater layoutInflater;
    private AppController volleySingleton;
    private ImageLoader imageLoader;
    private Context mContext;
    private String urlJson="http://cr7navi.webuda.com/MyLinks";
    private String url1, url2,url3,url4,url5,url6,url7,url8,url9,url10,url11,url12,url13,url14,url15;
    public AdapterGallery(Context context){
        layoutInflater=LayoutInflater.from(context);
        volleySingleton=AppController.getInstance();
        imageLoader=volleySingleton.getImageLoader();
        mContext=context;
    }
    @Override
    public ViewHolderGallery onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.picslayout, parent, false);
        ViewHolderGallery viewHolderGallery= new ViewHolderGallery(view);
        return viewHolderGallery;
    }

    @Override
    public void onBindViewHolder(final ViewHolderGallery holder, final int position) {
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, urlJson , (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    url1=response.getString("URL1");

                    url2=response.getString("URL2");
                    switch (position){
                        case 0:
                            if(url1!=null){
                                imageLoader.get(url1, new ImageLoader.ImageListener() {
                                    @Override
                                    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                                        holder.imageView.setImageBitmap(response.getBitmap());
                                    }

                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                });
                            }
                            break;
                        case 1:
                            if(url1!=null){
                                imageLoader.get(url2, new ImageLoader.ImageListener() {
                                    @Override
                                    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                                        holder.imageView.setImageBitmap(response.getBitmap());
                                    }

                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                });
                            }
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
 }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class ViewHolderGallery extends RecyclerView.ViewHolder{
         private ImageView imageView;

         public ViewHolderGallery(View itemView) {
             super(itemView);
             imageView=(ImageView) itemView.findViewById(R.id.picView);
         }
     }
}
