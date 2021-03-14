import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        File[] dir = {
            new File("Games"),

            new File("Games//src"),
            new File("Games//res"),
            new File("Games//savegames"),
            new File("Games//Temp"),

            new File("Games//src/main"),
            new File("Games//src/test"),

            new File("Games//res/drawables"),
            new File("Games//res/vectors"),
            new File("Games//res/icons")

        };
        File[] myFile = {
                new File("Games//src/main/Main.java"),
                new File("Games//src/main/Utils.java"),
                new File("Games//Temp/temp.txt")

        };
        for(int i = 0;i < dir.length; i++) {
            if (dir[i].mkdir()) {
                sb.append("Cоздана папка " + dir[i].getName() + "\n");
            }
        }


        for(int i = 0;i < myFile.length; i++) {
            try {
                if (myFile[i].createNewFile()) {
                    sb.append("Cоздан файл " + myFile[i].getName() + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        try (FileOutputStream fos = new FileOutputStream(myFile[2])) {
            byte[] bytes = sb.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(sb);
    }
}
