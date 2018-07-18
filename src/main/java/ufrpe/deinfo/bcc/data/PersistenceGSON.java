package ufrpe.deinfo.bcc.data;

import com.google.gson.Gson;

import java.io.*;
import java.util.Collection;

public class PersistenceGSON {
    private static PersistenceGSON instance;
    private static Gson gson;
    private static File file;

    private PersistenceGSON() {
        gson = new Gson();
    }

    public static PersistenceGSON getInstance() {
        if(instance == null)
            instance = new PersistenceGSON();

        return instance;
    }

    public void persist(Collection objs, String path) {
        String serialized = gson.toJson(objs);
    }
}
