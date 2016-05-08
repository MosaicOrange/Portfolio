package com.android.pinto.monitor;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Collections;
import library.src.main.java.com.jaredrummler.android.processes.ProcessManager;
import library.src.main.java.com.jaredrummler.android.processes.models.AndroidAppProcess;
import library.src.main.java.com.jaredrummler.android.processes.models.AndroidProcess;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listView;
    List<AndroidAppProcess> processList;

    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
            int level = i.getIntExtra("level", 0);
            TextView tv = (TextView) findViewById(R.id.textfield);
            String textToShow = " Battery Usage: " + Integer.toString(level) + "%";
            tv.setText(textToShow);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button exit = (Button)findViewById(R.id.exit);
        Button refresh = (Button) findViewById(R.id.refresh);
        exit.setOnClickListener(this);
        refresh.setOnClickListener(this);
    }

    private void setAdapterListener(final CustomArrayAdapter myAdapter) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                    AndroidProcess item = (AndroidProcess) myAdapter.getItem(position);
                    Log.d("Process", "Process Choosen: " + item.name);
                    startNewIntent(item);
            }
        });
    }

    private void startNewIntent(AndroidProcess processChosen) {
        Intent displayDetail = new Intent(this, ProcessDetail.class);
        displayDetail.putExtra("PID",processChosen.pid);
        displayDetail.putExtra("Name", processChosen.name);

        long utime = 0;
        long stime = 0;
        long cutime = 0;
        long cstime = 0;
        long starttime = 0;
        try {
            utime = processChosen.stat().utime();
            stime = processChosen.stat().stime();
            cutime = processChosen.stat().cutime();
            cstime = processChosen.stat().cstime();
            starttime = processChosen.stat().starttime();

        } catch (IOException e) {
            e.printStackTrace();
        }

        long total_time = utime + stime + cutime + cstime;
        displayDetail.putExtra("total_time", total_time);
        displayDetail.putExtra("start_time",starttime);
        displayDetail.putExtra("uptime", readUpTime());
        Log.d("start_time", String.valueOf(starttime));
        Log.d("Time elapsed", String.valueOf(readUpTime() - starttime/100));
        startActivity(displayDetail);
    }

    private float readUpTime() {
        RandomAccessFile reader = null;
        float uptime = 0;
        try {
            reader = new RandomAccessFile("/proc/uptime", "r");
            String load = reader.readLine();
            String[] toks = load.split(" +");
            uptime = Float.parseFloat(toks[0]);
            Log.d("uptime", String.valueOf(uptime));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uptime;
    }

    private float readUsage() {
        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            String load = reader.readLine();

            String[] toks = load.split(" +");

            long idle = Integer.parseInt(toks[4]);
            long cpu = 0;
            for (int x=1; x<=8; x++){
                cpu = cpu + Integer.parseInt(toks[x]);
            }

            Log.d("cpu", String.valueOf(cpu));
            Log.d("idle", String.valueOf(idle));
            float calc = 100*(1 - ((float)idle/(float)cpu));
            Log.d("overall", String.valueOf(calc));

            return calc;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public void displayInfo(){
        registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        processList = ProcessManager.getRunningAppProcesses();
        Collections.reverse(processList);

        TextView cpuView = (TextView) findViewById(R.id.general_info);
        String textToView = " CPU Usage: " + readUsage() + "%";
        cpuView.setText(textToView);

        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        String textToShow = " Available Memory: " + (mi.availMem/1048576L) + " out of " + (mi.totalMem/1048576L) + " MB";
        Log.d("Memory Info", textToShow);
        TextView memoryView = (TextView) findViewById(R.id.memory_info);
        memoryView.setText(textToShow);

        listView = (ListView)findViewById(R.id.processes_list);
        final CustomArrayAdapter myAdapter = new CustomArrayAdapter(this, processList);
        listView.setAdapter(myAdapter);
        setAdapterListener(myAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit:
                finish();
                break;
            case R.id.refresh:
                recreate();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        displayInfo();
    }

    @Override
    protected void onPause(){
        super.onPause();
        unregisterReceiver(mBatInfoReceiver);
    }
}