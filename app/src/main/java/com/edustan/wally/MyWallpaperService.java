package com.edustan.wally;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.service.wallpaper.WallpaperService;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;

import java.io.IOException;

public class MyWallpaperService extends WallpaperService {

    final String COUNT_KEY="elementcount";
    int[] img = { R.raw.element1 ,
            R.raw.element2 ,
            R.raw.element3 ,
            R.raw.element4 ,
            R.raw.element5 ,
            R.raw.element6 ,
            R.raw.element7 ,
            R.raw.element8 ,
            R.raw.element9 ,
            R.raw.element10 ,
            R.raw.element11 ,
            R.raw.element12 ,
            R.raw.element13 ,
            R.raw.element14 ,
            R.raw.element15 ,
            R.raw.element16 ,
            R.raw.element17 ,
            R.raw.element18 ,
            R.raw.element19 ,
            R.raw.element20 ,
            R.raw.element21 ,
            R.raw.element22 ,
            R.raw.element23 ,
            R.raw.element24 ,
            R.raw.element25 ,
            R.raw.element26 ,
            R.raw.element27 ,
            R.raw.element28 ,
            R.raw.element29 ,
            R.raw.element30 ,
            R.raw.element31 ,
            R.raw.element32 ,
            R.raw.element33 ,
            R.raw.element34 ,
            R.raw.element35 ,
            R.raw.element36 ,
            R.raw.element37 ,
            R.raw.element38 ,
            R.raw.element39 ,
            R.raw.element40 ,
            R.raw.element41 ,
            R.raw.element42 ,
            R.raw.element43 ,
            R.raw.element44 ,
            R.raw.element45 ,
            R.raw.element46 ,
            R.raw.element47 ,
            R.raw.element48 ,
            R.raw.element49 ,
            R.raw.element50 ,
            R.raw.element51 ,
            R.raw.element52 ,
            R.raw.element53 ,
            R.raw.element54 ,
            R.raw.element55 ,
            R.raw.element56 ,
            R.raw.element57 ,
            R.raw.element58 ,
            R.raw.element59 ,
            R.raw.element60 ,
            R.raw.element61 ,
            R.raw.element62 ,
            R.raw.element63 ,
            R.raw.element64 ,
            R.raw.element65 ,
            R.raw.element66 ,
            R.raw.element67 ,
            R.raw.element68 ,
            R.raw.element69 ,
            R.raw.element70 ,
            R.raw.element71 ,
            R.raw.element72 ,
            R.raw.element73 ,
            R.raw.element74 ,
            R.raw.element75 ,
            R.raw.element76 ,
            R.raw.element77 ,
            R.raw.element78 ,
            R.raw.element79 ,
            R.raw.element80 ,
            R.raw.element81 ,
            R.raw.element82 ,
            R.raw.element83 ,
            R.raw.element84 ,
            R.raw.element85 ,
            R.raw.element86 ,
            R.raw.element87 ,
            R.raw.element88 ,
            R.raw.element89 ,
            R.raw.element90 ,
            R.raw.element91 ,
            R.raw.element92 ,
            R.raw.element93 ,
            R.raw.element94 ,
            R.raw.element95 ,
            R.raw.element96 ,
            R.raw.element97 ,
            R.raw.element98 ,
            R.raw.element99 ,
            R.raw.element100 ,
            R.raw.element101 ,
            R.raw.element102 ,
            R.raw.element103 ,
            R.raw.element104 ,
            R.raw.element105 ,
            R.raw.element106 ,
            R.raw.element107 ,
            R.raw.element108 ,
            R.raw.element109 ,
            R.raw.element110 ,
            R.raw.element111 ,
            R.raw.element112 ,
            R.raw.element113 ,
            R.raw.element114 ,
            R.raw.element115 ,
            R.raw.element116 ,
            R.raw.element117 ,
            R.raw.element118 ,
            R.raw.element119 ,
            R.raw.element120


    };
    Context context = this;

    @Override
    public Engine onCreateEngine() {
        return new MyWallpaperEngine();
    }
    private class MyWallpaperEngine extends Engine{
        public Bitmap image1, image2, image3;

        public  MyWallpaperEngine(){
            Log.d("TAG","Unlocked");
            image1 = BitmapFactory.decodeResource(getResources(), R.raw.element1);
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            ScreenOnReceiver screenOnReceiver = new ScreenOnReceiver();
            registerReceiver(screenOnReceiver, new IntentFilter(Intent.ACTION_SCREEN_OFF));


        }
        public void onOffsetsChanged(float xOffset, float yOffset, float xStep, float yStep, int xPixels, int yPixels)
        {
            drawFrame();
        }

        void drawFrame()
        {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            final SurfaceHolder holder = getSurfaceHolder();

            Canvas c = null;
            int n = pref.getInt(COUNT_KEY,0)+1;

            try
            {
                c = holder.lockCanvas();

                if (c != null)
                {
                    try {
                        Log.i("Wally", "Wallpaper Change open");

                        Bitmap overlay = BitmapFactory.decodeResource(context.getResources(),
                                img[n%120]);
                        Bitmap bg = BitmapFactory.decodeResource(context.getResources(),
                                R.raw.white);
                        int bitmap1Width = bg.getWidth();
                        int bitmap1Height = bg.getHeight();
                        int bitmap2Width = overlay.getWidth();
                        int bitmap2Height = overlay.getHeight();
                        float marginLeft = (float) (bitmap1Width * 0.5 - bitmap2Width * 0.5);
                        float marginTop = (float) (bitmap1Height * 0.5 - bitmap2Height * 0.5);
                        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
                        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
                        Rect screenBounds = new Rect(0,0,width,height);
                        Bitmap finalBitmap = Bitmap.createBitmap(bitmap1Width, bitmap1Height, bg.getConfig());
                        Canvas canvas = new Canvas(finalBitmap);
                        canvas.drawBitmap(bg, new Matrix(), null);
                        canvas.drawBitmap(overlay, marginLeft, marginTop, null);


                        c.drawBitmap(finalBitmap, null, screenBounds, null);

                        Log.d("WallyCount","count"+n);
                        editor.putInt(COUNT_KEY,n);
                        editor.apply();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        Log.d("Wally",e.getMessage());
                    }
                }
            } finally
            {
                if (c != null) holder.unlockCanvasAndPost(c);
            }
        }

    }
}
