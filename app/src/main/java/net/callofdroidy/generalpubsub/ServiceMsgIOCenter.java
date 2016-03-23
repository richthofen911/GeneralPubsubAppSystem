package net.callofdroidy.generalpubsub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.pubnub.api.Callback;

public abstract class ServiceMsgIOCenter extends Service {
    private static final String TAG = "ServiceMsgIOCenter";

    private PubsubProviderClient pubsubProviderClient;

    protected String subChannelName;
    protected String pubChannelName;

    public ServiceMsgIOCenter() {
    }

    public void onCreate(){
        super.onCreate();

        initPubsubProviderClient(pubsubProviderClient);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    abstract void initPubsubProviderClient(PubsubProviderClient pubsubProviderClient);

    protected void setPublishChannel(String pubChannelName){
        this.pubChannelName = pubChannelName;
    }

    protected void setSubscribeChannel(String subChannelName){
        this.subChannelName = subChannelName;
    }

    abstract void subscribeToChannel(String channelName, GeneralPubsubCallback appCallback);

    abstract void publishToChannel(String channelName, Message message, GeneralPubsubCallback appCallback);


    public class BinderMsgIO extends Binder{

        public void setSubChannel(String channelName){
            setSubscribeChannel(channelName);
        }

        public void setPubChannel(String channelName){
            setPublishChannel(channelName);
        }

        public void subToChannel(String channelName, GeneralPubsubCallback generalPubsubCallback){
            subscribeToChannel(channelName, generalPubsubCallback);
        }

        public void pubToChannel(String channelName, Message message, GeneralPubsubCallback generalPubsubCallback){
            publishToChannel(channelName, message, generalPubsubCallback);
        }
    }
}
