package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Util {
    private static String driver = "org.postgresql.Driver";
    private static String database = "coretask";
    private static String user = "postgres";
    private static String password = "postgres";

    public static Connection getJDBCConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/" + database, user, password);
    }

    public static SessionFactory getHibernateFactory(){
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "org.postgresql.Driver");
        settings.put("dialect", "org.hibernate.dialect.PostgreSQLDialect");
        settings.put("hibernate.connection.url",
                "jdbc:postgresql://127.0.0.1:5432");
        settings.put("hibernate.connection.username", user);
        settings.put("hibernate.connection.password", password);
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        Metadata metadata = metadataSources.buildMetadata();
        return metadata.getSessionFactoryBuilder().build();
    }
}
