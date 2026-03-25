package JDBC_PSTMT_WITH_DAO_V2.models;

public class User {

        private int id;
        private String name;
      //  private String email;


    //constructor sin  parametros
    public User()
    {}

    public User( String name){
        this.name=name;
    }

        // Getters y Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

       // public String getEmail() { return email; }
       // public void setEmail(String email) { this.email = email; }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}



