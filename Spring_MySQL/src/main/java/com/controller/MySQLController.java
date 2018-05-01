
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.deltaww.analytics.model.MySQLUser;
import com.deltaww.analytics.repository.MySQLUserRepository;

@Controller
public class MySQLController {

	@Autowired
	private MySQLUserRepository mySQLUserRepository;
		
	@RequestMapping(method = RequestMethod.GET, value = "/query")
	ResponseEntity<?> getAllVideo() {		
		return ResponseEntity.ok(mySQLUserRepository.findAll());
	}
}