package system_pac.repository;

import system_pac.model.QuestionPosts;

public interface QuestionRepository {
    void create (Long id, QuestionPosts questionPosts);
    /** не знаю, нужен ли тут этот интерфейс, но пусть пока будет**/
}
