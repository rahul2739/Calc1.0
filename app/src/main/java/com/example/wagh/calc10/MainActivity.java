package com.example.wagh.calc10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plus,minus,division,multiply,equals,c,delete,dot;
   EditText et1,et2;
    String a="",b="";
    Double x,y,z;
    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b0=(Button)findViewById(R.id.b0);
        plus=(Button)findViewById(R.id.plus);
        minus=(Button)findViewById(R.id.minus);
        multiply=(Button)findViewById(R.id.multiply);
        division=(Button)findViewById(R.id.division);
        equals=(Button)findViewById(R.id.equals);
        c=(Button)findViewById(R.id.c);
        dot=(Button)findViewById(R.id.dot);
        delete=(Button)findViewById(R.id.delete);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=1;
                et1.setText(a);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a+=2;
                et1.setText(a);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=3;
                et1.setText(a);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=4;
                et1.setText(a);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=5;
                et1.setText(a);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=6;
                et1.setText(a);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=7;
                et1.setText(a);

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=8;
                et1.setText(a);

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=9;
                et1.setText(a);

            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                a+=0;
                et1.setText(a);

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a="";
                et1.setText("");
                et2.setText("");
                p=0;
                z=y=x=0.0;
                b="";
                Toast.makeText(getBaseContext(),"ALL RESET",Toast.LENGTH_SHORT).show();

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    x = Double.parseDouble(et1.getText().toString());
                    et1.setText("");
                    a="";
                    p=1;
                }
                catch (NumberFormatException w)
                {}

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    x = Double.parseDouble(et1.getText().toString());
                    et1.setText("");
                    a="";
                   p=2;
                }
                catch (NumberFormatException w)
                {}

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    x = Double.parseDouble(et1.getText().toString());
                    et1.setText("");
                    a = "";
                    p = 3;
                } catch (NumberFormatException w) {
                }

            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    x = Double.parseDouble(et1.getText().toString());
                    et1.setText("");
                    a="";
                    p=4;
                }
                catch (NumberFormatException w)
                {}

            }
        });


        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    y = Double.parseDouble(et1.getText().toString());
                    a = "";

                    if (x == 0.0) {
                        Toast.makeText(getBaseContext(),"Enter the next number",Toast.LENGTH_LONG).show();
                    }
                    else {
                        switch (p) {

                            case 1:
                                z = x + y;
                                b += x;
                                b += "+";
                                b += y;
                                et1.setText(b);
                                b="";
                                b += String.valueOf(z);
                                et2.setText(b);
                                b = "";
                                break;

                            case 2:
                                z = x - y;
                                b += x;
                                b += "-";
                                b += y;
                                et1.setText(b);
                                b="";
                                b += String.valueOf(z);
                                et2.setText(b);
                                b = "";
                                break;

                            case 3:
                                z = x * y;
                                b += x;
                                b += "*";
                                b += y;
                                et1.setText(b);
                                b="";
                                b += String.valueOf(z);
                                et2.setText(b);
                                b = "";
                                break;

                            case 4:
                                z = x / y;
                                b += x;
                                b += "/";
                                b += y;
                                et1.setText(b);
                                b="";
                                b += String.valueOf(z);
                                et2.setText(b);
                                b = "";
                                break;

                            case 0:
                                Toast.makeText(getBaseContext(),"No Operation Selected",Toast.LENGTH_LONG).show();

                        }
                    }
                }
                    catch(NumberFormatException e)
                    {

                    }
                    finally{
                        z = 0.0;
                        y = 0.0;
                        x = 0.0;
                    }



            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int aa = a.length();
                    // String ss = toString(aa);
                    // aa= et1.setText(toString());
                    if (aa == 1) {
                        a = "";
                        et1.setText(a);
                    } else if (aa > 1) {
                       a= a.substring(0, aa - 1);

                        et1.setText(a);
                    }
                }
                catch (StringIndexOutOfBoundsException e)
                {
                    et1.setText("WRONG");
                }


            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a+=".";
                et1.setText(a);
            }
        });

    }
}
