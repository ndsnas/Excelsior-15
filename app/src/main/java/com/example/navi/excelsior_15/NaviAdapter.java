package com.example.navi.excelsior_15;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Collections;

/**
 * Created by Navi on 3/2/2015.
 */
public class NaviAdapter extends RecyclerView.Adapter <NaviAdapter.MyViewHolder> {

    List<Information> data= Collections.emptyList();
    private  LayoutInflater inflater;
    private Context context;
    /*private ClickListener clickListener;*/
    public NaviAdapter (Context context, List<Information> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }
    /*public void setClickListener(ClickListener clickListener){
    this.clickListener=clickListener;
    }*/
    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            /*itemView.setOnClickListener(this);*/
            title= (TextView) itemView.findViewById(R.id.listText);
            icon= (ImageView) itemView.findViewById(R.id.listIcon);
        }

        /*@Override
        public void onClick(View v) {
            Uri uri = Uri.parse("http://www.facebook.com");
            context.startActivity(new Intent(Intent.ACTION_VIEW, uri));
            if(clickListener!=null){
                clickListener.itemClicked(v, getPosition());
            }
        }

    }
    public interface ClickListener{
        public void itemClicked(View view, int position);*/

    }
}
