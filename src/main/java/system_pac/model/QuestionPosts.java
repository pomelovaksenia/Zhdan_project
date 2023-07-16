package system_pac.model;

import java.util.Date;

public class QuestionPosts {
    Long id;
    String question_text;
    Date date_post;
    QuestionPosts post;
    UserAccount account;

    public QuestionPosts(Long id, String question_text, Date date_post) {
        this.id = id;
        this.question_text = question_text;
        this.date_post = date_post;
    }

    public QuestionPosts(){
    }

    public  void createPost(){
        post = new QuestionPosts();
    }

    public UserAccount getAccount() {
        return account;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public Date getData() {
        return date_post;
    }

}
