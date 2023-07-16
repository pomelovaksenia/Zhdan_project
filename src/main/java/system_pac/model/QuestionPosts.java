package system_pac.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class QuestionPosts {
    String question_text;
    QuestionPosts post;
    UserAccount account;
    Date date;

    public QuestionPosts(String question_text, Date date) {
        this.question_text = question_text;
        this.date = date;
    }

    public QuestionPosts(){
    }

    public  void createPost(){
        post = new QuestionPosts();
    }

    public UserAccount getAccount() {
        return account;
    }

    public Date getData() {
        return date;
    }

}
