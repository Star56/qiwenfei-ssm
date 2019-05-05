package com.qiwenfei.note.adapter.springAdapter;

/**
 * 2019/2/24
 * sunshine
 */
public class CloudService {

    private CloudSDK cloudSDK ;

    public CloudService(String name) {
        this.cloudSDK = CloudSDKFactory.create(name);
    }

    public void uploadfile(String file){
        cloudSDK.putObject();
    }
}
