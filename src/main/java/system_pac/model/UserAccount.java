package system_pac.model;

import java.util.List;

public class UserAccount {

    private Long id;
    private String name;
    private Integer shift;
    private List<QuestionPosts> questionPosts;

    /**здесь творится какая-то паронормальщина. почему-то он не суется в этот метод оттуда, откуда надо**/
    public UserAccount(Long id, String name, Integer shift) {
        this.id = id;
        this.name = name;
        this.shift = shift;
    }

    public UserAccount(){

    }
    public String getName() {
        return name;
    }

    public Integer getShift() {
        return shift;
    }

    public Long getId() {
        return id;
    }
    public void addQuest(UserAccount userAccount) {

    }
}
