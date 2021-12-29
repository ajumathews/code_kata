import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReader {


    private Map jsonConfigurations = new HashMap();

    public void parseAllFiles(File folder) throws IOException {
        for (File file : folder.listFiles()) {
            if (!file.isFile()) {
                parseAllFiles(file);
            } else {
                if (FilenameUtils.getExtension(file.getName()).equals("json")) {
                    Map json = new Gson().fromJson(FileUtils.readFileToString(file, StandardCharsets.UTF_8), Map.class);
                    jsonConfigurations.put(FilenameUtils.getBaseName(file.getName()), json);
                }

            }
        }

    }


    private void parseJsonConfigFiles(String root) {
        String environmentDirectoryName = "env-prod";
        String subEnvironmentDirectoryName = "subenv-prod";
        String[] directories = new String[3];
        directories[0] = root;
        directories[1] = root + File.separator + environmentDirectoryName + File.separator;
        directories[2] = root + File.separator + environmentDirectoryName + File.separator + subEnvironmentDirectoryName + File.separator;

        for (String dir : directories) {
            File folder = new File(dir);
            for (File file : folder.listFiles()) {
                if (file.isFile() && FilenameUtils.getExtension(file.getName()).equals("json")) {
                    try {
                        Map json = new Gson().fromJson(FileUtils.readFileToString(file, StandardCharsets.UTF_8), Map.class);
                        jsonConfigurations.putAll(json);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


    }




    public static void main(String[] args) throws IOException {
        String rootLocation = "C:\\Aju\\Learning\\code_kata\\java-practice\\file-reader\\src\\main\\resources";
        //File folder = new File("C:\\Aju\\Learning\\code_kata\\java-practice\\file-reader\\src\\main\\resources");
        FileReader f = new FileReader();
       f.parseJsonConfigFiles(rootLocation);

        System.out.println(f.jsonConfigurations.size());

    }
}
