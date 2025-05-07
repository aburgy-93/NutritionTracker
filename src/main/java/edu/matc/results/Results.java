package edu.matc.results;

public class Results {
    private String username;
    private String email;
    private String sub;
    private String birthdate;

    public Results() {}

    public Results(String username, String email, String sub, String birthdate) {
        this.username = username;
        this.email = email;
        this.sub = sub;
        this.birthdate = birthdate;
    }

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getSub() {return sub;}
    public void setSub(String sub) {this.sub = sub;}

    public String getBirthdate() {return birthdate;}
    public void setBirthdate(String birthdate) {this.birthdate = birthdate;}

    public Results getResults() {
        return new Results(username, email, sub, birthdate);
    }

    @Override
    public String toString() {
        return "Results [username=" + username + ", email=" + email + ", sub=" + sub + "]";
    }
}
