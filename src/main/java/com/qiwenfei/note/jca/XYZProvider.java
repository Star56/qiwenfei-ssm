package com.qiwenfei.note.jca;

import java.security.Provider;

/**
 * 2019/1/7
 * sunshine
 */
public class XYZProvider extends Provider {

    /**
     * Constructs a provider with the specified name, version number,
     * and information.
     *
     */
    protected XYZProvider() {
        super("XYZ", 1.0, "XYZ Security Provider v1.0");
        put("MessageDigest.XYZ", XYZMessageDigest.class.getName());
    }
}
