package com.example.prekshasingla.emicalc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class EMIActivityFragment extends Fragment {


    public EMIActivityFragment() {
    }

    String userid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_emi, container, false);
        final EditText amount=(EditText)rootView.findViewById(R.id.input_amount);
        final EditText tenure=(EditText)rootView.findViewById(R.id.input_tenure);
        final ListView list=(ListView) rootView.findViewById(R.id.list);
        Button submit=(Button) rootView.findViewById(R.id.btn_submit);


        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("Phone")) {
            userid = intent.getStringExtra("Phone");
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<EMI> emiList=new ArrayList<EMI>();
                Integer p=Integer.parseInt(amount.getText().toString());
                Integer t=Integer.parseInt(tenure.getText().toString());
                Integer t1=t-3;
                Integer r=36/12;
                if(t1<=0) {
                    t1 = 1;
                }
                for (int i = t1; i <=t + 3; i++) {

                    Float e = (float) (p * r * (1 + r) ^ i) / ((1 + r) ^ i - 1);
                    float amount=e*i;
                    EMI emi = new EMI(amount, i, e);
                    Toast.makeText(getContext(), ""+e, Toast.LENGTH_SHORT).show();
                    emiList.add(emi);
                }

                ListAdapter adapter=new ListAdapter(getContext(),emiList);
                list.setAdapter(adapter);
            }
        });


        return rootView;
    }

}
