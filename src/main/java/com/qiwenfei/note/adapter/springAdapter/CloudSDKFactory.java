package com.qiwenfei.note.adapter.springAdapter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 2019/2/24
 * sunshine
 */
public class CloudSDKFactory {

    static Map<String,CloudSDK> cloudSDKMap = new ConcurrentHashMap<>();

    static {
        CloudSDK aws = cloudSDKMap.put("aws", new AWSAdapter(new AWSSDK()));
    }

    static CloudSDK create(String name){
      return cloudSDKMap.get(name);
    }

}
