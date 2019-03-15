
public class Calculadora {
    int valor,
            modoOperacion,
            total,
            valorAnterior;
    final int base=10;
    private Formulario formulario;
    public void MostrarValor() {
        Formulario form = new Formulario();
        form.initialize();
        pantalla.settext(this.valor);
    }
    public void Total(){
        System.out.println(total);
    }
    public void Ponercero(){
        valor = 0;
        modoOperacion = 0;
    }
    public void AñadirDigito(){
        valor = * base + digito;
    }
    public void PantallaMensaje(){

    }

}
