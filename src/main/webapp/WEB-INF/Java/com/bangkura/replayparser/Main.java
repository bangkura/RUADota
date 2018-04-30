package com.bangkura.replayparser;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        String matchId = "3819292612";
        String replayUrl = ApiWrapper.getReplayUrl(matchId);
        try {
            URL url = new URL(replayUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int fileLength = connection.getContentLength();
            String filePathUrl = connection.getURL().getFile();
            String fileFullName = matchId + ".dem";
            System.out.println("file length---->" + fileLength);
            URLConnection con = url.openConnection();
            BufferedInputStream bin = new BufferedInputStream(connection.getInputStream());
            BZip2CompressorInputStream gzin = new BZip2CompressorInputStream(bin);
            String path = "." + File.separatorChar + fileFullName;
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                 file.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(file);
            int size = 0;
            int len = 0;
            byte[] buf = new byte[1024];
            while ((size = gzin.read(buf)) != -1) {
                len += size;
                out.write(buf, 0, size);
                System.out.println("下载了-------> " + len * 100 / fileLength + "%\n");
            }
            bin.close();
            out.close();
            OnChatProcessor.process(fileFullName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
