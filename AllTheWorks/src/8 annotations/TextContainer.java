package annotations;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Date;

//Second task
@SaveTo(path = "c:\\OBDZ\\file.txt")
public class TextContainer {
    @Save
    String field = "";
    @Save
    Date created;
    @Save
    Date lastChange;

    int changesAmount;

    public TextContainer(){
        created = new Date();
        lastChange = created;
        changesAmount = 0;
    }

    public TextContainer(String text){
        field = text;
        created = new Date();
        lastChange = created;
        changesAmount = 0;
    }

    public void change(String text){
        field = text;
        lastChange = new Date();
        changesAmount++;
    }

    @Saver
    public void save() throws IOException, IllegalAccessException {
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(
                        new FileOutputStream(
                            TextContainer.class
                                    .getAnnotation(SaveTo.class)
                                    .path(),
                                false
                        ));

        for (Field f : TextContainer.class.getDeclaredFields()){
            if (f.isAnnotationPresent(Save.class)) {
                objectOutputStream.writeObject(f.get(this));
            }
        }

        objectOutputStream.close();
    }

    public void load() throws IOException, ClassNotFoundException, IllegalAccessException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream(
                        new FileInputStream(
                            TextContainer.class
                                    .getAnnotation(SaveTo.class)
                                    .path()
                        ));

        Field[] fs = TextContainer.class.getDeclaredFields();
        for (int i = 0; i < fs.length; i++){
            if (fs[i].isAnnotationPresent(Save.class))
                fs[i].set(this, objectInputStream.readObject());
        }

        objectInputStream.close();
    }
}
