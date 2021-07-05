package com.example.grafic1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraficView extends View {

    List<Apartament> list;
    List<Apartament> listaEtaj1=new ArrayList<>();
    List<Apartament> listaEtaj2=new ArrayList<>();
    List<Apartament> listaEtaj3=new ArrayList<>();

    Paint paint;
    Random random;
    int c1, c2, c3;

    public GraficView(Context context, List<Apartament> data) {
        super(context);
        this.list=data;

        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(8);
        random=new Random();

        // Set a random color
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        c1 = Color.argb(100, r, g, b);

        int r2 = random.nextInt(255);
        int g2 = random.nextInt(255);
        int b2 = random.nextInt(255);

        c2 = Color.argb(100, r2, g2, b2);

        int r3 = random.nextInt(255);
        int g3 = random.nextInt(255);
        int b3 = random.nextInt(255);

        c3 = Color.argb(100, r3, g3, b3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(list == null || list.size() == 0)
            return;

        //float padding = 0.1f * Math.min(getHeight(), getWidth());
        float padding=5;

        float width = getWidth() - 2 * padding;
        float height = getHeight() - 2 * padding;

        float pointSpace = width/(list.size()+1);

        // Elem max
        //in fct de un int
        float maxEl = 2000;

        for(int i = 0;i<list.size();i++){
            if(list.get(i).getEtaj().equals(Etaj.ETAJ_1)) listaEtaj1.add(list.get(i));
            else if(list.get(i).getEtaj().equals(Etaj.ETAJ_2)) listaEtaj2.add(list.get(i));
            else if(list.get(i).getEtaj().equals(Etaj.ETAJ_3)) listaEtaj3.add(list.get(i));
        }

        paint.setTextSize(65);
        paint.setStrokeWidth(7);

        // Punctele
        //PENTRUL LISTA1
        for(int i = 0;i<listaEtaj1.size();i++){
            // Draw line
            paint.setColor(c1);
            if(i >= 1){
                float x1 = padding + i*pointSpace;;
                float y1 = padding + height - (listaEtaj1.get(i - 1).getChirie()/(float)maxEl)*height;
                float x2 = padding + (i+1)*pointSpace;
                float y2 = padding + height - (listaEtaj1.get(i).getChirie()/(float)maxEl)*height;

                canvas.drawLine(x1, y1, x2, y2, paint);
            }
            // Draw point
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(20);

            float x = padding + (i+1)*pointSpace;
            float y = padding + height - (listaEtaj1.get(i).getChirie()/(float)maxEl)*height;
            canvas.drawPoint(x, y, paint);

            // Draw text
            canvas.drawText(String.valueOf(listaEtaj1.get(i).getChirie()), x - 30, y - 30, paint);
        }
        padding+=10;

        //PENTRUL LISTA2
        for(int i = 0;i<listaEtaj2.size();i++){
            // Draw line
            paint.setColor(c2);
            if(i >= 1){
                float x1 = padding + (i)*pointSpace;;
                float y1 = padding + height - (listaEtaj2.get(i - 1).getChirie()/(float)maxEl)*height;
                float x2 = padding + (i+1)*pointSpace;
                float y2 = padding + height - (listaEtaj2.get(i).getChirie()/(float)maxEl)*height;

                canvas.drawLine(x1, y1, x2, y2, paint);
            }

            // Draw point
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(20);

            float x = padding + (i+1)*pointSpace;
            float y = padding + height - (listaEtaj2.get(i).getChirie()/(float)maxEl)*height;
            canvas.drawPoint(x, y, paint);

            // Draw text
            canvas.drawText(String.valueOf(listaEtaj2.get(i).getChirie()), x - 30, y - 30, paint);
        }
        padding+=10;

        //PENTRUL LISTA3
        for(int i = 0;i<listaEtaj3.size();i++){
            // Draw line
            paint.setColor(c2);
            if(i >= 1){
                float x1 = padding + (i)*pointSpace;;
                float y1 = padding + height - (listaEtaj3.get(i - 1).getChirie()/(float)maxEl)*height;
                float x2 = padding + (i+1)*pointSpace;
                float y2 = padding + height - (listaEtaj3.get(i).getChirie()/(float)maxEl)*height;

                canvas.drawLine(x1, y1, x2, y2, paint);
            }

            // Draw point
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(20);

            float x = padding + (i+1)*pointSpace;
            float y = padding + height - (listaEtaj3.get(i).getChirie()/(float)maxEl)*height;
            canvas.drawPoint(x, y, paint);

            // Draw text
            canvas.drawText(String.valueOf(listaEtaj3.get(i).getChirie()), x - 30, y - 30, paint);
        }

        // Draw legenda
        paint.setTextSize(30);
        paint.setColor(c1);
        float x1 = width -200;
        float y1 = height -200;
        canvas.drawRect(x1,y1, x1+90, y1-90, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("Etaj 1", x1 + 91, y1-20, paint);

        paint.setColor(c2);
        x1 = width -200;
        y1 = height -300;
        canvas.drawRect(x1,y1, x1+90, y1-90, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("Etaj 2", x1 + 91, y1-20, paint);

        paint.setColor(c3);
        x1 = width -200;
        y1 = height -400;
        canvas.drawRect(x1,y1, x1+90, y1-90, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText("Etaj 3", x1 + 91, y1-20, paint);
    }
}
