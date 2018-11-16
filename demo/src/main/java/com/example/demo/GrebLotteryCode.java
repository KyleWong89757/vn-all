package com.example.demo;

import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.command.ApplicationCache;
import io.webfolder.cdp.command.CacheStorage;
import io.webfolder.cdp.internal.gson.Gson;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;
import io.webfolder.cdp.type.network.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrebLotteryCode {
    public static void main(String args[]) {
        String URL = "http://f3.aa503866.xyz/Period/GetDrawNumber?_=1542278369347";
        Document doc = null;
        GrebLotteryCode grebLotteryCode = new GrebLotteryCode();
        Map<String,String> cookies = grebLotteryCode.getCookies();
        try
        {
            doc = Jsoup
                    .connect(URL)
                    .header("User-Agent",
                            "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
                    .cookies(cookies)
                    .timeout(5000).get();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Elements e = doc.getElementsByTag("body");
        String elem = doc.getElementsByTag("body").get(0).text();
        Map<String, Object> map = new Gson().fromJson(elem, Map.class);
        System.out.println(map);
    }
    public Map<String,String> getCookies() {
        ArrayList<String> command = new ArrayList<String>();
        //不显示google 浏览器
        command.add("--headless");
        Launcher launcher = new Launcher();
        try (SessionFactory factory = launcher.launch(command);
             Session session = factory.create()) {
            session.clearCache();
            session.clearCookies();
            session.setUserAgent(
                    "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.34 (KHTML, like Gecko) PhantomJS/1.9.7 Safari/534.34");
            session.navigate("http://f3.aa503866.xyz/Member/Login");
            session.waitDocumentReady();
            session.focus("#Account");
            session.sendKeys("fxb003");
            session.focus("#Password");
            session.sendKeys("WUDYPx3xP6");
            session.sendEnter();
            session.wait(3000);
            session.click("input[id='agree']");
            session.wait(1000);
            String content = (String) session.getContent();
            String session1Content = (String) session.evaluate("window.document.body.textContent");
//            Map<String, Object> map = new Gson().fromJson(content, Map.class);
            System.out.println(content);
            List<Cookie> c =session.getCommand().getNetwork().getCookies();
            Map<String,String> cookieMap = new HashMap<String, String>();
            for (Cookie cookie : c
                 ) {
                cookieMap.put(cookie.getName(),cookie.getValue());
            }
            return cookieMap;
            //已经拿到渲染后的html，下面就可以用jsoup去抓取想要的数据了
        }
    }
}