package edu.matc.results;

public class Results {
    private String username;
    private String email;
    private String sub;

    public Results() {}

    public Results(String username, String email, String sub) {
        this.username = username;
        this.email = email;
        this.sub = sub;
    }

    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public String getSub() {return sub;}

    public Results getResults() {
        return new Results(username, email, sub);
    }

    public String toString() {
        return "Results [username=" + username + ", email=" + email + ", sub=" + sub + "]";
    }
}
