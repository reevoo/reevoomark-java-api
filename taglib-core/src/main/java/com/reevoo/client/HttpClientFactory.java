package com.reevoo.client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

public class HttpClientFactory {
    public static HttpClient build(int connectTimeout) {
        HttpConnectionManagerParams params = buildParams(connectTimeout);
        MultiThreadedHttpConnectionManager connectionManager = buildConnectionManager(params);
        HttpClient client = buildClient(connectionManager);

        return client;
    }

    private static MultiThreadedHttpConnectionManager buildConnectionManager(HttpConnectionManagerParams params) {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.setParams(params);

        return connectionManager;
    }

    private static HttpConnectionManagerParams buildParams(int connectTimeout) {
        HttpConnectionManagerParams params = new HttpConnectionManagerParams();
        params.setConnectionTimeout(connectTimeout);
        params.setLinger(-1);
        params.setSoTimeout(connectTimeout);
        params.setMaxTotalConnections(1000);

        return params;
    }

    private static HttpClient buildClient(MultiThreadedHttpConnectionManager connectionManager) {
        HttpClient client = new HttpClient(connectionManager);

        String proxyHost = System.getProperty("http.proxyHost");
        String proxyPort = System.getProperty("http.proxyPort");

        if (proxyHost != null && proxyPort != null) {
            client.getHostConfiguration().setProxy(proxyHost, Integer.parseInt(proxyPort));
        }

        return client;
    }
}
