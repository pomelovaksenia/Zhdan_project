package system_pac.model;

import javax.xml.crypto.Data;

public class QuestionPosts {
    String answer;
    UserAccount account;
    Data data;

    public QuestionPosts(String answer, UserAccount account, Data data) {
        this.answer = answer;
        this.account = account;
        this.data = data;
    }

    public String getAnswer() {
        return answer;
    }

    public UserAccount getAccount() {
        return account;
    }

    public Data getData() {
        return data;
    }
}
