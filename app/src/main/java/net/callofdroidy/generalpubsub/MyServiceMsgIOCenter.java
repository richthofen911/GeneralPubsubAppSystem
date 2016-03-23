package net.callofdroidy.generalpubsub;

import android.content.Intent;
import android.os.IBinder;

public class MyServiceMsgIOCenter extends ServiceMsgIOCenter {
    public MyServiceMsgIOCenter() {
    }

    public void onCreate(){
        super.onCreate();

        //Callback appCallback = new AppCallbackGeneral(this, pubnub, );
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void initPubsubProviderClient(PubsubProviderClient myPubsubProviderClient){
        // the first param should be pub key, the second one is sub key
        myPubsubProviderClient.init("pub-c-af13868a-beb9-4719-82fc-8518ddfacea8", "sub-c-48ef81b4-f118-11e5-8f88-0619f8945a4f");
    }

    @Override
    protected void subscribeToChannel(String channelName, GeneralPubsubCallback appCallback){

    }

    @Override
    protected void publishToChannel(String channelName, Message message, GeneralPubsubCallback appCallback){

    }
}
