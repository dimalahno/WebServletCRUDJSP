package factory;

import org.hibernate.cfg.Configuration;
import java.sql.Connection;

public interface DBHelper {
    Connection getConnection();
    Configuration getConfiguration();
}
