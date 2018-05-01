
import org.springframework.data.repository.CrudRepository;
import com.deltaww.analytics.model.MySQLUser;

public interface MySQLUserRepository extends CrudRepository<MySQLUser, Long> {

}