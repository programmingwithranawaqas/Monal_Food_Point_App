package com.example.rdit29;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listFrag extends ListFragment {

    public interface ContactSelected{
        public void contactClick(int index);
    }

    ContactSelected parent;

    public listFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        parent = (ContactSelected) context;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> names = new ArrayList<>();
        names.add("Talha");
        names.add("Ali");
        names.add("Usman");
        names.add("Uzair");
        names.add("Abbas");
        names.add("Rizwan");
        names.add("Kamboh");
        names.add("Babar Azam");

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, names));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        parent.contactClick(position);
    }
}