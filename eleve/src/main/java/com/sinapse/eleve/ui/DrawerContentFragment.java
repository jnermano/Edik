package com.sinapse.eleve.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sinapse.eleve.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DrawerContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DrawerContentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DrawerContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DrawerContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DrawerContentFragment newInstance(String param1, String param2) {
        DrawerContentFragment fragment = new DrawerContentFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_drawer_content, container, false);

        final Intent intent = new Intent(getActivity(), ContentList.class);
        final Button btn = rootView.findViewById(R.id.btn);
        final String grade = getActivity().getIntent().getStringExtra("grade");
        //Log.d("grade", grade);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("grade", grade);
                startActivity(intent);
            }
        });

        return rootView;

    }
}
