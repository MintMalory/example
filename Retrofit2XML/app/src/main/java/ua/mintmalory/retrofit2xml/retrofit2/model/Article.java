package ua.mintmalory.retrofit2xml.retrofit2.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Администратор on 18.10.2016.
 */

@Root(name="item", strict = false)
public class Article {
    @Element(name = "title")
    private String articleTitle;

    @Element(name = "link")
    private String link;

    @Element(name="category")
    private String category;

    @Element(name="pubDate")
    private String publicationDate;

    @Element(name="description")
    private String description;

    @Element(name="guid")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}

