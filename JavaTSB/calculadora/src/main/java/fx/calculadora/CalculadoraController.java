package fx.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculadoraController {




    private String n1,n2;
    private String signo="";



    @FXML
    private TextField idpantalla;




    @FXML
    public void  btn7(ActionEvent actionEvent) {
        //digitoPantalla("7");
        idpantalla.setText(idpantalla.getText() + 7);
    }


    @FXML
    public void btn8(ActionEvent actionEvent) {
        //digitoPantalla("8");
        idpantalla.setText(idpantalla.getText() + 8);
    }


    @FXML
    public void btn9(ActionEvent actionEvent) {
        //digitoPantalla("9");
        idpantalla.setText(idpantalla.getText() + 9);
    }



    @FXML
    public void btn4(ActionEvent actionEvent) {
        //digitoPantalla("4");
        idpantalla.setText(idpantalla.getText() + 4);
    }


    @FXML
    public void btn5(ActionEvent actionEvent) {
        //digitoPantalla("5");
        idpantalla.setText(idpantalla.getText() + 5);
    }


    @FXML
    public void btn6(ActionEvent actionEvent) {
        //digitoPantalla("6");
        idpantalla.setText(idpantalla.getText() + 6);
    }



    @FXML
    public void btn1(ActionEvent actionEvent) {
       // digitoPantalla("1");
        idpantalla.setText(idpantalla.getText() + 1);
    }

    @FXML
    public void btn2(ActionEvent actionEvent) {

        //digitoPantalla("2");
        idpantalla.setText(idpantalla.getText() + 2);
    }

    @FXML
    public void btn3(ActionEvent actionEvent) {
        //digitoPantalla("3");
        idpantalla.setText(idpantalla.getText() + 3);
    }

    @FXML
    public void btn0(ActionEvent actionEvent) {
        //digitoPantalla("0");
        idpantalla.setText(idpantalla.getText() + 0);
    }


    /**
     elimina un digito
     */
    public void btnC(ActionEvent actionEvent) {
        String cadena=idpantalla.getText();

        if(cadena.length()>0)
        {
            cadena=cadena.substring(0,cadena.length()-1);
            idpantalla.setText(cadena);
        }
    }


    @FXML
    public void btnAc(ActionEvent actionEvent) {

       idpantalla.setText("");

    }





    @FXML
    public void btnPunto(ActionEvent actionEvent) {

        String cadena= idpantalla.getText();
        if(idpantalla.getText().length()<=0 )
        {
            idpantalla.setText("0.");
        }

        else
            if(!ExisteCaracter(cadena,'.'))
                {
                    idpantalla.setText(idpantalla.getText() + ".");
                }
        }




    public boolean ExisteCaracter( String cadena, char c)
    {

        boolean existe=false;
        for (int i = 0; i < cadena.length(); i++) {

            if( cadena.charAt(i)== c )
            {
                //si existe corta
                existe=true; break;

            }

        }
        return existe;
    }


    public void btnINegative(ActionEvent actionEvent) {
        double num;
        String cadena=idpantalla.getText();

        if(cadena.length()>0)
        {
            num=-1*Double.parseDouble(cadena);
            idpantalla.setText(String.valueOf(num));

        }

    }



    @FXML
    public void btndividi(ActionEvent actionEvent) {
        if(!idpantalla.getText().equals(""))
        {
            n1=idpantalla.getText();
            signo="/";
            idpantalla.setText("");


        }
    }

    @FXML
    public void btnresta(ActionEvent actionEvent) {
        //evaluarOperador('-');
        if(!idpantalla.getText().equals(""))
        {
            n1=idpantalla.getText();
            signo="-";
            idpantalla.setText("");


        }
    }

    @FXML
    public void btnmulti(ActionEvent actionEvent) {
        //evaluarOperador('*');
        if(!idpantalla.getText().equals(""))
        {
            n1=idpantalla.getText();
            signo="*";
            idpantalla.setText("");


        }
    }

    @FXML
    public void btnsuma(ActionEvent actionEvent) {
    //    evaluarOperador('+');
        if(!idpantalla.getText().equals(""))
        {
            n1=idpantalla.getText();
            signo="+";
            idpantalla.setText("");


        }
    }


        @FXML
    public void btnPorcentaje(ActionEvent actionEvent) {
        if(!idpantalla.getText().equals(""))
        {
           n1=idpantalla.getText();
           signo="%";
           idpantalla.setText("");
        }

    }


    @FXML
    public void btnIgual(ActionEvent actionEvent)
    {
        String resultado;
        n2=idpantalla.getText();
        if(!n2.equals(""))
        {
            resultado=Calculadora(n1,n2,signo);
            idpantalla.setText(resultado);
        }
    }
    private String Calculadora(String n1 ,String n2,String signo)
    {
      double resultado=0.0;
      String rep;
      if(signo.equals("-"))
      {
          resultado=Double.parseDouble(n1) -Double.parseDouble(n2);
      }
        if(signo.equals("+"))
        {
            resultado=Double.parseDouble(n1) +Double.parseDouble(n2);
        }

        if(signo.equals("/"))
        {
            if(!n2.equals("0"))
            {
                resultado=Double.parseDouble(n1) / Double.parseDouble(n2);
            }
            else{
                idpantalla.setText("error:numerador cero");
            }
        }

        if(signo.equals("*"))
        {
            resultado=Double.parseDouble(n1) * Double.parseDouble(n2);
        }

        if(signo.equals("%"))
        {
            //double valor=Double.parseDouble(idpantalla.getText());

            resultado=(Double.parseDouble(n1) * Double.parseDouble(n2))/100;
        }


        rep=String.valueOf(resultado);
        return rep;

    }
















}