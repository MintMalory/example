package ua.mintmalory.retrofit2xml.retrofit2.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Администратор on 18.10.2016.
 */

@Root(strict = false)
public class RssChannel {
    @Element(name="title")
    private String channelName;

    @Element(name="link", required = false)
    private String channelLink;

    @ElementList(name="item",inline = true)
    private List<RssArticle> rssArticles;

    public List<RssArticle> getRssArticles() {
        return rssArticles;
    }

    public void setRssArticles(List<RssArticle> rssArticles) {
        this.rssArticles = rssArticles;
    }

    public String getChannelLink() {
        return channelLink;
    }

    public void setChannelLink(String channelLink) {
        this.channelLink = channelLink;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
