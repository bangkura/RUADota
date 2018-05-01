package com.bangkura.Dota2ApiWrapper.Util;

import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Util {
    public static String DoHttpRequest(String requestUrl) {
        String result = "";
        BufferedInputStream bin = null;
        ByteArrayOutputStream out = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            bin = new BufferedInputStream(connection.getInputStream());
            out = new ByteArrayOutputStream();
            int size = 0;
            byte[] buf = new byte[1024];
            while ((size = bin.read(buf)) != -1) {
                out.write(buf, 0, size);
            }
            result = out.toString("UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bin != null)
                    bin.close();
                if(out != null)
                    out.close();

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String thirtytwoToSixtyFour(long id) {
        BigInteger bigInteger = new BigInteger(id+"");
        return bigInteger.add(new BigInteger("76561197960265728")).toString();
    }
}
