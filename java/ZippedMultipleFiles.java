import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZippedMultipleFiles {

    public static void main(String[] args) {
        geraArquivoZipado();
        unzipArquivo("/home/rafael.waterkemper/temp/agoravai.zip");
    }

    static void geraArquivoZipado() {
        String path = "/home/rafael.waterkemper/temp/agoravai.zip";
        try {
            FileOutputStream fos = new FileOutputStream(path);

            ZipOutputStream zos = new ZipOutputStream(fos);

            try {
                for (int i = 0; i < 3; i++) {
                    zos.putNextEntry(new ZipEntry("arquivo" + i + ".txt"));

                    zos.write(("Arquivo de testes " + i).getBytes());

                    zos.closeEntry();
                }
                zos.close();
            } catch (IOException ioe) {
                System.out.println("Error creating zip file: " + ioe);
            }
        } catch (FileNotFoundException ee) {
            ee.printStackTrace();
        }
    }

    static void unzipArquivo(String pathZip) {
        ByteArrayInputStream fileZipped;
        File arquivoZipado = new File(pathZip);

        try {
            fileZipped = new ByteArrayInputStream(Files.readAllBytes(arquivoZipado.toPath()));
            ZipInputStream zis = new ZipInputStream(fileZipped);
            ZipEntry zie = zis.getNextEntry();

            while (zie != null) {
                FileOutputStream fos = new FileOutputStream("/home/rafael.waterkemper/temp/" + zie.getName());

                IOUtils.copy(zis, fos);
                fos.close();
                zie = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            fileZipped.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
