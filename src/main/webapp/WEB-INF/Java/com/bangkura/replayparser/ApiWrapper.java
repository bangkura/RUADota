package com.bangkura.replayparser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiWrapper {
    public static String getMatchDetails(String matchId) {
        return Query(Define.getMatchDetail + "/?matchId=" + matchId);
    }

    public static String getReplayUrl(String matchId) {
        String detail = getMatchDetails(matchId);
        Pattern p = Pattern.compile("\"clusterId\":(\\d*)");
        Matcher clusterMatcher = Pattern.compile("\"clusterId\":(\\d*)").matcher(detail);
        String clusterId = "";
        if(clusterMatcher.find())
            clusterId = clusterMatcher.group(1);
        Matcher saltMatcher = Pattern.compile("\"replaySalt\":(\\d*)").matcher(detail);
        String replaySalt = "";
        if(saltMatcher.find())
            replaySalt = saltMatcher.group(1);
        return "http://replay" + clusterId + ".valve.net/570/" + matchId + "_" + replaySalt + ".dem.bz2";
    }

    public static String Query(String url) {
        try {
            URL reqUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) reqUrl.openConnection();

            connection.setConnectTimeout(5 * 1000);
            connection.setRequestMethod("GET");
            InputStream inStream = connection.getInputStream();
            byte[] data = toByteArray(inStream);
            String result = new String(data, "UTF-8");
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}
