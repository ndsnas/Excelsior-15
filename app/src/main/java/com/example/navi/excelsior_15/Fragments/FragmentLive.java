package com.example.navi.excelsior_15.Fragments;


import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.navi.excelsior_15.AdapterLive;
import com.example.navi.excelsior_15.DataLive;
import com.example.navi.excelsior_15.Information;
import com.example.navi.excelsior_15.L;
import com.example.navi.excelsior_15.Network.AppController;
import com.example.navi.excelsior_15.Network.VolleySingleton;
import com.example.navi.excelsior_15.R;
import com.example.navi.excelsior_15.tabs.KeysLive;

//import org.apache.commons.logging.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.navi.excelsior_15.tabs.KeysLive.EndpointLive.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLive#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLive extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
    private RequestQueue requestQueue;
    private RecyclerView liveList;
    private AdapterLive adapterLive;
    private String name;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String urlJsonObj = "http://api.androidhive.info/volley/person_object.json";
    private ArrayList<DataLive> list;
    private DataLive dataLive;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLive.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLive newInstance(String param1, String param2) {
        FragmentLive fragment = new FragmentLive();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentLive() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_live, container, false);
            liveList = (RecyclerView) view.findViewById(R.id.liveList);

            //dataLive=new DataLive();
            //list= new ArrayList<>();
            liveList.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapterLive = new AdapterLive(getActivity());
            liveList.setAdapter(adapterLive);
            //makeJsonObjectRequest();
            return view;
        }

  /*  private void makeJsonObjectRequest() {
        final ArrayList<DataLive> list= new ArrayList<>();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlJsonObj, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //Log.d(TAG, response.toString());

                try {
                    // Parsing json object response
                    // response will be a json object
                     name = response.getString("name");
                    String email = response.getString("email");
                    JSONObject phone = response.getJSONObject("phone");
                    String home = phone.getString("home");
                    String mobile = phone.getString("mobile");

                    /*jsonResponse = "";
                    jsonResponse += "Name: " + name + "\n\n";
                    jsonResponse += "Email: " + email + "\n\n";
                    jsonResponse += "Home: " + home + "\n\n";
                    jsonResponse += "Mobile: " + mobile + "\n\n";

                    txtResponse.setText(jsonResponse);*/

                  /* DataLive dataLive= new DataLive();
                    dataLive.setName(name);
                    list.add(dataLive);
                    Log.d("LOAD DATA", dataLive.getName());
                    Toast.makeText(getActivity(), dataLive.getName(), Toast.LENGTH_LONG).show();
                    adapterLive.setName(name);
                    adapterLive.passObject( dataLive);




                } catch (JSONException e) {
                    e.printStackTrace();
                   /* Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                //hidepDialog();
                //dataLive.setName(name);
                //list.add(dataLive);
                //dataLive.setName(home);
                //list.add(dataLive);
                //adapterLive.setListData(list);
            }
        }, null);

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }*/

    }



