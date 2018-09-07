package com.example.c4q.mailchimpexercise.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.c4q.mailchimpexercise.R;
import com.example.c4q.mailchimpexercise.model.Photo;

public class PhotoViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private Context context;
    private StringBuilder sb;

    public PhotoViewHolder(View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.display_image);
        context = itemView.getContext();
    }

    public void bind(Photo photo) {
        sb = new StringBuilder();
        sb.append("https://farm")
                .append(photo.getFarm())
                .append(".staticflickr.com/")
                .append(photo.getServer())
                .append("/")
                .append(photo.getId()).append("_").append(photo.getSecret()).append(".jpg");
        //sb.append("https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg");

        Glide.with(context)
                .load(sb.toString())
                .into(image);

    }
}
