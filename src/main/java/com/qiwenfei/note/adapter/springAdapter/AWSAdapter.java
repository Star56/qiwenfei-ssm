package com.qiwenfei.note.adapter.springAdapter;

/**
 * 2019/2/24
 * sunshine
 */
public class AWSAdapter implements CloudSDK {

    private AWSSDK  awssdk ;

    public AWSAdapter(AWSSDK awssdk) {
        this.awssdk = awssdk;
    }

    @Override
    public void putObject() {

    }
}
