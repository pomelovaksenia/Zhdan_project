package system_pac.repository;
import org.h2.engine.User;
import system_pac.model.QuestionPosts;
import system_pac.model.UserAccount;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
@Primary
public class JdbcUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserAccount getById(Long id) {
        return jdbcTemplate.query("select * from userAccount left_join question on userAccount.id=userAccount.user_id where userAccount.id=?", new UserExtractor(), id).get(id);
    }

    @Override
    public void create(UserAccount userAccount) {
        jdbcTemplate.update("insert into userAccount(id, name, surname, shift) values (?, ?, ?, ?)", userAccount.getId(), userAccount.getName(), userAccount.getSurname(), userAccount.getShift());

    }

    public  static class UserExtractor implements ResultSetExtractor<Map<Long, UserAccount>>{
        @Override
        public Map<Long, UserAccount> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long,UserAccount> result =new LinkedHashMap<>();
            while (rs.next()){
                Long userId = rs.getLong(1);
                String userName = rs.getString(2);
                String userSurname = rs.getString(3);
                Integer userShift = rs.getInt(4);

                UserAccount userAccount = new UserAccount(userId, userName, userSurname, userShift);

                Long questionId = rs.getLong(5);

                if (!rs.wasNull()) {
                    String questionQuestion = rs.getString(6);
                    String questionAnswer = rs.getString(7);
                    Date questionDate = rs.getDate(8);

                    QuestionPosts  questionPosts = new QuestionPosts(questionQuestion, questionAnswer, questionDate);

                    result.get(userId).addQuest(userAccount);
                }

            }
            return result;
        }
    }
}
