package com.example.famous;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class MoviesAdapter extends ArrayAdapter<Movie> {
    private List<Movie> movielist;
    private Context mctx;
    private ImageLoader mImageLoader;

    public MoviesAdapter(List<Movie> movieList, Context mCtx) {
        super(mCtx, R.layout.xmlfile, movieList);
        this.movielist = movieList;
        this.mctx = mctx;
    }
    public void swapImageRecords(List<Movie> objects) {
        clear();

        for(Movie object : objects) {
            add(object);
        }

        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.xmlfile, parent, false);
        }

        NetworkImageView imageView = (NetworkImageView) convertView.findViewById(R.id.imageview);
        TextView textView = (TextView) convertView.findViewById(R.id.name);

        Movie imageRecord = getItem(position);

        imageView.setImageUrl(imageRecord.getUrl(), mImageLoader);
        textView.setText(imageRecord.getTitle());

        return convertView;

//        //getting the layout inflater
//        LayoutInflater inflater = LayoutInflater.from(mctx);
//        //creating a view with our xml layout
//        View listViewItem = inflater.inflate(R.layout.xmlfile, null, true);
//        //getting text views
//        TextView textView = listViewItem.findViewById(R.id.name);
//        NetworkImageView imageView = listViewItem.findViewById(R.id.imageview);
//        //Getting the json data for the specified position
//        Movie items =movielist.get(position);
//        //setting json values to text view
//        textView.setText(items.getName());
//        Glide.with(mctx)
//                .load(items.getImage())                     // Set image url
//                .diskCacheStrategy(DiskCacheStrategy.ALL)   // Cache for image
//                .into(imageView);
//        //returning the list item
//        return listViewItem;
    }
}
