package com.emon.retrofitmvvmlivedatademo2.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emon.retrofitmvvmlivedatademo2.R;
import com.emon.retrofitmvvmlivedatademo2.model.Model;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyRecyclerViewHolder> {
    private Context context;
    private List<Model>models;


    public MyAdapter(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
    }

    public static class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView id,albumid,title;
        ImageView imageView,imageView2;
        public MyRecyclerViewHolder(View itemView) {

            super(itemView);
            id=(TextView) itemView.findViewById(R.id.idTV);
            albumid=(TextView) itemView.findViewById(R.id.albumIdTV);
            title=(TextView) itemView.findViewById(R.id.titleTV);
            imageView=(ImageView) itemView.findViewById(R.id.urlIV);
            imageView2=(ImageView) itemView.findViewById(R.id.thumburlIV);

        }
    }


    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view,parent,false);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {

       // Post post=postList.get(position);
        int id=models.get(position).getId();
        int albumid=models.get(position).getAlbumId();
        String ids="Id: "+String.valueOf(id);
        String albumids="Album id: "+String.valueOf(albumid);
        String titles="Title: "+models.get(position).getTitle();
        String url=models.get(position).getUrl();
        String thumburl=models.get(position).getThumbnailUrl();

        holder.id.setText(ids);
        holder.albumid.setText(albumids);
        holder.title.setText(titles);
        Picasso.get().load(url).into(holder.imageView);
        Picasso.get().load(thumburl).into(holder.imageView2);
    }

    @Override
    public int getItemCount() {
        if (models==null)return 0;
        else return models.size();
    }
}
