package ufrpe.deinfo.bcc.data;

import com.google.gson.Gson;
import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class PersistenceGSON {
    private static PersistenceGSON instance;
    private Gson gson;

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
        File file = new File(path);
        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fOut);
            outputStreamWriter.write(serialized);
            outputStreamWriter.close();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection read(String path) {
        File file = new File(path);
        try {
            FileInputStream fIN = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fIN));
            Collection result = gson.fromJson(bufferedReader, Collection.class);
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
