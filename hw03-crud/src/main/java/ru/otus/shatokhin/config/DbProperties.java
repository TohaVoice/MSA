package ru.otus.shatokhin.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import ru.otus.shatokhin.UserApplication;

import java.util.StringJoiner;

@ConfigurationProperties(prefix = "spring.datasource")
public class DbProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbProperties.class);

    private static final String ERROR_MSG_PATTERN = "Environment variable %s is empty. Please set it";
    private String username;
    private String password;
    private String url;

    @PostConstruct
    public void printInit() {
        LOGGER.info(toString());
        StringJoiner errors = new StringJoiner(", ");
        if (url.equals("${DB_HOST}")) {
            errors.add("DB_HOST");
        }
        if (username.equals("${DB_USER}")) {
            errors.add("DB_USER");
        }
        if (password.equals("${DB_PASSWORD}")) {
            errors.add("DB_PASSWORD");
        }
        if (errors.length() > 0) {
            throw new IllegalArgumentException(String.format(ERROR_MSG_PATTERN, errors));
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DbProperties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
