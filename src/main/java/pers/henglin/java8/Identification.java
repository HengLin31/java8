package pers.henglin.java8;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by linheng on 2019/10/20.
 */
public class Identification {
    private static final Type IDENTIFICATION_TYPE = new TypeToken<List<Identification>>() {}.getType();

    private String id;
    private String name;
    private int age;

    public static List<Identification> initByDefaultData(){
        return initByPath(Constant.DEFAULT_IDENTIFICATION_FILE_PATH);
    }

    public static List<Identification> initByPath(String filePath){
        List<Identification> identifications = Collections.emptyList();
        File file = new File(filePath);
        try {
            JsonReader reader = new JsonReader(new FileReader(file.getAbsolutePath()));
            identifications = new Gson().fromJson(reader, IDENTIFICATION_TYPE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return identifications;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identification that = (Identification) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Identification{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
