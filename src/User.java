public class User {
    private String username;


    public User(){}
    public User(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (!username.isEmpty()){
            this.username = username;
        }else{
            this.username = "Ghest";
        }

    }





    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' + '}';
    }
}
