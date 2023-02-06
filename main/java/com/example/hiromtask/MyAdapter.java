package com.example.hiromtask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Task> {

    private List<Task> taskList;
   // private Bitmap thumbnail, pic;
    private Context ctx;



    public MyAdapter(List<Task>taskList, Context ctx){
        super(ctx, R.layout.list_view, taskList);

     /*   this.taskList = taskList;
        this.ctx = ctx;*/

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Task task = taskList.get(position);

        ViewHolder holder;

        if (convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_view, parent, false);
            // convertView = inflater.inflate(R.layout.activity_second, null, true);
            holder = new ViewHolder();

            holder.albumId = convertView.findViewById(R.id.albumId);
            holder.id = convertView.findViewById(R.id.textId);
            holder.title = convertView.findViewById(R.id.textTitle);
            // holder.imageviewPic = convertView.findViewById(R.id.mainImage);
            // holder.imageviewThumbnailimg = convertView.findViewById(R.id.thumbnailImg);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.albumId.setText(task.albumId);
        holder.id.setText(task.id);
        holder.title.setText(task.title);

      /*
      //  String mainImg = task.getImage();
        String taskAlbumid = task.getAlbumId();
        String taskId = task.getId();
        String taskTitle = task.getTitle();
      //  String thumbnailImg = task.getThumbnailImg();

        holder.textviewAlbumid.setText(taskAlbumid);
        holder.textviewId.setText(taskId);
        holder.textviewTitle.setText(taskTitle);
       // holder.textviewImage.setText(mainImg);
      //  holder.textviewThumbnailimg.setText(thumbnailImg);

        if (holder.imageviewThumbnailimg!=null){
            new ImageDownloaderTask(holder.imageviewThumbnailimg).execute(thumbnailImg);
        }
        if (holder.imageviewPic!=null){
            new ImageOutputTask(holder.imageviewPic).execute(mainImg);
        }
        holder.imageviewThumbnailimg.setImageBitmap(thumbnail);
        holder.imageviewPic.setImageBitmap(pic);*/

        return convertView;
    }

    static class ViewHolder{
        TextView albumId;
        TextView id;
        TextView title;
      /*  ImageView imageviewThumbnailimg;
        ImageView imageviewPic;*/
    }

}
