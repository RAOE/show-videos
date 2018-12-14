package org.n3r.idworker.utils;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {

    public static final String DOT_IDWORKERS = ".idworkers";

    public static ClassLoader getClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader != null ? contextClassLoader : Utils.class.getClassLoader();
    }


    public static InputStream classResourceToStream(String resourceName) {
        return getClassLoader().getResourceAsStream(resourceName);
    }


    public static String firstLine(String classResourceName) {
        InputStream inputStream = null;
        try {
            inputStream = classResourceToStream(classResourceName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            return bufferedReader.readLine();
        } catch (IOException e) {
            return null;
        } finally {
            if (inputStream != null) try {
                inputStream.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }

    public static String checkNotEmpty(String param, String name) {
        if (param == null || param.isEmpty())
            throw new IllegalArgumentException(name + " is empty");

        return param;
    }


    public static long midnightMillis() {
        // today
        Calendar date = Calendar.getInstance();
        // reset hour, minutes, seconds and millis
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        return date.getTimeInMillis();
    }

    public static void main(String[] args) {
        // 2013-12-25 00:00:00.000
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Timestamp(midnightMillis())));
        System.out.println(encode(281474976710655L));
    }

    public static long decode(String s, String symbols) {
        final int B = symbols.length();
        long num = 0;
        for (char ch : s.toCharArray()) {
            num *= B;
            num += symbols.indexOf(ch);
        }
        return num;
    }

    public static String encode(long num) {
        return encode(num, defaultRange);
    }

    public static String encode(long num, String symbols) {
        final int B = symbols.length();
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(symbols.charAt((int) (num % B)));
            num /= B;
        }
        return sb.reverse().toString();
    }

    // all un-clearly-recognized letters are skiped.
    static String defaultRange = "0123456789ABCDFGHKMNPRSTWXYZ";

    public static String padLeft(String str, int size, char padChar) {
        if (str.length() >= size) return str;

        StringBuilder s = new StringBuilder();
        for (int i = size - str.length(); i > 0; --i) {
            s.append(padChar);
        }
        s.append(str);

        return s.toString();
    }

    public static File createIdWorkerHome() {
        String userHome = System.getProperty("user.home");
        File idWorkerHome = new File(userHome + File.separator + DOT_IDWORKERS);
        idWorkerHome.mkdirs();
        if (idWorkerHome.isDirectory()) return idWorkerHome;

        throw new RuntimeException("failed to create .idworkers at user home");
    }
}
