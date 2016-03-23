package net.callofdroidy.generalpubsub;

/**
 * Created by admin on 23/03/16.
 */
public abstract class PubsubProviderClient<T> {
    private T t;

    public PubsubProviderClient(T t){
        this.t = t;
    }

    abstract void init(Object... args);

    abstract void subscribeToChannel(String channelName, GeneralPubsubCallback generalPubsubCallback);

    abstract void publishToChannel(String channelName, Message message, GeneralPubsubCallback generalPubsubCallback);
}
