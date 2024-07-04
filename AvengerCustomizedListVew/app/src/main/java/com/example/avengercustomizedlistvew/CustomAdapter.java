package com.example.avengercustomizedlistvew;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Avenger>
{
    Context context;
    int resource;
    List<Avenger> avengList;

    CustomAdapter(Context context,int resource,List<Avenger> list)
    {
        super(context, resource,list);
        this.context = context;
        this.resource = resource;
        this.avengList = list;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        //used to connect xml file with  non-activity class
        LayoutInflater inf = LayoutInflater.from(context);

        //here custom adapter class is connected with customziedlistview.xml file
        View view = inf.inflate(resource,null,false);

        ImageView iv = view.findViewById(R.id.imageView);
        TextView tv = view.findViewById(R.id.textViewName);
        TextView tvWep = view.findViewById(R.id.textViewWeap);
        Button btDel = view.findViewById(R.id.buttonDelete);

        Avenger av = avengList.get(position);

        iv.setImageDrawable(context.getResources().getDrawable(av.getImage()));
        tv.setText(av.getName());
        tvWep.setText(av.getWeapon());

        btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAvenger(position);

            }
        });

        return view;

    }

    void deleteAvenger(final int position)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);

        dialog.setTitle("Are you sure , Wanna Delete Avenger ??? ");

        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                avengList.remove(position);
                notifyDataSetChanged();

            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alert = dialog.create();
        alert.show();

    }

}
