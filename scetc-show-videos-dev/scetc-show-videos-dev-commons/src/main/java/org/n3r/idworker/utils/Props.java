package org.n3r.idworker.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

import static java.io.File.separator;
import static org.n3r.idworker.utils.Serializes.closeQuietly;

public class Props {
    static Logger log = LoggerFactory.getLogger(Props.class);

    public static Properties tryProperties(String propertiesFileName, String userHomeBasePath) {
        Properties properties = new Properties();
        InputStream is = null;
        try {
            is = Props.tryResource(propertiesFileName, userHomeBasePath, Silent.ON);
            if (is != null) properties.load(is);
        } catch (IOException e) {
            log.error("load properties error: {}", e.getMessage());
        } finally {
            closeQuietly(is);
        }

        return properties;
    }


    enum Silent {ON, OFF}

    public static InputStream tryResource(String propertiesFileName, String userHomeBasePath, Silent silent) {
        InputStream is = currentDirResource(new File(propertiesFileName));
        if (is != null) return is;

        is = userHomeResource(propertiesFileName, userHomeBasePath);
        if (is != null) return is;

        is = classpathResource(propertiesFileName);
        if (is != null || silent == Silent.ON) return is;

        throw new RuntimeException("fail to find " + propertiesFileName + " in current dir or classpath");
    }

    private static InputStream userHomeResource(String pathname, String appHome) {
        String filePath = System.getProperty("user.home") + separator + appHome;
        File dir = new File(filePath);
        if (!dir.exists()) return null;

        return currentDirResource(new File(dir, pathname));
    }

    private static InputStream currentDirResource(File file) {
        if (!file.exists()) return null;

        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // This should not happened
            log.error("read file {} error", file, e);
            return null;
        }
    }

    public static InputStream classpathResource(String resourceName) {
        return Props.class.getClassLoader().getResourceAsStream(resourceName);
    }

}
