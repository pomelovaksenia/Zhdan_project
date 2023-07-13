package system_pac.model;

import java.util.Date;

public class Comments {
    public Date getCommentDate() {
        return commentDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public Comments(Date commentDate, String commentText) {
        this.commentDate = commentDate;
        this.commentText = commentText;
    }

    private Date commentDate;
    private String commentText;

}
