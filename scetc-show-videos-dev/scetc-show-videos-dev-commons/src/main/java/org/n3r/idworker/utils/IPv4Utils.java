package org.n3r.idworker.utils;

/**
 * This utility provides methods to either convert an IPv4 address to its long format or a 32bit dotted format.
 *
 * @author Aion
 *         Created on 22/11/12
 */
public class IPv4Utils {

    /**
     * Returns the long format of the provided IP address.
     *
     * @param ipAddress the IP address
     * @return the long format of <code>ipAddress</code>
     * @throws IllegalArgumentException if <code>ipAddress</code> is invalid
     */
    public static long toLong(String ipAddress) {
        if (ipAddress == null || ipAddress.isEmpty()) {
            throw new IllegalArgumentException("ip address cannot be null or empty");
        }
        String[] octets = ipAddress.split(java.util.regex.Pattern.quote("."));
        if (octets.length != 4) {
            throw new IllegalArgumentException("invalid ip address");
        }
        long ip = 0;
        for (int i = 3; i >= 0; i--) {
            long octet = Long.parseLong(octets[3 - i]);
            if (octet > 255 || octet < 0) {
                throw new IllegalArgumentException("invalid ip address");
            }
            ip |= octet << (i * 8);
        }
        return ip;
    }

    /**
     * Returns the 32bit dotted format of the provided long ip.
     *
     * @param ip the long ip
     * @return the 32bit dotted format of <code>ip</code>
     * @throws IllegalArgumentException if <code>ip</code> is invalid
     */
    public static String toString(long ip) {
        // if ip is bigger than 255.255.255.255 or smaller than 0.0.0.0
        if (ip > 4294967295l || ip < 0) {
            throw new IllegalArgumentException("invalid ip");
        }
        StringBuilder ipAddress = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            int shift = i * 8;
            ipAddress.append((ip & (0xff << shift)) >> shift);
            if (i > 0) {
                ipAddress.append(".");
            }
        }
        return ipAddress.toString();
    }

}