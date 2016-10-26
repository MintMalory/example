package ua.mintmalory.retrofit2xml.retrofit2.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class Rss {
    @Element (name = "channel")
    private RssChannel rssChannel;

    public RssChannel getRssChannel() {
        return rssChannel;
    }

    public void setRssChannel(RssChannel rssChannel) {
        this.rssChannel = rssChannel;
    }
}
