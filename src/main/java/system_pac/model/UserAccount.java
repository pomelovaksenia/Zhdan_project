package system_pac.model;

import java.util.List;

public class UserAccount {
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getShift() {
        return shift;
    }

    public Long getId() {
        return id;
    }
    public  void addQuestionPost (QuestionPosts  questionPosts){
        this.questionPosts.add(questionPosts);
    }

    public  void addQuestion(QuestionPosts questionPosts){
        this.questionPosts.add(questionPosts);
    } /**здесь творится какая-то паронормальщина. почему-то он не суется в этот метод оттуда, откуда надо**/
    public UserAccount(Long id, String name, String surname, Integer shift) {
        this.id = Counter.next();
        this.name = name;
        this.surname = surname;
        this.shift = shift;
    }

    private Long id;
    private String name;
    private String surname;
    private Integer shift;
    private List<QuestionPosts> questionPosts;

    public void addQuest(UserAccount userAccount) {

    }
}
