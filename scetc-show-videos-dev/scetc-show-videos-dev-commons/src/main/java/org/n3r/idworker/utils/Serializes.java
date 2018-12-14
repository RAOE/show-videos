package org.n3r.idworker.utils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class Serializes {

    @SuppressWarnings("unchecked")
    public static <T> List<T> readObjects(File file) {
        ArrayList<T> objects = new ArrayList<T>();
        ObjectInputStream objectReader = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            objectReader = new ObjectInputStream(fis);
            while (true)
                objects.add((T) objectReader.readObject());

        } catch (EOFException e) {
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(objectReader);
            closeQuietly(fis);
        }

        return objects;
    }


    @SuppressWarnings("unchecked")
    public static <T> T readObject(File file) {
        ObjectInputStream objectReader = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            objectReader = new ObjectInputStream(fis);
            return (T) objectReader.readObject();

        } catch (EOFException e) {
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(objectReader);
            closeQuietly(fis);
        }

        return null;
    }

    public static void writeObject(File file, Object object) {
        ObjectOutputStream objectOutput = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            objectOutput = new ObjectOutputStream(fos);
            objectOutput.writeObject(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(objectOutput);
            closeQuietly(fos);
        }
    }

    public static void writeObject(FileOutputStream fos, Object object) {
        FileChannel channel = fos.getChannel();
        if (!channel.isOpen()) throw new RuntimeException("channel is closed");

        try {
            channel.position(0);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fos);
            objectOutput.writeObject(object);
            fos.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static void writeObjects(File file, Object... objects) {
        ObjectOutputStream objectOutput = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            objectOutput = new ObjectOutputStream(fos);

            for (Object object : objects)
                objectOutput.writeObject(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(objectOutput);
            closeQuietly(fos);
        }

    }

    public static void closeQuietly(OutputStream os) {
        if (os != null) try {
            os.close();
        } catch (IOException e) {
            // ignore
        }
    }


    public static void closeQuietly(InputStream is) {
        if (is != null) try {
            is.close();
        } catch (IOException e) {
            // ignore
        }

    }
}
