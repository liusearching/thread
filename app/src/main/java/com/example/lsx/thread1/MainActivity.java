package com.example.lsx.thread1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mLoadButton;
    private Button mtoastButton;
    private ImageView mImageview;
    private ProgressBar mProgress;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mProgress.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageview=(ImageView)findViewById(R.id.main_image);
        mLoadButton=(Button)findViewById(R.id.main_load);
        mtoastButton=(Button)findViewById(R.id.main_toast);
        mProgress=(ProgressBar)findViewById(R.id.main_bar);
       mLoadButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               new Thread(
                       new Runnable() {
                           @Override
                           public void run() {
                               Message msg=new Message();
                               mHandler.sendMessage(msg);
                           }
                       }
               ).start();
           }
       });
        /* mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadImageTask().execute();
            }
        });*/

        mtoastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "dengdenge", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* class LoadImageTask extends AsyncTask<Void, Integer, Bitmap>{*/

        /* @Override
                        protected Bitmap doInBackground(Void... params) {
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
                            return  bitmap;
                        }*/
       /* @Override
        protected void onPreExecute() {
            mProgress.setVisibility(View.VISIBLE);

        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            for (int i=1;i<11;i++){
                sleep();
                publishProgress(i * 10);
            }

            Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
            return  bitmap;
        }

        private void sleep() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*private void sleep() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

       /* @Override
        protected void onProgressUpdate(Integer... values) {
            mProgress.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImageview.setImageBitmap(bitmap);
            mProgress.setVisibility(View.INVISIBLE);
        }
    } */
   /* private void loadImage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
                try{
                    Thread.sleep(4000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            mImageview.post(new Runnable() {
                @Override
                public void run() {
                    mImageview.setImageBitmap(bitmap);
                }
            });

            }
        }).start();

    }  */


}
