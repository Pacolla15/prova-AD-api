package escola.exception;

public class SalaNaoEncontradaException extends RuntimeException {

    public SalaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}