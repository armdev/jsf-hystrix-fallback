package com.project.effects;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 *
 * @author armdev
 */
public class HystrixHandler extends HystrixCommand<String> {

    private final String name;

    public HystrixHandler(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("HystrixHandlerGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        if(name.equalsIgnoreCase("PING")){
            return "Hello PING, I am a PONG !!!";
        }
        if(name.equalsIgnoreCase("PONG")){
            return "Aloha PONG, I am a PING !!!";
        }
        if(name.equalsIgnoreCase("KING")){
            return "Aloha  KING, I am a KONG !!!";
        }
        
        if(name.equalsIgnoreCase("KONG")){
            return "Aloha  KONG, I am a KING !!!";
        }
        
        throw new RuntimeException("Seems to be better if life is better");
    }

    @Override
    protected String getFallback() {
        return "Hey : Your message  " + name + " is not delivered!!!!";
    }   

}
