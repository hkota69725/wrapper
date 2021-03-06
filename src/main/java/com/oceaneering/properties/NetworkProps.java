/*
 * To change this license header, choose License Headers in Project Properties.
 * and open the template in the editor.
 */
package com.oceaneering.properties;

/**
 *
 * @author SKashyap
 *
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NetworkProps {

    public String host;
    public Integer port;
    public String scheme;
    public String mdsUrl;
    private static NetworkProps _instance = null;

    public static NetworkProps Instance() {
        if (_instance == null) {
            try {
                _instance = new NetworkProps();
            } catch (Exception e) {
            }
        }
        return _instance;
    }

    private NetworkProps() {
        InputStream in = null;
        try {
            //System.out.println("Reading Network properties");
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            in = classLoader.getResourceAsStream("network.properties");
            Properties properties = new Properties();
            properties.load(in);
            if (properties.getProperty("net.host") != null) {
                host = properties.getProperty("net.host").trim();
            }
            if (properties.getProperty("net.port") != null) {
                port = Integer.parseInt(properties.getProperty("net.port").trim());
            }
            if (properties.getProperty("net.scheme") != null) {
                scheme = properties.getProperty("net.scheme").trim();
            }
            if (properties.getProperty("net.mdsUrl") != null) {
                mdsUrl = properties.getProperty("net.mdsUrl").trim();
            }

        } catch (Exception ex) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
