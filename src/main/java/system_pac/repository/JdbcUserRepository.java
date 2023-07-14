package system_pac.repository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import system_pac.model.QuestionPosts;
import system_pac.model.UserAccount;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class JdbcUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(UserAccount account) {
        jdbcTemplate.update("insert into user(userId, userName, userSurname, userShift) values (?, ?, ?, ?)", account.getId(), account.getName(), account.getSurname(), account.getShift());
    }

    @Override
    public UserAccount getById(long id) {
        return jdbcTemplate.query("select * from storage left_join item on userAccount.id=item.userAccount_id where userAccount.id=?", new UserExtractor(), id).get(id).getAccount();
    }

    public static class UserExtractor implements ResultSetExtractor<Map<Long, QuestionPosts>>{

        @Override
        public Map<Long, QuestionPosts> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, QuestionPosts> result = new LinkedHashMap<>();

            while (rs.next()){
                Long userId = rs.getLong(1);
                String userName = rs.getString(2);
                String userSurname = rs.getString(3);
                Integer userShift = rs.getInt(4);

                UserAccount userAccount = new UserAccount(userId, userName, userSurname, userShift);

                Long QuestionId = rs.getLong(5);
                if(!rs.wasNull()){
                    String questionQuestion = rs.getString(6);
                    String questionAnswer = rs.getString(7);
                    Date questionDate = rs.getDate(8);

                    QuestionPosts questionPosts = new QuestionPosts(questionQuestion, questionAnswer, questionDate);
                    /**здксь должно было быть добавление результата по айди, но беда в паронормальщине
                     * в классах квестион и юзераккаунт**/
                }

            }
            return result;
        }
    }
}
