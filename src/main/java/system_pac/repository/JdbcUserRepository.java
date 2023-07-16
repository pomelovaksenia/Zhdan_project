package system_pac.repository;

import system_pac.model.QuestionPosts;
import system_pac.model.UserAccount;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        jdbcTemplate.update("insert into userAccount(id, name, shift) values (?, ?, ?)", userAccount.getId(), userAccount.getName(), userAccount.getShift());

    }

    public  static class UserExtractor implements ResultSetExtractor<Map<Long, UserAccount>>{
        @Override
        public Map<Long, UserAccount> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long,UserAccount> result =new LinkedHashMap<>();
            while (rs.next()){
                Long userId = rs.getLong(1);
                String userName = rs.getString(2);
                Integer userShift = rs.getInt(3);

                UserAccount userAccount = new UserAccount(userId, userName, userShift);

                Long questionId = rs.getLong(4);

                if (!rs.wasNull()) {
                    String questionQuestion = rs.getString(5);
                    Date questionDate = rs.getDate(6);

                    QuestionPosts  questionPosts = new QuestionPosts(questionId,questionQuestion, questionDate);

                    result.get(userId).addQuest(userAccount);
                }

            }
            return result;
        }
    }
}
