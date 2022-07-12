package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "longUrls")
public class LongUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "url")
    private String url;

    public LongUrl() {
    }

    public LongUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
