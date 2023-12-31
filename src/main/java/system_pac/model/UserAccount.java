package system_pac.model;

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

    public UserAccount(String name, String surname, Integer shift) {
        this.name = name;
        this.surname = surname;
        this.shift = shift;
    }

    private String name;
    private String surname;
    private Integer shift;
}
