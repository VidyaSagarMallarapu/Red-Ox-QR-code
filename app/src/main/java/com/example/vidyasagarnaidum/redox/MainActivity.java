package com.example.vidyasagarnaidum.redox;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText e1;
    public Spinner sp1,sp2,sp3,sp4;
    CheckBox ch[]=new CheckBox[5];
    int c[]=new int[5];
    Toast t1;
    int ageIndex=-1,genderIndex=-1,trainingIndex=-1,excerciseIndex=-1;
    int A[]=new int[4];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c[0]=c[1]=c[2]=c[3]=c[4]=0;
        sp1= findViewById(R.id.age);
        e1=findViewById(R.id.e1);
        sp2=findViewById(R.id.gender);
        sp3=findViewById(R.id.training);
        sp4=findViewById(R.id.excercise);
        ch[0]=(CheckBox)findViewById(R.id.c1);
        ch[1]=(CheckBox)findViewById(R.id.c2);
        ch[2]=(CheckBox)findViewById(R.id.c3);
        ch[3]=(CheckBox)findViewById(R.id.c4);
        ch[4]=(CheckBox)findViewById(R.id.c5);
        ch[0].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                   c[0]=1;
                }

            }
        });
        ch[1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    c[1]=1;
                    // perform logic
                }

            }
        });
        ch[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    c[2]=1;
                    // perform logic
                }

            }
        });
        ch[3].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    c[3]=1;
                    // perform logic
                }

            }
        });
        ch[4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    c[4]=1;
                    // perform logic
                }

            }
        });
        ArrayAdapter<CharSequence> a1=ArrayAdapter.createFromResource(this,R.array.age,android.R.layout.simple_spinner_item);
        sp1.setAdapter(a1);

        ArrayAdapter<CharSequence> a2=ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        sp2.setAdapter(a2);
        ArrayAdapter<CharSequence> a3=ArrayAdapter.createFromResource(this,R.array.training,android.R.layout.simple_spinner_item);
        sp3.setAdapter(a3);
        ArrayAdapter<CharSequence> a4=ArrayAdapter.createFromResource(this,R.array.excercise,android.R.layout.simple_spinner_item);
        sp4.setAdapter(a4);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code
                ageIndex = position;

            }

            public void onNothingSelected(AdapterView<?> parentView) {


            }
        });

            sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    // your code
                    genderIndex = position;

                }

                public void onNothingSelected(AdapterView<?> parentView) {
                }
            });

                sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                        trainingIndex = position;
                        // your code
                    }

                    public void onNothingSelected(AdapterView<?> parentView) {
                    }
                });
                    sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                            excerciseIndex = position;
                            // your code
                        }

                        public void onNothingSelected(AdapterView<?> parentView) {
                        }
                    });

    }
    void makeAallZeros()
    {
        A[0]=A[1]=A[2]=A[3]=0;;
    }
    public void generateQr(View view) {

            if(e1.getText().toString().equalsIgnoreCase(""))t1.makeText(getApplicationContext(), "Please enter name . ", Toast.LENGTH_LONG).show();
            else if(ageIndex==0 )t1.makeText(getApplicationContext(), "Please select the age . ", Toast.LENGTH_LONG).show();

            else if(genderIndex==0)t1.makeText(getApplicationContext(), "Please select the gender . ", Toast.LENGTH_LONG).show();
            else if(trainingIndex==0)t1.makeText(getApplicationContext(), "Please select the training type . ", Toast.LENGTH_LONG).show();
            else if(excerciseIndex==0)t1.makeText(getApplicationContext(), "Please select one exercise type . ", Toast.LENGTH_LONG).show();

              else   {
                    int i, temp = 0;
                    for (i = 0; i < 5; ++i) {
                        if (c[i] == 1) {
                            temp = 1;
                            break;
                        }
                    }
                    i=0;
                    if (temp == 1)
                    {

                        if(ageIndex<3 || genderIndex ==2)i=1;
                        else i=2;
                        makeAallZeros();
                        A[trainingIndex-1]=i;
                        String code="";
                        code+=e1.getText().toString()+" ";
                        code+=String.format("A:%d B:%d C:%d D:%d ",A[0],A[1],A[2],A[3]);
                        makeAallZeros();
                        A[excerciseIndex-1]=1;
                        code+=String.format("P:%d Q:%d R:%d S:%d ",A[0],A[1],A[2],A[3]);
                        code+=String.format("V:%d W:%d X:%d Y:%d Z:%d",c[0],c[1],c[2],c[3],c[4]);
                        t1.makeText(getApplicationContext(), "output is:"+code, Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(this,GenerateQR.class);
                        intent.putExtra("QWERTYUIOP",code);
                        startActivity(intent);

                    }
                    else


                    {
                        t1.makeText(getApplicationContext(), "Please select atleast one sport . ", Toast.LENGTH_LONG).show();
                    }
                }


            }



    public void setOnCheckedChanged(View view) {


        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.c1:
                c[0]=1;
                break;

            case R.id.c2:
                c[1]=1;
                break;

            case R.id.c3:
                c[2]=1;
                break;

            case R.id.c4:
                c[3]=1;

                break;
            case R.id.c5:
                c[4]=1;
                break;


        }

    }
}
