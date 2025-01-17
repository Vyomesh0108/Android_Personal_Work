package com.example.tabbedactivity21;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BluetoothFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BluetoothFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView tv;
    Button btOn , btOff;

    public BluetoothFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BluetoothFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BluetoothFragment newInstance(String param1, String param2) {
        BluetoothFragment fragment = new BluetoothFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bluetooth, container, false);

        tv = view.findViewById(R.id.tvFirst);
        btOn = view.findViewById(R.id.bton);
        btOff = view.findViewById(R.id.btoff);

        final BluetoothAdapter btad = BluetoothAdapter.getDefaultAdapter();

        if(btad==null)
        {
            Toast.makeText(getContext(),"YOUR DEVICE DOESN'T SUPPORT BLUETOOTH",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getContext(),"YOUR DEVICE DOES SUPPORT BLUETOOTH",Toast.LENGTH_LONG).show();
        }

        btOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),1);
                tv.setText("BLUETOOTH ON");
                Toast.makeText(getContext(),"Bluetooth Turned ON",Toast.LENGTH_SHORT).show();
            }
        });

        btOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btad.disable();
                tv.setText("BLUETOOTH OFF");
                Toast.makeText(getContext(),"Bluetoth Turned OFF",Toast.LENGTH_SHORT).show();
            }
        });

        return  view;
    }
}