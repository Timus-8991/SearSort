package com.example.pawan.sortingandsearching;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Pawan on 02-12-2017.
 */

public class TrySortCodeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view1 = inflater.inflate(R.layout.sort_code_layout,container,false);
        Button button = (Button) view1.findViewById(R.id.sortbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputtext = (EditText) view1.findViewById(R.id.inputarray);
                String inputarray = inputtext.getEditableText().toString();
                if (inputarray.equals("")) {
                    Snackbar.make(view1, "Empty String Found!!!", Snackbar.LENGTH_INDEFINITE).show();
                } else {
                    Scanner scanner = new Scanner(inputarray);
                    ArrayList<Integer> input = new ArrayList<>();
                    while (scanner.hasNext()) {
                        input.add(scanner.nextInt());
                    }
                    int a[] = new int[input.size()];
                    for (int i = 0; i < a.length; i++) {
                        a[i] = input.get(i);
                    }
                    Arrays.sort(a);
                    String result = "";
                    for (int i = 0; i < a.length; i++) {
                        result = result + a[i] + " ";
                    }
                    TextView view2 = (TextView) view1.findViewById(R.id.sortedarray);
                    view1.findViewById(R.id.sortmessage).setVisibility(View.VISIBLE);
                    view2.setText(result);
                }
            }
        });
        return view1;
    }
}
