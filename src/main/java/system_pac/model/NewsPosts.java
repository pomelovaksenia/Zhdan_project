package system_pac.model;

import java.util.Date;

public class NewsPosts {
    public Date getNewsDate() {
        return newsDate;
    }

    public String getNewsText() {
        return newsText;
    }

    public NewsPosts(Date newsDate, String newsText) {
        this.newsDate = newsDate;
        this.newsText = newsText;
    }

    private Date newsDate;
    private String newsText;
}
