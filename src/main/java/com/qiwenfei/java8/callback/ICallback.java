package com.qiwenfei.java8.callback;

import java.util.Map;

/**
 * 2019/8/23
 * sunshine
 */
@FunctionalInterface
public interface ICallback {
    public void callback(Map<String, Object> params);
}
