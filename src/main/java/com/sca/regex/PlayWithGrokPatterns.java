package com.sca.regex;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import oi.thekraken.grok.api.Grok;
import oi.thekraken.grok.api.Match;
import oi.thekraken.grok.api.exception.GrokException;

import java.io.File;
import java.io.IOException;

/**
 * Created by serguei_cambour on 16/12/2015.
 */
public class PlayWithGrokPatterns {

    public static void main(String[] args) {
        /** Create a new grok instance */
        try {
            ClassLoader classLoader = PlayWithGrokPatterns.class.getClassLoader();
            //for available patterns see http://grokdebug.herokuapp.com/patterns
            File patternFile = new File(classLoader.getResource("haproxy_pattern.txt").getFile());
            System.out.println("########### Loading patern file: " + patternFile.getPath());

            Grok grok = Grok.create(patternFile.getPath());
            /** Grok pattern to compile, here httpd logs */
            //String pattern = "haproxy\\[%{INT:hapPid}\\]: %{IP:clientIp}:%{INT:clientPort} \\[(?<acceptDate>[^]]+)\\] (?<appli>\\w{3})(?<env>[^0-9]+)(?<noEnv>\\d)_%{NOTSPACE:frontend}\\s*(?<backend>[^/]+)/%{NOTSPACE:backendInstance} %{INT:queryTime}/%{INT:queueTime}/%{INT:connectionTime}/%{INT:responseTime}/%{INT:totalTime} %{INT:httpCode} %{INT:httpReadBytes} %{NOTSPACE:requestCookie} %{NOTSPACE:responseCookie} %{NOTSPACE:terminationState} %{INT:activeConnections}/%{INT:frontendConnections}/%{INT:backendConnections}/%{INT:serverConnections}/%{INT:connectionRetries} %{INT:serverQueue}/%{INT:backendQueue}( \\{%{NOTSPACE:domainName}\\})? \\\"%{WORD:httpCmd} %{URIPATHPARAM:request} (?:HTTP/%{NUMBER:httpVersion})?.*";
            String pattern = "haproxy\\[%{INT:hapPid}\\]: %{IP:clientIp}:%{INT:clientPort} \\[(?<acceptDate>[^]]+)\\] (?<appli>\\w{3})(?<env>[^0-9]+)(?<noEnv>\\d)_(?<domainName>[^_]+)_(?<direction>[^_]+)_(?<httpMode>[^ ]+)*\\s*%{NOTSPACE}+\\s*%{INT:queryTime}/%{INT:queueTime}/%{INT:connectionTime}/%{INT:responseTime}/%{INT:totalTime} %{INT:httpCode} %{INT:httpReadBytes} %{NOTSPACE:requestCookie} %{NOTSPACE:responseCookie} %{NOTSPACE:terminationState} %{INT:activeConnections}/%{INT:frontendConnections}/%{INT:backendConnections}/%{INT:serverConnections}/%{INT:connectionRetries} %{INT:serverQueue}/%{INT:backendQueue}( \\{%{NOTSPACE:vhost}\\})?\\s*\"%{WORD:httpCmd} %{NOTSPACE:request} (?:HTTP/%{NUMBER:httpVersion})\"";
            grok.compile(pattern);
            //String log = "haproxy[6497]: 127.0.0.1:52113 [11/Dec/2015:03:09:52.191] CDNPRD1_www.es-integration3.voyages-sncf.com_back_http www.es-integration3.voyages-sncf.com_back_http/lille 0/0/11/15/27 200 347 - - --NI 1/0/0/0/0 0/0 {www.es-integration3.voyages-sncf.com} \"GET /DSA_SLA_test_page/akamai-sureroute-test-object.htm HTTP/1.0\"";
              String log = "haproxy[13342]: 127.0.0.1:59042 [16/Nov/2015:14:12:10.463] CDNPRD1_www.es-integration3.voyages-sncf.com_back_http www.es-integration3.voyages-sncf.com_back_http/lille 0/0/11/15/26 200 8497 - - --NI 1/0/0/0/0 0/0 {www.es-integration3.voyages-sncf.com} \"GET //DSA_SLA_test_page/akamai-sureroute-test-object.htm HTTP/1.0\"";
            Match gm = grok.match(log);
            gm.captures();


            /** Get the output as JSON */
            System.out.println(gm.toJson());

            readJson(gm.toJson());
        } catch (GrokException e) {
            e.printStackTrace();
        }

    }

    private static void readJson(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode actualObj = mapper.readTree(jsonString);
            System.out.println("\n+++++++++++ JSON value to check: " + actualObj.get("httpMode"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
