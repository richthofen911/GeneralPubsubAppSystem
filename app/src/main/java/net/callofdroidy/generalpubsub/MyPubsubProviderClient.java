package net.callofdroidy.generalpubsub;

import android.util.Log;

import com.google.gson.Gson;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubException;

/**
 * Created by admin on 23/03/16.
 */
public class MyPubsubProviderClient extends PubsubProviderClient<Pubnub>{

    private Pubnub pubnub;
    private Gson gson;

    public MyPubsubProviderClient(Pubnub pubnub){
        super(pubnub);
        gson = new Gson();
    }

    @Override
    public void init(Object... args){
        this.pubnub = new Pubnub((String)args[0], (String)args[1]);
    }

    @Override
    public void subscribeToChannel(String channelName, GeneralPubsubCallback generalPubsubCallback){

        try{
            pubnub.subscribe("Channel-a28z6ck8r", generalPubsubCallback);
        }catch (PubnubException e){
            Log.e("SUBSCRIBE", "Error: " + e.toString());
        }
    }

    @Override
    public void publishToChannel(String channelName, Message message, GeneralPubsubCallback generalPubsubCallback){
        pubnub.publish("Channel-a28z6ck8r", gson.toJson(message), generalPubsubCallback);
    }
}
