package capa_persistencia;
import capa_datos.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;



public class UserDaoImp implements UserDAO {

    //crea una unidad de persistencia con lo configurado en el el archivo persitence.xml
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");

    //===============aca implemento los metodos del UserDAO===================================

    @Override
    public List<User> findAll() {
        EntityManager entityManager=emf.createEntityManager();
        List<User> users=null;
        try{
            entityManager.getTransaction().begin(); //inicia la transaccion
            users=entityManager.createQuery("select u from  User u", User.class).getResultList();
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
            {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }

        return users;
    }



    @Override
    public Long create(User user) {
        EntityManager entityManager=emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        }catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
            {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
        finally {
            entityManager.close();
        }
        //retorna el id del user
        return user.getId();
    }



    @Override
    public User findById(Long id) {
        EntityManager entityManager=emf.createEntityManager();
        User user=null;
        try{
            entityManager.getTransaction().begin();
            user=entityManager.find(User.class,id);
            entityManager.getTransaction().commit();
        }catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
            {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
        finally {
            entityManager.close();
        }
        return user ;
    }







    @Override
    public int update(long id, User user) {
        EntityManager entityManager=emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            //para actualizar buscar el user primero

            User user_found=entityManager.find(User.class,id);
            if(user_found !=null)
            {
                //ahora seteamos el user si existe
                user_found.setName(user.getName());
                user_found.setLastName(user.getLastName());
                user_found.setAge(user.getAge());
                user_found.setEmail(user.getEmail());
            }

            entityManager.getTransaction().commit();
        }catch(Exception e)
        {
            if(entityManager.getTransaction().isActive())
            {
                entityManager.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
            return 0; //error de actualizacion

        }
        finally {
            entityManager.close();
        }
        return 1; //exito en la actualizacion
    }



    @Override
    public int delete(Long id) {
        EntityManager entityManager=emf.createEntityManager();

        try{
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, id);
            if(user !=null)
            {
                entityManager.remove(user);
            }
            entityManager.getTransaction().commit();

        }catch(Exception e){

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback(); //rollback
            }
            e.printStackTrace();
            return 0; // Error en la actualización
        }finally {
            entityManager.close();
        }
        return 1;
    }
}
