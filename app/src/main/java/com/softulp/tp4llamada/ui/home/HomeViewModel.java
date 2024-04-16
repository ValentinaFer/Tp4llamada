package com.softulp.tp4llamada.ui.home;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<String> error;

    public HomeViewModel(Application app) {
        super(app);
    }

    public MutableLiveData<String> getError() {
        if (error == null){
            error = new MutableLiveData<>();
        };
        return error;
    }

    public void llamar(String tel){
        if (!tel.trim().isEmpty()){
            Intent intentLlamada = new Intent(Intent.ACTION_CALL);
            intentLlamada.setData(Uri.parse("tel:"+tel));
            intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intentLlamada);
        } else {
            error.setValue("Debe ingresar un número de teléfono primero!");
        }
    }

}