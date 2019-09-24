package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.model.UserInfo;

public class MainActivity extends AppCompatActivity {

    private UserInfo mUserInfo = new UserInfo();
    private final static String TAG = "netease >>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


//        //单向数据的刷新方式《model ---> View》
//        mUserInfo.setUserName("测试");
//        mUserInfo.setPassword("123");
//
//        binding.setUser(mUserInfo);
//
//
//        Log.i(TAG, "onCreate: >>>>>>> " + mUserInfo.getUserName() + " ##### " + mUserInfo.getPassword());
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mUserInfo.setUserName("lingtai");
//                mUserInfo.setPassword("dddddd");
//                binding.setUser(mUserInfo);
//                Log.i(TAG, "onCreate: >>>>>>> " + mUserInfo.getUserName() + " ##### " + mUserInfo.getPassword());
//            }
//        }, 5000);


//        //单向绑定第二种方式：《Model -----> View》
//        mUserInfo.userName.set("白老师");
//        mUserInfo.password.set("163");
//        binding.setUser(mUserInfo);
//        Log.i(TAG, "onCreate: >>>>>>> " + mUserInfo.userName.get() + " ##### " + mUserInfo.password.get());
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mUserInfo.userName.set("马老师");
//                mUserInfo.password.set("911");
//                binding.setUser(mUserInfo);
//                Log.i(TAG, "onCreate: >>>>>>> " + mUserInfo.userName.get() + " ##### " + mUserInfo.password.get());
//            }
//        }, 5000);


        //双向绑定（model <---> view）
        mUserInfo.userName.set("白老师");
        mUserInfo.password.set("163");
        binding.setUser(mUserInfo);
        Log.i(TAG, "onCreate: >>>>>>> " + mUserInfo.userName.get() + " ##### " + mUserInfo.password.get());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "onCreate: >>>>>>> " + mUserInfo.userName.get() + " ##### " + mUserInfo.password.get());
            }
        }, 20000);








        



    }
}
