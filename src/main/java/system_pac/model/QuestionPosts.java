package system_pac.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class QuestionPosts {
    String question;
    String answer;
    UserAccount account;
    Date date;

    public QuestionPosts(String question, String answer, /*UserAccount account,*/ Date date) {
        this.question = question;
        this.answer = answer;
     /*   this.account = account;*/
        this.date = date;
    }

    public String getAnswer() {
        return answer;
    }

    public UserAccount getAccount() {
        return account;
    }

    public Date getData() {
        return date;
    }

}
