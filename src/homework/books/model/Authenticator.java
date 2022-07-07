package homework.books.model;

public class Authenticator {

    String  login;
    String password;

    public Authenticator(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Authenticator() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Authenticator{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
