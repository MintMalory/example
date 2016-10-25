package ua.mintmalory.retrofit2xml.retrofit2.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Администратор on 18.10.2016.
 */

@Root(strict = false)
public class Channel {
    @Element(name="title")
    private String channelName;

    @Element(name="link")
    private String channelLink;

    @ElementList(name="item",required = true, inline = true)
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
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
