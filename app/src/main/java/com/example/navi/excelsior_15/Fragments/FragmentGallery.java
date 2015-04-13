package com.example.navi.excelsior_15.Fragments;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.navi.excelsior_15.AdapterGallery;
import com.example.navi.excelsior_15.AdapterLive;
import com.example.navi.excelsior_15.Network.AppController;
import com.example.navi.excelsior_15.Network.VolleySingleton;
import com.example.navi.excelsior_15.R;

import org.json.JSONArray;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGallery#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGallery extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AppController volleySingleton;
    private ImageLoader imageLoader;
    private RequestQueue requestQueue;
    private String urlJsonArry = "http://cr7navi.webuda.com/nds";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView pics;
    private AdapterGallery adapterGallery;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentGallery.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentGallery newInstance(String param1, String param2) {
        FragmentGallery fragment = new FragmentGallery();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentGallery() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        volleySingleton=AppController.getInstance();
        requestQueue=volleySingleton.getRequestQueue();
        JsonArrayRequest request= new JsonArrayRequest(Request.Method.GET, urlJsonArry, (String) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Toast toast= Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_LONG);
                //toast.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_gallary, container, false);
        pics= (RecyclerView) view.findViewById(R.id.pics);

        adapterGallery = new AdapterGallery(getActivity());
        pics.setAdapter(adapterGallery);
        pics.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


}
