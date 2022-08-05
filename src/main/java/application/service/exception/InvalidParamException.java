package application.service.exception;

public class InvalidParamException extends RuntimeException { // Exception para parametro inválido passado no recurso, exemplo : playmatch?drawGoalkeeper?yeisjsi

    public InvalidParamException(String msg) {
        super(msg);
    }

}
