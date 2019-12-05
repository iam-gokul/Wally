package com.edustan.wally;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

public class MyJob extends JobService {
    private static final String TAG = "Wallstag";
    boolean isWorking = false;
    boolean jobCancelled = false;

    // Called by the Android system when it's time to run the job
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "Job started!");
        Toast.makeText(this, "Job Started", Toast.LENGTH_SHORT).show();
        // We need 'jobParameters' so we can call 'jobFinished'

        return false;
    }


    // Called if the job was cancelled before being finished
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "Job cancelled before being completed.");
        Toast.makeText(this, "Job Finisheda", Toast.LENGTH_SHORT).show();
        return false;
    }
}
