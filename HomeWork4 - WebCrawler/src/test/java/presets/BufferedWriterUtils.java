package presets;

import java.io.*;

public class BufferedWriterUtils {
    public static BufferedWriter bw;

    public static BufferedWriter getWriter(String header) throws IOException {

        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Books.csv"), "cp1251"));
        bw.write(header);
        return bw;
    }

    public static void writeDataFile(String urlBooks, String title, String author, String price, String linkDownloadTrialFragment) throws IOException {
        bw.write(urlBooks + ";");
        bw.write(title + ";");
        bw.write(author + ";");
        bw.write(price + ";");
        bw.write(linkDownloadTrialFragment + ";\n");
    }

    public static void closeBw() throws IOException {
        if (bw != null) {
            bw.close();
        }
    }

}
