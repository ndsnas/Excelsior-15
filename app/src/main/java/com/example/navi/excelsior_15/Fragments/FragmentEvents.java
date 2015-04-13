package com.example.navi.excelsior_15.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.navi.excelsior_15.AdapterLive;
import com.example.navi.excelsior_15.DataLive;
import com.example.navi.excelsior_15.Network.AppController;
import com.example.navi.excelsior_15.R;

import org.apache.commons.logging.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEvents#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEvents extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
private ArrayList<DataLive> items=new ArrayList<>();
    private AdapterLive adapterLive;
    // json object response url
    private String urlJsonObj = "http://api.androidhive.info/volley/person_object.json";

    // json array response url
    private String urlJsonArry = "http://api.androidhive.info/volley/person_array.json";

    //private static String TAG = MainActivity.class.getSimpleName();
    private Button btnMakeObjectRequest, btnMakeArrayRequest;

    // Progress dialog
    private ProgressDialog pDialog;

    private TextView txtResponse;

    // temporary string to show the parsed response
    private String jsonResponse;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEvents.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEvents newInstance(String param1, String param2) {
        FragmentEvents fragment = new FragmentEvents();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentEvents() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        btnMakeObjectRequest = (Button) view.findViewById(R.id.btnObjRequest);
        btnMakeArrayRequest = (Button) view.findViewById(R.id.btnArrayRequest);
        txtResponse = (TextView) view.findViewById(R.id.txtResponse);

        /*pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);*/

        //btnMakeObjectRequest.setOnClickListener(new View.OnClickListener() {

            //@Override
            //public void onClick(View v) {
                // making json object request
                //makeJsonObjectRequest();
            //}
        //});

        /*btnMakeArrayRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // making json array request
                makeJsonArrayRequest();
            }
        });*/
        return view;
    }


   private void makeJsonArrayRequest() {

        //showpDialog();

        JsonArrayRequest req = new JsonArrayRequest(urlJsonArry,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.d(TAG, response.toString());

                        try {
                            // Parsing json array response
                            // loop through each json object
                            jsonResponse = "";
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject person = (JSONObject) response
                                        .get(i);

                                String name = person.getString("name");
                                String email = person.getString("email");
                                JSONObject phone = person
                                        .getJSONObject("phone");
                                String home = phone.getString("home");
                                String mobile = phone.getString("mobile");

                                jsonResponse += "Name: " + name + "\n\n";
                                jsonResponse += "Email: " + email + "\n\n";
                                jsonResponse += "Home: " + home + "\n\n";
                                jsonResponse += "Mobile: " + mobile + "\n\n\n";

                            }

                            txtResponse.setText(jsonResponse);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            /*Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();*/
                        }

                        //hidepDialog();
                    }
                },null);

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }

}