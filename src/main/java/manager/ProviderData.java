package manager;

import model.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ProviderData {

    @DataProvider
    public Iterator<Object[]>userModelListDTO() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/reg_data.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .withEmail(split[2])
                    .withPassword(split[3])
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
}
