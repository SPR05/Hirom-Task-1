package com.example.hiromtask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.apache.http.HttpStatus;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ImageOutputTask extends AsyncTask<String, Void, Bitmap> {

        private final WeakReference<ImageView> imageViewReference;

        public ImageOutputTask(ImageView imageView){
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

    /* @Override
    protected Bitmap doInBackground(String... params){
         return downloadthumbnailImg(params[0]);
     }*/

         @Override
        protected Bitmap doInBackground(String... params){
            return downloadmainImg(params[0]);
        }
        @Override
        protected void onPostExecute(Bitmap bitmap){
            if(isCancelled()){
                bitmap=null;
            }
            if(imageViewReference!=null){
                ImageView imageView = imageViewReference.get();
                if(imageView!=null){
                    if(bitmap!=null){
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
        }

      /*  private Bitmap downloadthumbnailImg(String thumbnailImg){
            HttpsURLConnection urlConnection = null;

            try{
                URL uri = new URL(thumbnailImg);
                urlConnection = (HttpsURLConnection) uri.openConnection();

                int statusCode = urlConnection.getResponseCode();
                if(statusCode!= HttpStatus.SC_OK){
                    return null;
                }
                InputStream inputStream = urlConnection.getInputStream();
                if (inputStream!=null){
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                }
            }
            catch (Exception e){
                urlConnection.disconnect();
                Log.w("ImageDownloader","Error downloading image from"+ thumbnailImg);
            }
            finally {
                if (urlConnection!=null){
                    urlConnection.disconnect();
                }
            }
            return null;
        }*/
    private Bitmap downloadmainImg(String mainImg){
        HttpsURLConnection urlConnection = null;

        try{
            URL uri = new URL(mainImg);
            urlConnection = (HttpsURLConnection) uri.openConnection();

            int statusCode = urlConnection.getResponseCode();
            if(statusCode!= HttpStatus.SC_OK){
                return null;
            }
            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream!=null){
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        }
        catch (Exception e){
            urlConnection.disconnect();
            Log.w("ImageDownloader","Error downloading image from"+ mainImg);
        }
        finally {
            if (urlConnection!=null){
                urlConnection.disconnect();
            }
        }
        return null;
    }
    }

