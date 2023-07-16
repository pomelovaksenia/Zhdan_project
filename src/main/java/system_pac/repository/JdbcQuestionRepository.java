package system_pac.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import system_pac.model.QuestionPosts;

@Repository
public class JdbcQuestionRepository implements QuestionRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcQuestionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Long userId, QuestionPosts questionPosts) {
        jdbcTemplate.update("insert into question(question_text, date, user_Id) values (?, ?, ?)", questionPosts.getQuestion_text(), questionPosts.getData(), userId);
    }
}
