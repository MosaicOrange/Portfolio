package com.android.pinto.monitor;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static android.os.Process.killProcess;

public class ProcessDetail extends AppCompatActivity implements View.OnClickListener{
    int pid = 0;
    String name = null;
    ActivityManager activityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button exit_button = (Button) findViewById(R.id.exit_button);
        exit_button.setOnClickListener(this);
        Button kill_button = (Button) findViewById(R.id.kill_button);
        kill_button.setOnClickListener(this);
        pid = getIntent().getExtras().getInt("PID");

        name = getIntent().getExtras().getString("Name");

        TextView displayView = (TextView) findViewById(R.id.process_info);
        String textToShow = null;
        textToShow = "Name: " + name + "\nPID: " + pid + "\nUsage: " +
                parseCPUUsage() + "%\nMemory: " + getMemory(pid, name) + " MB\n";
        displayView.setText(textToShow);
    }

    private float parseCPUUsage() {
        Bundle context = getIntent().getExtras();
        return (context.getLong("total_time"))/((context.getFloat("uptime")) - (context.getLong("start_time")/100));
    }

    private double getMemory(int pid, String name) {
        activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        int [] pids = {pid};
        android.os.Debug.MemoryInfo[] memoryInfoArray = activityManager.getProcessMemoryInfo(pids);
        android.os.Debug.MemoryInfo pidMemoryInfo = memoryInfoArray[0];

        Log.d("Memory", String.format("** MEMINFO in pid %d [%s] **\n", pids[0], name));
        Log.d("Memory", " pidMemoryInfo.getTotalPrivateDirty(): " + pidMemoryInfo.getTotalPrivateDirty() + "\n");
        Log.d("Memory", " pidMemoryInfo.getTotalPss(): " + pidMemoryInfo.getTotalPss() + "\n");
        Log.d("Memory", " pidMemoryInfo.getTotalSharedDirty(): " + pidMemoryInfo.getTotalSharedDirty() + "\n");
        return (pidMemoryInfo.getTotalPrivateDirty() + pidMemoryInfo.getTotalPss() + pidMemoryInfo.getTotalSharedDirty())/1024;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exit_button:
                finish();
                break;
            case R.id.kill_button:
                killProcess(pid);
                activityManager.killBackgroundProcesses(name);
                recreate();
                break;
            default:
                break;
        }
    }
}
