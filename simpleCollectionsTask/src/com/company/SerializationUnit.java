package com.company;

import java.io.*;

public class SerializationUnit {
    public void Serialize(Object sds, String path) throws IOException {
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(path));

        objectOutputStream.writeObject(sds);
        objectOutputStream.close();
    }

    public Object Deserialize(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));

        Object result = objectInputStream.readObject();

        objectInputStream.close();
        return result;
    }
}
