import capa_negocio.UserService;
import capa_negocio.UserServiceDAO;
import capa_persistencia.UserDAO;
import capa_persistencia.UserDaoImp;
import capa_presentacion.UserController;
import capa_presentacion.UserRoutes;

public class MainJPA {

    public static void main(String[] args) {

        UserDAO userDAO =new UserDaoImp(); //constructor

        UserServiceDAO serviceDAO  =new UserService(userDAO); //constructor

        UserController controller = new UserController(serviceDAO); //contructor

        UserRoutes routes= new UserRoutes(controller); //constructor


        routes.configure();

    }
}
