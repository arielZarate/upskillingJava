package JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Datos;

public class User {

    private int id;
    private String name;
    private String lastName;
    private int age;
    private String email;

    //  private String email;


    //constructor sin  parametros
    public User()
    {}

    public User( String name, String lastName,int age, String email){

          this.name=name;
          this.lastName=lastName;
          this.age=age;
          this.email=email;
    }

        // Getters y Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getLastName() {return lastName;}

        public void setLastName(String lastName) {this.lastName = lastName;}

        public int getAge() {return age;}

        public void setAge(int age) {this.age = age;}

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}



