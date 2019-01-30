import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZippedMultipleFiles {

    public static void main(String[] args) {
        geraArquivoZipado();
    }

    static void geraArquivoZipado() {
        String path = "C:/temp/agoravai.zip";
        try {
            FileOutputStream fos = new FileOutputStream(path);

            ZipOutputStream zos = new ZipOutputStream(fos);

            try {
                for (int i = 0; i < 3; i++) {
                    FileOutputStream fis = new FileOutputStream("arquivo" + i + ".txt");

                    // begin writing a new ZIP entry, positions the stream to the start of the entry data
                    zos.putNextEntry(new ZipEntry("arquivo" + i + ".txt"));
                    
                    zos.write(("Arquivo de testes " + i).getBytes());

                    zos.closeEntry();
                    // close the InputStream
                    fis.close();
                }
                // close the ZipOutputStream
                zos.close();
            } catch (IOException ioe) {
                System.out.println("Error creating zip file: " + ioe);
            }

        } catch (FileNotFoundException ee) {
            ee.printStackTrace();
        }
    }
}
