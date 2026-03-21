package ExcepcionesCreadasPorElProgramador;

/**
 *
 * @author ArielZarate
 */
public class ExcepcionPadreExcepction  extends Exception{

    /**
     *  llama al constructor invoca1 al metodo padre "Super" y le pasa el parametro
     */

        public ExcepcionPadreExcepction(String sms)
        {
            super(sms);
        }
    }


