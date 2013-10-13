package com.arnauorriols.apps.templates.liststemplates;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.view.Gravity;
import android.widget.ListView;

import java.util.HashMap;
import java.util.ArrayList;

public class SimpleListActivity extends ListActivity
{
    private static int rowNum = 0;
    private ArrayList<HashMap<String, String>> listOfRows;

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
                this, listOfRows, R.layout.row_layout, mappingFrom, mappingTo
        );
        addButtonToListHeaderFooter(getListView()); // Before setting adapter
        setListAdapter(sa);
    }


    private void populateListOfRows() {
        listOfRows = new ArrayList<HashMap<String, String>> ();
        for (rowNum=0; rowNum<20; rowNum++){
            HashMap<String, String> row = generateRowOfList(rowNum);
            listOfRows.add(row);
        }
    }


    // row_layout.xml:'delete_button':onClick="removeRow"
    public void removeRow(View v) {
        int position = getListView().getPositionForView(v);
        listOfRows.remove(position);
        ((SimpleAdapter) getListAdapter()).notifyDataSetChanged();
    }


    private void addButtonToListHeaderFooter(ListView _lv) {
        final ListView lv = _lv;
        Button headerFooterButton = new Button(this);
        headerFooterButton.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
                )
        );
        headerFooterButton.setText("Add row");
        headerFooterButton.setGravity(Gravity.CENTER);
        headerFooterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listOfRows.add(generateRowOfList(rowNum));
                rowNum++;
                ((SimpleAdapter) getListAdapter()).notifyDataSetChanged();
                getListView().smoothScrollToPosition(lv.getCount());
            }
        });
        lv.addHeaderView(headerFooterButton);
        lv.addFooterView(headerFooterButton);
    }


    private HashMap<String, String> generateRowOfList(int _listRowNum) {
        HashMap<String, String> rowData = new HashMap<String, String>();
        int listRowNum = _listRowNum + 1;
        rowData.put("first_item", "First item - row " + (listRowNum));
        rowData.put("second_item", "Second item - row " + (listRowNum));
        rowData.put("third_item", "Third item - row " + (listRowNum));
        rowData.put("fourth_item", "Fourth item - row " + (listRowNum));

        return rowData;
    }
}


