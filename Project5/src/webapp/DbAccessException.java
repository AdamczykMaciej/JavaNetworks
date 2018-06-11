package webapp;

import java.sql.SQLException;

public class DbAccessException extends RuntimeException {
	private static final long serialVersionUID = -1158591439616432696L;

	public DbAccessException(String msg, SQLException cause) {
		super(msg, cause);
	}

}
