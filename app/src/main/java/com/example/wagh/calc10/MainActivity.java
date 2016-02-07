package com.example.wagh.calc10;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Vibrator;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plus,minus,division,multiply,equals,c,delete,dot,help,change;
   EditText et1,et2;
    String a="",b="";
    Float x,y,z;
    TextView version;
    String color,xyx;
    Vibrator v;
    String flag;
    int p;

    final Context context =this;

    SQLiteDatabase mydb = null;
    String tablename1 = "HISTORY";
    String tablename2 ="NUMBERS";
    String color2;







    RelativeLayout rl;

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
        change=(Button)findViewById(R.id.change);
        //v=(Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
        final MediaPlayer mp= MediaPlayer.create(this,R.raw.one);
        final MediaPlayer mp2=MediaPlayer.create(this,R.raw.two);

        rl=(RelativeLayout)findViewById(R.id.rl);

        version=(TextView)findViewById(R.id.version);
       // final MediaPlayer mp3=MediaPlayer.create(this,R.raw.two);





        help=(Button)findViewById(R.id.help);


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.choice);
                dialog.setTitle("Choose the Color");
                Button red = (Button)dialog.findViewById(R.id.red);
                final Button black= (Button)dialog.findViewById(R.id.black);
                Button blue = (Button)dialog.findViewById(R.id.blue);
                TextView title =(TextView)dialog.findViewById(R.id.title1);
                red.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rl.setBackgroundColor(Color.RED);
                        color = "red";
                        Toast.makeText(MainActivity.this,"Color is changed",Toast.LENGTH_SHORT).show();
                        et1.setTextColor(Color.RED);
                        c.setTextColor(Color.BLACK);
                        delete.setTextColor(Color.BLACK);
                        database(color);
                    }
                });

                black.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rl.setBackgroundColor(Color.BLACK);
                        et1.setTextColor(Color.BLACK);
                        color = "black";
                        database(color);
                        Toast.makeText(MainActivity.this,"Color is changed",Toast.LENGTH_SHORT).show();
                    }
                });

                blue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rl.setBackgroundColor(Color.BLUE);
                        et1.setTextColor(Color.BLUE);
                        color = "blue";
                        database(color);
                        Toast.makeText(MainActivity.this,"Color is changed",Toast.LENGTH_SHORT).show();
                    }
                });

                Button exit=(Button)dialog.findViewById(R.id.exit);

                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                dialog.show();

            }
        });


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder v11=new AlertDialog.Builder(MainActivity.this);
                v11.setTitle("Enter Query");

              final  EditText inn = new EditText(MainActivity.this);
                inn.setHint("Please Mention the Issues Your Reply is valuable for the Developer.");

                v11.setView(inn);

                v11.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String xx =inn.getText().toString();

                        Intent emailIntent= new Intent(Intent.ACTION_SEND);
                        String[] s11= new String[]{"virajwagh95@gmail.com"};

                        emailIntent.putExtra(Intent.EXTRA_EMAIL,s11);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Calc Query");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, xx);
                        emailIntent.setType("text/plain");

                        startActivity(Intent.createChooser(emailIntent, "SEND"));


                        dialog.dismiss();
                    }
                }).show();
            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=1;
                et1.setText(a);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=2;
                et1.setText(a);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=3;
                et1.setText(a);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=4;
                et1.setText(a);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=5;
                et1.setText(a);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=6;
                et1.setText(a);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

                a+=7;
                et1.setText(a);

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=8;
                et1.setText(a);

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=9;
                et1.setText(a);

            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                a+=0;
                et1.setText(a);

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                plus.setBackgroundColor(Color.BLACK);
                division.setBackgroundColor(Color.BLACK);
                minus.setBackgroundColor(Color.BLACK);
                multiply.setBackgroundColor(Color.BLACK);


                a="";
                et1.setText("");
                et2.setText("");
                p=0;
               // z=y=x=0.0;
                b="";
                try
                {
                    mydb =openOrCreateDatabase("Calculator",MODE_PRIVATE,null);
                    mydb.execSQL("DELETE FROM NUMBERS;");

                }
                catch (Exception e)
                {
                    Log.e("ERROR","ERROR WHILE DELETING VALUES",null);
                }
                finally {
                    mydb.close();
                }

                Toast.makeText(getBaseContext(),"ALL RESET",Toast.LENGTH_SHORT).show();

            }
        });



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                plus.setBackgroundColor(Color.GRAY);
                division.setBackgroundColor(Color.BLACK);
                minus.setBackgroundColor(Color.BLACK);
                multiply.setBackgroundColor(Color.BLACK);
                try
                {
                    xyx = et2.getText().toString();
                    if  (xyx.equals("")){

                        x = Float.parseFloat(et1.getText().toString());
                        et1.setText("");
                        a = "";
                    }else
                    {
                        x = Float.parseFloat(et2.getText().toString());
                        et1.setText("");
                    }

                }
                catch (NumberFormatException w)
                {}
                finally {
                    p=1;
                }

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();

                plus.setBackgroundColor(Color.BLACK);
                division.setBackgroundColor(Color.BLACK);
                minus.setBackgroundColor(Color.GRAY);
                multiply.setBackgroundColor(Color.BLACK);

                try
                {
                    xyx = et2.getText().toString();
                    if  (xyx.equals("")){

                        x = Float.parseFloat(et1.getText().toString());
                        et1.setText("");
                        a = "";
                    }else
                    {
                        x = Float.parseFloat(et2.getText().toString());
                        et1.setText("");
                    }

                }
                catch (NumberFormatException w)
                {}
                    finally
                    {
                        p=2;
                    }

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();

                plus.setBackgroundColor(Color.BLACK);
                division.setBackgroundColor(Color.BLACK);
                minus.setBackgroundColor(Color.BLACK);
                multiply.setBackgroundColor(Color.GRAY);


                try
                {
                    xyx = et2.getText().toString();
                    if  (xyx.equals("")){

                        x = Float.parseFloat(et1.getText().toString());
                        et1.setText("");
                        a = "";
                    }else
                    {
                        x = Float.parseFloat(et2.getText().toString());
                        et1.setText("");
                    }

                } catch (NumberFormatException w) {
                }
                finally {
                    p=3;
                }

            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();

                plus.setBackgroundColor(Color.BLACK);
                division.setBackgroundColor(Color.GRAY);
                minus.setBackgroundColor(Color.BLACK);
                multiply.setBackgroundColor(Color.BLACK);


                try
                {
                    xyx = et2.getText().toString();
                    if  (xyx.equals("")){

                        x = Float.parseFloat(et1.getText().toString());
                        et1.setText("");
                        a = "";
                    }else
                    {
                        x = Float.parseFloat(et2.getText().toString());
                        et1.setText("");
                    }

                }
                catch (NumberFormatException w)
                {}
                finally {
                    p=4;
                }

            }
        });


        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                equals.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                mp2.start();


                try {
                    y = Float.parseFloat(et1.getText().toString());
                    a = "";
                    equals.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);


                    if (x == 0.0) {
                        Toast.makeText(getBaseContext(),"Enter the next number",Toast.LENGTH_LONG).show();
                    }
                    else {
                        switch (p) {

                            case 1:

                                b += x;
                                b += "+";
                                b += y;
                                et1.setText(b);
                                x = x + y;
                                flag = "plus";
                                z = x + y;
                                database1(x, y, z, flag);
                                b = "";
                                //   b += String.valueOf(z);
                                b += String.valueOf(x);
                                et2.setText(b);
                                b = "";

                                //continue Hello;
                                break;

                            case 2:
                                b += x;
                                b += "-";
                                b += y;
                                et1.setText(b);
                                x = x - y;
                                flag="minus";
                                z=x-y;
                                database1(x,y,z,flag);
                                b="";
                                b += String.valueOf(x);
                                et2.setText(b);
                                b = "";

                                break;

                            case 3:
                                b += x;
                                b += "X";
                                b += y;
                                et1.setText(b);
                                x = x * y;
                                flag="multiply";
                                z=x*y;
                                database1(x,y,z,flag);
                                b += x;
                                b="";
                                b += String.valueOf(x);
                                et2.setText(b);
                                b = "";

                                break;

                            case 4:

                                b += x;
                                b += "/";
                                b += y;
                                et1.setText(b);
                                x = x / y;
                                flag="divide";
                                z=x/y;
                                database1(x,y,z,flag);
                                b="";
                                b += String.valueOf(x);
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
                      //  z = 0.0;
                       // y = 0.0;
                       // x = 0.0;

                    }



            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp.start();
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

                mp.start();
                a+=".";
                et1.setText(a);
            }
        });

    }



    public void database(String color) {


        /** creating database**/
        try {
            mydb = this.openOrCreateDatabase("Calculator", MODE_PRIVATE, null);

            mydb.execSQL("CREATE TABLE IF NOT EXISTS " + tablename1 + "(Color VARCHAR2);");

            mydb.execSQL("DELETE FROM "+tablename1+";");

            mydb.execSQL("INSERT INTO "
                    + tablename1
                    + " (Color)"
                    + " VALUES ('" + color + "');");


        } catch (Exception e) {
            Log.e("ERROR", "ERROR", e);
        } finally {

            mydb.close();
            return;

        }
    }


    public void database1(Float x,Float y,Float z,String flag) {


        /** creating database**/
        try {
            mydb = this.openOrCreateDatabase("Calculator", MODE_PRIVATE, null);


            mydb.execSQL("CREATE TABLE IF NOT EXISTS " + tablename2 + "(Number1 FLOAT, Number2 FLOAT, Number3 FLOAT,State VARCHAR2);");

            mydb.execSQL("DELETE FROM "+tablename2+";");


            mydb.execSQL("INSERT INTO "
                    + tablename2
                    + " (Number1,Number2,Number3,State)"
                    + " VALUES (" +x+","+y+","+z+",'"+flag+"');");





        } catch (Exception e) {
            Log.e("ERROR", "ERROR", e);
        } finally {

            mydb.close();
            return;

        }
    }






   public void onResume()
    {
        super.onResume();

       // Toast.makeText(getBaseContext(),"Starting",Toast.LENGTH_LONG).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("LOG CALC 1.0").setMessage("1.Haptic Feedback Added\n" +
                "2.Sounds Added\n"+"3.Help Button Added\n"+"4.Database Connectivity-Last History saved\n"+"5.Color Change Button Added").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
               //Toast.makeText(MainActivity.this,"Revision R4",Toast.LENGTH_SHORT).show();

            }
        }).show();

        /**DATA EXTRACTION**/

        try
        {
            mydb=this.openOrCreateDatabase("Calculator",MODE_PRIVATE,null);

            Cursor c = mydb.rawQuery("SELECT Color FROM "+tablename1,null);

            int color1=c.getColumnIndex("Color");

            c.moveToFirst();
            if(c!=null) {

                color2 = c.getString(color1);

            }
            else {
                Toast.makeText(MainActivity.this,"END",Toast.LENGTH_SHORT).show();
            }
            if(color2.equals("red")) {
                rl.setBackgroundColor(Color.RED);
                et1.setTextColor(Color.RED);
                //c.setTextColor(Color.BLACK);
                delete.setTextColor(Color.BLACK);

            }
            else if (color2.equals("blue"))
            {
                rl.setBackgroundColor(Color.BLUE);
                et1.setTextColor(Color.BLUE);
            }
            else if (color2.equals("black"))
            {
                rl.setBackgroundColor(Color.BLACK);
            }
            else {
                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
            }


        }
        catch (Exception e)
        {
            Log.e("Error","ERROR COLOR CHANGE",e);
        }
        finally {
            mydb.close();
        }


        /**************************************** EXTRACTING THE CALC DATA *************************************************/

        try
        {
            mydb=this.openOrCreateDatabase("Calculator",MODE_PRIVATE,null);

            Cursor cc=mydb.rawQuery("SELECT Number1,Number2,Number3,State FROM " + tablename2,null);

            int pp =cc.getColumnIndex("Number1");
            int pp1=cc.getColumnIndex("Number2");
            int pp2=cc.getColumnIndex("Number3");
            int pp3=cc.getColumnIndex("State");
            cc.moveToFirst();

            if(cc!=null)
            {
                x=cc.getFloat(pp);
                y=cc.getFloat(pp1);
                z=cc.getFloat(pp2);
                flag=cc.getString(pp3);
            }

            if (flag.equals("plus"))
            {
                b += x;
                b += "+";
                b += y;
                et1.setText(b);
                b="";
                b += String.valueOf(z);
                et2.setText(b);
                b = "";

            }
            else if(flag.equals("minus"))
            {
                b += x;
                b += "-";
                b += y;
                et1.setText(b);
                b="";
                b += String.valueOf(z);
                et2.setText(b);
                b = "";

            }
            else if(flag.equals("divide"))
            {
                b += x;
                b += "/";
                b += y;
                et1.setText(b);
                b="";
                b += String.valueOf(z);
                et2.setText(b);
                b = "";

            }
            else if(flag.equals("multiply"))
            {

                b += x;
                b += "X";
                b += y;
                et1.setText(b);
                b="";
                b += String.valueOf(z);
                et2.setText(b);
                b = "";
            }


        }
        catch (Exception e)
        {
            Log.e("Error","ERROR NUMBER RETRIVAL",e);
        }
        finally {
            mydb.close();
        }




    }
}
