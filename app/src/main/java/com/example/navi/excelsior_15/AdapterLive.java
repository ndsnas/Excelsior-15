package com.example.navi.excelsior_15;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.navi.excelsior_15.DataLive;
import com.example.navi.excelsior_15.Fragments.FragmentLive;
import com.example.navi.excelsior_15.Network.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



/**
 * Created by Navi on 3/4/2015.
 * Minor changes by Hemant on 6-april-2015.
 */
public class AdapterLive extends RecyclerView.Adapter<AdapterLive.ViewHolderLive > {
    private Context mContext;
    String file="hello";
    FileOutputStream fos;
    FileInputStream fis;
    private ArrayList<DataLive> listData= new ArrayList<>();
    private LayoutInflater layoutInflater;

    private String urlJsonArry = "http://cr7navi.webuda.com/nds";
    private String jsonResponse;
    private String data1, data2, data3, data4, data5;
    private AppController volleySingleton;
    private ImageLoader imageLoader;

    public AdapterLive(Context context){
        //dataLive=new DataLive();
        layoutInflater=LayoutInflater.from(context);
        volleySingleton=AppController.getInstance();
        imageLoader=volleySingleton.getImageLoader();
        mContext=context;
    }
    public void setListData(ArrayList<DataLive> listData){
        this.listData=listData;
        //notifyItemRangeChanged(0, listData.size());
    }
    @Override
    public ViewHolderLive onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.card_layout, parent, false);
        ViewHolderLive viewHolder=new ViewHolderLive(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderLive holder, final int position) {

//DataLive dataLive1=listData.get(position);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, urlJsonArry, (String) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            data1=response.getString("data1");
                            data2=response.getString("data2");
                            data3=response.getString("data3");
                            data4=response.getString("data4");
                            data5=response.getString("data5");
                            switch (position){
                                case 0:
                                    holder.tText.setText(data1);
                                    break;
                                case 1:
                                    holder.tText.setText(data2);
                                    break;
                                case 2:
                                    holder.tText.setText(data3);
                                    break;
                                case 3:
                                    holder.tText.setText(data4);
                                    break;
                                case 4:
                                    holder.tText.setText(data5);
                                    break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }












                },new Response.ErrorListener(){


            @Override
            public void onErrorResponse(VolleyError error) {
                if(error instanceof NetworkError){
                    Toast toast=Toast.makeText(mContext,"Network Error!", Toast.LENGTH_SHORT  );
                    toast.show();
                }
            }
        });

        AppController.getInstance().addToRequestQueue(req);


    }



    @Override
    public int getItemCount() {
        return 5;
    }

    static class ViewHolderLive extends RecyclerView.ViewHolder{
        private TextView tText;
        private ImageView imageView;
        public ViewHolderLive(View itemView) {
            super(itemView);
            tText=(TextView) itemView.findViewById(R.id.info_text);

        }
    }


}
