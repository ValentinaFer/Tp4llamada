package com.softulp.tp4llamada.ui.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import android.util.Patterns;
import android.widget.Toast;

import com.softulp.tp4llamada.MainActivity;
import com.softulp.tp4llamada.R;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<String> mError;
    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getError(){
        if (mError == null){
            mError = new MutableLiveData<>();
        }
        return mError;
    }
    public void isUserDataValid(String username, String password) {
        if (username.equals("Admin") && password.equals("123")){
            Intent intent = new Intent(getApplication(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        } else {
            mError.setValue("usuario y/o contraseña incorrecto");
        }
    }
}