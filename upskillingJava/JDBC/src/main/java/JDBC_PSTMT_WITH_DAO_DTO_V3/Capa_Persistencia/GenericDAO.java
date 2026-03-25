package JDBC_PSTMT_WITH_DAO_DTO_V3.Capa_Persistencia;

import java.util.List;

public interface GenericDAO<T>  {

    // ==========PATRON DAO GENERICO====================

    //INSERTA UN OBJETO T , PODRIA DEVOLVER SOLO  MENSAJE, O EN MI CASO UN INT CON EL RESULTADO DE LA CONSULTA
    public int insertUser(T obj);

    //RETORNA UN OBJETO DE TIPO T
    public T findUserById(int  id);

    // ES UNA LISTA DE T
    public List<T> findAll();

    //ACTUALIZA UN OBJETO T RECIBE EL T obj Y UN ID , PODRIA DEVOLVER SOLO  MENSAJE, O EN MI CASO UN INT CON EL RESULTADO DE LA CONSULTA
    public int updateUser(int id,T obj);

    //ELIMNA UN UBJETO T , LE PASAS EL ID LO BUSCA Y SI LO ENCUENTA LO ELIMINA
    public int deleteUser(int id);




}
