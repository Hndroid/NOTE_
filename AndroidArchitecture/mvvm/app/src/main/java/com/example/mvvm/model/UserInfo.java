package com.example.mvvm.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.mvvm.BR;

/**
 * @Date：2019/9/24
 * @Author：BaiHongHua
 * @Email：2282250500@qq.com
 * @Desc:
 */
//public class UserInfo extends BaseObservable {
//
//    private String userName;
//    private String password;
//
//    @Bindable
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//        notifyPropertyChanged(BR.userName);
//    }
//
//    @Bindable
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//        notifyPropertyChanged(BR.password);
//    }
//}

public class UserInfo {
    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

}
