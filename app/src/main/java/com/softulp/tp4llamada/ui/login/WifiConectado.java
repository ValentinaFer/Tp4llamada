package com.softulp.tp4llamada.ui.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class WifiConectado extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        boolean estado = intent.getBooleanExtra("connected", false);
        if (estado){
            Toast.makeText(context, "esta conectado a una red WIFI!", Toast.LENGTH_SHORT).show();
            Intent intentLlamada = new Intent(Intent.ACTION_CALL);
            intentLlamada.setData(Uri.parse("tel:"+"")); //remember to change to prof number
            intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentLlamada);
        } else {
            Toast.makeText(context, "Te desconectaste del WIFI, no?", Toast.LENGTH_SHORT).show();
        }
    }
}