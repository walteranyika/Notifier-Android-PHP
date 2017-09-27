package io.walter.notifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TOKEN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String token= FirebaseInstanceId.getInstance().getToken();
        if (token!=null){
            Log.d(TAG, "TOKEN: "+token);
        }else {
            Log.d(TAG, "onCreate: Token not found");
        }
    }
}
