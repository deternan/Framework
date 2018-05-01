
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class MySQLUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String videoid;

	// video
	public String getVideoId() {
		return this.videoid;
	}
}