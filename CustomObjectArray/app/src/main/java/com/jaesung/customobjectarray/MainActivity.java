package com.jaesung.customobjectarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI2());

        MyModel[] modelArray = getMyModelArray();
        Log.e("DEBUG", "modelArray.length = " + modelArray.length);

        ArrayList<MyModel> myModelList = new ArrayList<>(Arrays.asList(modelArray));
        for (MyModel model : myModelList) {
            Log.w("DEBUG", "name = " + model.name);
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String stringFromJNI2();

    public native MyModel[] getMyModelArray();
}
