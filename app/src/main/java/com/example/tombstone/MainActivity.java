package com.example.tombstone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.tombstone.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TombstoneApp";

private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.e(TAG, "This app will crash and generate a tombstone in /data/tombstones/");

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'tombstone' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'tombstone' library on application startup.
    static {
        System.loadLibrary("tombstone");
    }
}