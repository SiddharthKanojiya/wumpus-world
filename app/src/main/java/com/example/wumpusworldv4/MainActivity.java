package com.example.wumpusworldv4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity  {
    // solution start
    //Sample.main(null);
    //String a=s;
    //solution end
    //int x=3;
    int y=3;
    int p=30;
    boolean flag=true;
    //int[] path={20,30,31,21,11,30};
    //static Sample ww=new Sample();
    static int[] a=Sample.fp();
    Block[][] m=Sample.maze;
    static List<Integer> cpath=GridParhFinder.CheatPath(a);

    int size=cpath.size();
    //Set<Integer> player_set = new HashSet<Integer>();
    Set<Integer> breeze_set = new HashSet<Integer>();
    Set<Integer> stench_set = new HashSet<Integer>();
    Set<Integer> Extra_set = new HashSet<Integer>();
    int goldpos;

    public void reset(View view){


        ((ImageView) findViewById(p)).setImageResource(0);
        p=30;
        ImageView img = findViewById(R.id.imageView12);
        img.setImageResource(R.drawable.man);
    }


    private Handler handler;
    private Runnable runnable;
    int ptr;
    int preptr=30;
    //int preptr=1000050;
    int pointer=0;
    ImageView imgview;
    int move=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView imgvie=findViewBy
        /*
        HashMap<Integer, Cell> bl = new HashMap<>();

        bl.put(0,new Cell(0,false,false,false,true,false));
        bl.put(1,new Cell(1,false,false,false,false,false));
        bl.put(2,new Cell(2,false,false,false,false,true));
        bl.put(3,new Cell(3,false,true,false,false,false));

        bl.put(10,new Cell(10,true,false,false,false,false));
        bl.put(11,new Cell(11,false,false,true,true,true));
        bl.put(12,new Cell(12,false,true,false,false,false));
        bl.put(13,new Cell(13,false,false,false,false,true));

        bl.put(20,new Cell(20,false,false,false,true,false));
        bl.put(21,new Cell(21,false,false,false,false,false));
        bl.put(22,new Cell(22,false,false,false,false,true));
        bl.put(23,new Cell(23,false,false,false,false,false));

        bl.put(30,new Cell(30,false,false,false,false,false));
        bl.put(31,new Cell(31,false,false,false,false,true));
        bl.put(32,new Cell(32,false,true,false,false,false));
        bl.put(33,new Cell(33,false,false,false,false,true));

         */
        /*if (cpath.get(size-1)==GridParhFinder.endRow*10 +GridParhFinder.endRow)
        {
            Toast.makeText(MainActivity.this, cpath+""+size, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "NO"+size, Toast.LENGTH_SHORT).show();
        }*/

        HashMap<Integer,Block> bl2 = new HashMap<>();

        bl2.put(0,m[0][0]);
        bl2.put(1,m[0][1]);
        bl2.put(2,m[0][2]);
        bl2.put(3,m[0][3]);

        bl2.put(10,m[1][0]);
        bl2.put(11,m[1][1]);
        bl2.put(12,m[1][2]);
        bl2.put(13,m[1][3]);

        bl2.put(20,m[2][0]);
        bl2.put(21,m[2][1]);
        bl2.put(22,m[2][2]);
        bl2.put(23,m[2][3]);

        bl2.put(30,m[3][0]);
        bl2.put(31,m[3][1]);
        bl2.put(32,m[3][2]);
        bl2.put(33,m[3][3]);



        final HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,R.id.imageView0);
        map.put(1,R.id.imageView1);
        map.put(2,R.id.imageView2);
        map.put(3,R.id.imageView3);
        map.put(10,R.id.imageView4);
        map.put(11,R.id.imageView5);
        map.put(12,R.id.imageView6);
        map.put(13,R.id.imageView7);
        map.put(20,R.id.imageView8);
        map.put(21,R.id.imageView9);
        map.put(22,R.id.imageView10);
        map.put(23,R.id.imageView11);
        map.put(30,R.id.imageView12);
        map.put(31,R.id.imageView13);
        map.put(32,R.id.imageView14);
        map.put(33,R.id.imageView15);
        map.put(100,R.id.button_up);
        map.put(101,R.id.button_right);
        map.put(102,R.id.button_left);
        map.put(99,R.id.button_down);
        HashMap<Integer, Integer> mapg = new HashMap<>();
        mapg.put(0,R.id.mingimageView0);
        mapg.put(1,R.id.mingimageView1);
        mapg.put(2,R.id.mingimageView2);
        mapg.put(3,R.id.mingimageView3);
        mapg.put(10,R.id.mingimageView4);
        mapg.put(11,R.id.mingimageView5);
        mapg.put(12,R.id.mingimageView6);
        mapg.put(13,R.id.mingimageView7);
        mapg.put(20,R.id.mingimageView8);
        mapg.put(21,R.id.mingimageView9);
        mapg.put(22,R.id.mingimageView10);
        mapg.put(23,R.id.mingimageView11);
        mapg.put(30,R.id.mingimageView12);
        mapg.put(31,R.id.mingimageView13);
        mapg.put(32,R.id.mingimageView14);
        mapg.put(33,R.id.mingimageView15);
        HashMap<Integer, Integer> mapb = new HashMap<>();
        mapb.put(0,R.id.minbimageView0);
        mapb.put(1,R.id.minbimageView1);
        mapb.put(2,R.id.minbimageView2);
        mapb.put(3,R.id.minbimageView3);
        mapb.put(10,R.id.minbimageView4);
        mapb.put(11,R.id.minbimageView5);
        mapb.put(12,R.id.minbimageView6);
        mapb.put(13,R.id.minbimageView7);
        mapb.put(20,R.id.minbimageView8);
        mapb.put(21,R.id.minbimageView9);
        mapb.put(22,R.id.minbimageView10);
        mapb.put(23,R.id.minbimageView11);
        mapb.put(30,R.id.minbimageView12);
        mapb.put(31,R.id.minbimageView13);
        mapb.put(32,R.id.minbimageView14);
        mapb.put(33,R.id.minbimageView15);
        HashMap<Integer, Integer> maps = new HashMap<>();
        maps.put(0,R.id.minsimageView0);
        maps.put(1,R.id.minsimageView1);
        maps.put(2,R.id.minsimageView2);
        maps.put(3,R.id.minsimageView3);
        maps.put(10,R.id.minsimageView4);
        maps.put(11,R.id.minsimageView5);
        maps.put(12,R.id.minsimageView6);
        maps.put(13,R.id.minsimageView7);
        maps.put(20,R.id.minsimageView8);
        maps.put(21,R.id.minsimageView9);
        maps.put(22,R.id.minsimageView10);
        maps.put(23,R.id.minsimageView11);
        maps.put(30,R.id.minsimageView12);
        maps.put(31,R.id.minsimageView13);
        maps.put(32,R.id.minsimageView14);
        maps.put(33,R.id.minsimageView15);
        ImageButton down = findViewById(R.id.button_down);
        ImageButton left = findViewById(R.id.button_left);
        ImageButton right = findViewById(R.id.button_right);
        ImageButton up = findViewById(R.id.button_up);
        FloatingActionButton sol=findViewById(R.id.sol);
        FloatingActionButton stop=findViewById(R.id.stop);
        TextView status =findViewById(R.id.textView2);
        TextView receiver_msg=findViewById(R.id.received_value_id);
        // create the get Intent object
        Intent intent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String str = intent.getStringExtra("message_key");
        // display the string into textView
        receiver_msg.setText(str);
        //String y="imageView12";
        ImageView imageView = findViewById(R.id.imageView12);
        imageView.setImageResource(R.drawable.man);
        handler = new Handler();

        //int preptr=map.get(30);
        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (handler != null && runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                Toast.makeText(MainActivity.this, cpath+""+size, Toast.LENGTH_SHORT).show();
                /*
                p=30;
                //int temprory=(cpath.get((pointer - 1) % size)).intValue();
                ImageView iv1=findViewById((int)map.get(cpath.get((pointer - 1) % size)));
                iv1.setImageResource(0);
                pointer=0;
                ImageView img = findViewById(R.id.imageView12);
                img.setImageResource(R.drawable.man);
                move=0;
                status.setText("MOVES:"+move);
                up.setEnabled(true);
                down.setEnabled(true);
                left.setEnabled(true);
                right.setEnabled(true);*/
                ImageView imgtemp;
                for(Integer i:stench_set)
                {
                    imgtemp=(ImageView)findViewById(maps.get(i)) ;
                    imgtemp.setImageResource(0);
                }
                stench_set.clear();
                for(Integer i:breeze_set)
                {
                    imgtemp=(ImageView)findViewById(mapb.get(i)) ;
                    imgtemp.setImageResource(0);

                }
                breeze_set.clear();
                for(Integer i:Extra_set)
                {
                    imgtemp=(ImageView)findViewById(map.get(i)) ;
                    imgtemp.setImageResource(0);
                }
                Extra_set.clear();
                imgtemp=(ImageView)findViewById(mapg.get(goldpos)) ;
                imgtemp.setImageResource(0);
                imgtemp=(ImageView)findViewById(map.get(p)) ;
                imgtemp.setImageResource(0);
                /*
                imgtemp=(ImageView)findViewById(R.id.imageView4);
                imgtemp.setImageResource(0);
                imgtemp=(ImageView)findViewById(R.id.imageView6);
                imgtemp.setImageResource(0);
                imgtemp=(ImageView)findViewById(R.id.imageView3);
                imgtemp.setImageResource(0);
                imgtemp=(ImageView)findViewById(R.id.imageView14);
                imgtemp.setImageResource(0);
                //status.append(String.valueOf(move));*/
                //Re Randmomize Reset
                move=0;
                a=Sample.fp();
                m=Sample.maze;

                cpath=GridParhFinder.CheatPath(a);
                size=cpath.size();

                bl2.put(0,m[0][0]);
                bl2.put(1,m[0][1]);
                bl2.put(2,m[0][2]);
                bl2.put(3,m[0][3]);

                bl2.put(10,m[1][0]);
                bl2.put(11,m[1][1]);
                bl2.put(12,m[1][2]);
                bl2.put(13,m[1][3]);

                bl2.put(20,m[2][0]);
                bl2.put(21,m[2][1]);
                bl2.put(22,m[2][2]);
                bl2.put(23,m[2][3]);

                bl2.put(30,m[3][0]);
                bl2.put(31,m[3][1]);
                bl2.put(32,m[3][2]);
                bl2.put(33,m[3][3]);
                pointer=0;
                preptr=30;
                p=30;
                imgtemp=(ImageView)findViewById(map.get(p)) ;
                imgtemp.setImageResource(R.drawable.man);
            }
        });
        sol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (cpath.size()!=0 )
                {
                    up.setEnabled(false);
                    down.setEnabled(false);
                    left.setEnabled(false);
                    right.setEnabled(false);
                    increasePointerByOne(map,bl2,mapg,mapb,maps);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Solution Doesnt Exist"+cpath+""+size, Toast.LENGTH_SHORT).show();
                }




            }
        });
        //ImageView i=findViewById(R.id.);
        up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (p==30)
                {

                    flag=true;
                }
                // Do something in response to button click
                if (p>3)
                {
                    move++;
                    //status.setText("Status");
                    int prev=map.get(p);
                    ((ImageView) findViewById(prev)).setImageResource(0);
                    p-=10;
                    int pv=map.get(p);

                    //Cell ctemp=bl.get(p);
                    Block ctemp=bl2.get(p);
                    if (ctemp.hasGold)
                    {
                        int gold=mapg.get(p);
                        ImageView mingimageView2 = findViewById(gold);
                        mingimageView2.setImageResource(R.drawable.gold);
                        Toast.makeText(MainActivity.this, "You found Gold", Toast.LENGTH_SHORT).show();
                        goldpos=p;
                        if (move<size-1)
                        {
                            Toast.makeText(MainActivity.this, "YOU WIN", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (ctemp.hasWumpus)
                    {
                        move=0;
                        Toast.makeText(MainActivity.this, "Wampus ate you", Toast.LENGTH_SHORT).show();
                        ((ImageView) findViewById(pv)).setImageResource(R.drawable.wumpus);
                        Extra_set.add(p);
                        p=30;
                        ImageView img = findViewById(R.id.imageView12);
                        img.setImageResource(R.drawable.man);
                        flag=false;


                    }
                    if (ctemp.hasPit)
                    {
                        move=0;
                        Toast.makeText(MainActivity.this, "You fall into pit", Toast.LENGTH_SHORT).show();
                        ((ImageView) findViewById(pv)).setImageResource(R.drawable.pit);
                        Extra_set.add(p);
                        p=30;
                        ImageView img = findViewById(R.id.imageView12);
                        img.setImageResource(R.drawable.man);
                        flag=false;

                    }
                    if (ctemp.hasBreeze)
                    {
                        int breeze=mapb.get(p);
                        ImageView minimageView2 = findViewById(breeze);
                        minimageView2.setImageResource(R.drawable.stench2);
                        breeze_set.add(p);
                        //status.append("\n Breeze");
                    }
                    if (ctemp.hasStench)
                    {
                        int stench=maps.get(p);
                        ImageView minimageView2 = findViewById(stench);
                        minimageView2.setImageResource(R.drawable.stench);
                        stench_set.add(p);
                        //status.append("\n Stench");
                    }
                    if (flag)
                    {
                        ImageView imageView2 = findViewById(pv);
                        imageView2.setImageResource(R.drawable.manu);

                    }
                    status.setText("MOVES:"+move);
                    //Toast.makeText(MainActivity.this, ""+imageView2.getTag().toString(), Toast.LENGTH_SHORT).show();
                    //System.out.println(imageView);
                    //ImageView img = (ImageView) findViewById(R.layout.activity_main).findViewWithTag("myTag");

                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                if (p==30)
                {
                    flag=true;
                }
                if (p<30)
                {
                    move++;
                    //status.setText("Status");
                    int prev=map.get(p);
                    ((ImageView) findViewById(prev)).setImageResource(0);
                    p+=10;
                    int pv=map.get(p);
                    Block ctemp=bl2.get(p);
                    if (ctemp.hasGold)
                    {
                        int gold=mapg.get(p);
                        ImageView mingimageView2 = findViewById(gold);
                        mingimageView2.setImageResource(R.drawable.gold);
                        Toast.makeText(MainActivity.this, "You found Gold", Toast.LENGTH_SHORT).show();
                        goldpos=p;
                        if (move<size-1)
                        {
                            Toast.makeText(MainActivity.this, "YOU WIN", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (ctemp.hasWumpus)
                    {
                        move=0;
                        Toast.makeText(MainActivity.this, "Wampus ate you", Toast.LENGTH_SHORT).show();
                        ((ImageView) findViewById(pv)).setImageResource(R.drawable.wumpus);
                        Extra_set.add(p);
                        p=30;
                        ImageView img = findViewById(R.id.imageView12);
                        img.setImageResource(R.drawable.man);
                        flag=false;

                    }
                    if (ctemp.hasPit)
                    {
                        move=0;
                        Toast.makeText(MainActivity.this, "You fall into pit", Toast.LENGTH_SHORT).show();
                        ((ImageView) findViewById(pv)).setImageResource(R.drawable.pit);
                        Extra_set.add(p);
                        p=30;
                        ImageView img = findViewById(R.id.imageView12);
                        img.setImageResource(R.drawable.man);
                        flag=false;

                    }
                    if (ctemp.hasBreeze)
                    {
                        int breeze=mapb.get(p);
                        ImageView minimageView2 = findViewById(breeze);
                        minimageView2.setImageResource(R.drawable.stench2);
                        breeze_set.add(p);
                        //status.append("\n Breeze");
                    }
                    if (ctemp.hasStench)
                    {
                        int stench=maps.get(p);
                        ImageView minimageView2 = findViewById(stench);
                        minimageView2.setImageResource(R.drawable.stench);
                        stench_set.add(p);
                        //status.append("\n Stench");
                    }

                    //((ImageView) findViewById(R.id.imageView12)).setImageResource(0);
                    if (flag)
                    {
                        ImageView imageView2 = findViewById(pv);
                        imageView2.setImageResource(R.drawable.mand);
                    }
                    status.setText("MOVES:"+move);
                    //Toast.makeText(MainActivity.this, ""+imageView2.getTag().toString(), Toast.LENGTH_SHORT).show();
                    //System.out.println(imageView);
                    //ImageView img = (ImageView) findViewById(R.layout.activity_main).findViewWithTag("myTag");

                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                if (p==30)
                {
                    flag=true;
                }
                if (p%10>0)
                {
                    move=0;
                    //status.setText("Status");
                    int prev=map.get(p);
                    ((ImageView) findViewById(prev)).setImageResource(0);
                    p-=1;
                    int pv=map.get(p);
                    Block ctemp=bl2.get(p);
                    if (ctemp.hasGold)
                    {
                        int gold=mapg.get(p);
                        ImageView mingimageView2 = findViewById(gold);
                        mingimageView2.setImageResource(R.drawable.gold);
                        Toast.makeText(MainActivity.this, "You found Gold", Toast.LENGTH_SHORT).show();
                        goldpos=p;
                        if (move<size-1)
                        {
                            Toast.makeText(MainActivity.this, "YOU WIN", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (ctemp.hasWumpus)
                    {
                        move=0;
                        Toast.makeText(MainActivity.this, "Wampus ate you", Toast.LENGTH_SHORT).show();
                        ((ImageView) findViewById(pv)).setImageResource(R.drawable.wumpus);
                        Extra_set.add(p);
                        p=30;
                        ImageView img = findViewById(R.id.imageView12);
                        img.setImageResource(R.drawable.man);
                        flag=false;

                    }
                    if (ctemp.hasPit)
                    {
                        move=0;
                        Toast.makeText(MainActivity.this, "You fall into pit", Toast.LENGTH_SHORT).show();
                        ((ImageView) findViewById(pv)).setImageResource(R.drawable.pit);
                        Extra_set.add(p);
                        p=30;
                        ImageView img = findViewById(R.id.imageView12);
                        img.setImageResource(R.drawable.man);
                        flag=false;

                    }
                    if (ctemp.hasBreeze)
                    {
                        int breeze=mapb.get(p);
                        ImageView minimageView2 = findViewById(breeze);
                        minimageView2.setImageResource(R.drawable.stench2);
                        breeze_set.add(p);
                        //status.append("\n Breeze");
                    }
                    if (ctemp.hasStench)
                    {
                        int stench=maps.get(p);
                        ImageView minimageView2 = findViewById(stench);
                        minimageView2.setImageResource(R.drawable.stench);
                        stench_set.add(p);
                        //status.append("\n Stench");
                    }

                    //((ImageView) findViewById(R.id.imageView12)).setImageResource(0);
                    if (flag)
                    {
                        ImageView imageView2 = findViewById(pv);
                        imageView2.setImageResource(R.drawable.manl);
                    }
                    status.setText("MOVES:"+move);
                    //Toast.makeText(MainActivity.this, ""+imageView2.getTag().toString(), Toast.LENGTH_SHORT).show();
                    //System.out.println(imageView);
                    //ImageView img = (ImageView) findViewById(R.layout.activity_main).findViewWithTag("myTag");

                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (p==30)
                {
                    flag=true;
                }
                // Do something in response to button click
                if (p%10<3)
                {
                    move++;
                    //status.setText("Status");
                    int prev=map.get(p);
                    ((ImageView) findViewById(prev)).setImageResource(0);
                    p+=1;
                    int pv=map.get(p);
                    Block ctemp=bl2.get(p);
                    if (ctemp.hasGold)
                    {
                        int gold=mapg.get(p);
                        ImageView mingimageView2 = findViewById(gold);
                        mingimageView2.setImageResource(R.drawable.gold);
                        Toast.makeText(MainActivity.this, "You found Gold", Toast.LENGTH_SHORT).show();
                        goldpos=p;
                        if (move<size-1)
                        {
                            Toast.makeText(MainActivity.this, "YOU WIN", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (ctemp.hasWumpus)
                    {
                        move=0;
                        Toast.makeText(MainActivity.this, "Wampus ate you", Toast.LENGTH_SHORT).show();
                        ((ImageView) findViewById(pv)).setImageResource(R.drawable.wumpus);
                        Extra_set.add(p);
                        p=30;
                        ImageView img = findViewById(R.id.imageView12);
                        img.setImageResource(R.drawable.man);
                        flag=false;

                    }
                    if (ctemp.hasPit)
                    {
                        move=0;
                        Toast.makeText(MainActivity.this, "You fall into pit", Toast.LENGTH_SHORT).show();
                        ((ImageView) findViewById(pv)).setImageResource(R.drawable.pit);
                        Extra_set.add(p);
                        p=30;
                        ImageView img = findViewById(R.id.imageView12);
                        img.setImageResource(R.drawable.man);
                        flag=false;

                    }
                    if (ctemp.hasBreeze)
                    {
                        int breeze=mapb.get(p);
                        ImageView minimageView2 = findViewById(breeze);
                        minimageView2.setImageResource(R.drawable.stench2);
                        breeze_set.add(p);
                        //status.append("\n Breeze");
                    }
                    if (ctemp.hasStench)
                    {
                        int stench=maps.get(p);
                        ImageView minimageView2 = findViewById(stench);
                        minimageView2.setImageResource(R.drawable.stench);
                        stench_set.add(p);
                        //status.append("\n Stench");
                    }

                    //((ImageView) findViewById(R.id.imageView12)).setImageResource(0);
                    if (flag)
                    {
                        ImageView imageView2 = findViewById(pv);
                        imageView2.setImageResource(R.drawable.man);
                    }
                    status.setText("MOVES:"+move);
                    //Toast.makeText(MainActivity.this, ""+imageView2.getTag().toString(), Toast.LENGTH_SHORT).show();
                    //System.out.println(imageView);
                    //ImageView img = (ImageView) findViewById(R.layout.activity_main).findViewWithTag("myTag");

                }
            }
        });
    }
    private void increasePointerByOne(HashMap mapp,HashMap bl2,HashMap mapg,HashMap mapb,HashMap maps) {
        boolean flag=true;
        /*
        if (arr[pointer]==-1)
        {
            arr[pointer]=30;
        }*/

        //(int)map.get(cpath.get((pointer - 1) % size))
        //int idpreptr=(int)mapp.get(preptr);
        if (preptr==30)
        {
            int idpreptr=(int)mapp.get(preptr);
            ImageView iv=findViewById(idpreptr);
            iv.setImageResource(0);
        }
        else{
            ImageView iv=findViewById(preptr);
            iv.setImageResource(0);
        }

        //((ImageView) findViewById(idpreptr).setImageResource(0);
        // Update the TextView with the new pointer value

        ptr=(int)mapp.get(cpath.get(pointer));
        Block ctemp=(Block)bl2.get(cpath.get(pointer));
        if (ctemp.hasGold)
        {
            flag=false;
            int gold=(int)mapg.get(cpath.get(pointer));
            ImageView mivg= findViewById(gold);
            mivg.setImageResource(R.drawable.gold);
            Toast.makeText(MainActivity.this, "You found Gold", Toast.LENGTH_SHORT).show();
            goldpos=cpath.get(pointer);

            //break;
        }
        if (ctemp.hasBreeze)
        {
            int breeze=(int)mapb.get(cpath.get(pointer));
            ImageView mivb = findViewById(breeze);
            mivb.setImageResource(R.drawable.stench2);
            breeze_set.add(cpath.get(pointer));
            //status.append("\n Breeze");
        }
        if (ctemp.hasStench)
        {
            int stench=(int)maps.get(cpath.get(pointer));
            ImageView mivs = findViewById(stench);
            mivs.setImageResource(R.drawable.stench);
            stench_set.add(cpath.get(pointer));
            //status.append("\n Stench");
        }
        pointer=pointer+1;
        preptr=ptr;
        imgview=findViewById(ptr);
        imgview.setImageResource(R.drawable.man);


        //status.setText("MOVES:"+move);
        // Reset the timer if it's already running
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }

        // Start the timer to increase pointer after 5 seconds
        runnable = new Runnable() {

            @Override
            public void run() {
                increasePointerByOne(mapp,bl2,mapg,mapb,maps);
            }
        };
        if (pointer==size){

            if (handler != null && runnable != null) {
                handler.removeCallbacks(runnable);
            }
            ImageView iv=findViewById(preptr);
            iv.setImageResource(0);
            int spawn =(int)mapp.get(30);
            ImageView iv2=findViewById(spawn);
            iv2.setImageResource(R.drawable.man);
            int butt =(int)mapp.get(100);
            ImageButton b1=findViewById(butt);
            b1.setEnabled(true);

            butt=(int)mapp.get(101);
            b1=findViewById(butt);
            b1.setEnabled(true);

            butt=(int)mapp.get(102);
            b1=findViewById(butt);
            b1.setEnabled(true);

            butt=(int)mapp.get(99);
            b1=findViewById(butt);
            b1.setEnabled(true);
        }
        else{
            handler.postDelayed(runnable, 2000);
        }

    }
    protected void onDestroy() {
        super.onDestroy();

        // Remove the callback to prevent memory leaks
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}