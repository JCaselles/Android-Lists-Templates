package com.arnauorriols.apps.templates.liststemplates;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.ArrayList;

public class SimpleListActivity extends ListActivity
{
    private ArrayList<HashMap<String, String>> listOfRows;
    private HashMap<String, String> rowData;

    private String[] mappingFrom = {
            "first_item", "second_item", "third_item", "fourth_item"};

    private int[] mappingTo = {R.id.first_view,
                            R.id.second_view, R.id.third_view,
                                        R.id.fourth_view};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        populateListOfRows();
        SimpleAdapter sa = new SimpleAdapter(
                this, listOfRows, R.layout.row_layout, mappingFrom, mappingTo);

        setListAdapter(sa);
    }

    private void populateListOfRows() {

        listOfRows = new ArrayList<HashMap<String, String>> ();
        for (int x=0; x<20; x++){
            rowData = new HashMap<String, String>();
            rowData.put("first_item", "First item - row " + (x+1));
            rowData.put("second_item", "Second item - row " + (x+1));
            rowData.put("third_item", "Third item - row " + (x+1));
            rowData.put("fourth_item", "Fourth item - row " + (x+1));
            listOfRows.add(rowData);
        }
    }
}


