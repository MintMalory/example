package ua.mintmalory.retrofit2xml.retrofit2.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Администратор on 18.10.2016.
 */

@Root(name="item")
public class RssArticle {
    @Element(name = "title",required = false)
    private String articleTitle;

    @Element(name = "link",required = false)
    private String link;

    @Element(name="category",required = false)
    private String category;

    @Element(name="pubDate",required = false)
    private String publicationDate;

    @Element(name="description",required = false)
    private String description;

    @Element(name="guid", required = false)
    private String id;

    @Element(name="fulltext", required = false)
    private String fullText;

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

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }
}

