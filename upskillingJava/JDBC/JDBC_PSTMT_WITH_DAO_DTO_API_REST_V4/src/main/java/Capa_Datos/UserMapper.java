package JDBC_PSTMT_WITH_DAO_DTO_API_REST_V4.Capa_Datos;





public class UserMapper {

 //para  acceder a ellos desde cualquier lado sin crear instancias son publicos y static

        public static UserDTO toDTO(User user) {
           UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setLastName(user.getLastName());
            dto.setAge(user.getAge());
            dto.setEmail(user.getEmail());
            return dto;
        }

        public static  User toEntity(UserDTO dto) {
        User user = new User();
            user.setId(dto.getId());
            user.setName(dto.getName());
            user.setLastName(dto.getLastName());
            user.setAge(dto.getAge());
            user.setEmail(dto.getEmail());
            return user;
        }
    }


