package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Util.Defines;
import com.bangkura.Dota2ApiWrapper.Util.Util;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseApi{
    protected static ObjectMapper mapper = new ObjectMapper();
    protected String baseUrl;
    protected HashMap<String, String> parameters = new HashMap<String, String>();

    public String getApiUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append(baseUrl);
        builder.append("?");
        builder.append("key=" + Defines.KEY);
        for(Map.Entry<String, String> entry : parameters.entrySet()) {
            builder.append("&");
            builder.append(entry.getKey() + "=" + entry.getValue());
        }
        return builder.toString();
    }

    public TreeNode getResultNode() throws WrongUrlException {
        TreeNode resultNode = null;
        try {
            TreeNode rootNode = mapper.readTree(Util.DoHttpRequest(getApiUrl()));
            resultNode = rootNode.path("result");
        } catch(IOException e) {
            e.printStackTrace();
        }
        if(resultNode == null)
            throw new WrongUrlException(getApiUrl());
        return resultNode;
    }

    public TreeNode getResponseNode() throws WrongUrlException {
        TreeNode responseNode = null;
        try {
            TreeNode rootNode = mapper.readTree(Util.DoHttpRequest(getApiUrl()));
            responseNode = rootNode.path("response");
        } catch(IOException e) {
            e.printStackTrace();
        }
        if(responseNode == null)
            throw new WrongUrlException(getApiUrl());
        return responseNode;
    }
}
