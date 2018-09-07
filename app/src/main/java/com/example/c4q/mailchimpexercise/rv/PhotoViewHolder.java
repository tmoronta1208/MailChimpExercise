package com.example.c4q.mailchimpexercise.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.c4q.mailchimpexercise.R;
import com.example.c4q.mailchimpexercise.model.Photo;

public class PhotoViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private Context context;
    private String  url;

    public PhotoViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.display_image);
        context = itemView.getContext();
    }

    public void bind(Photo photo) {
        url = "https://farm" + photo.getFarm() + ".staticflickr.com/"
                + photo.getServer() + "/" + photo.getId() + "_" + photo.getSecret() + ".jpg";

        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().override(600,600).centerCrop())
                .into(image);

    }
}
