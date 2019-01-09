package com.qiwenfei.note.jca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 2019/1/7
 * sunshine
 */
public class MyMD5 {
    private static MessageDigest md5MsgDigest;

    static {
        try {
            md5MsgDigest = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    // 转字符串
    public static String byte2hex(byte[] b){
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    public static String getMD5(String srcMsg){
        if(srcMsg == null){
            throw new IllegalArgumentException("srcMsg is null.");
        }
        byte[] md5Bytes=md5MsgDigest.digest(srcMsg.getBytes());
        return byte2hex(md5Bytes);
    }

    public static void main(String[] args) {
        System.out.println(MyMD5.getMD5("123"));
        System.out.println(MyMD5.getMD5("world"));
    }

}
