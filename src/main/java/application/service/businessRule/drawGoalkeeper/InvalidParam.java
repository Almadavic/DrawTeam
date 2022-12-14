package application.service.businessRule.drawGoalkeeper;

import application.service.exception.InvalidParamException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class InvalidParam implements DrawGoalkeeperCheck { // Classe para verificar se o parametro passado na URL está inválido, caso esteja, lança exception.

    @Override
    public void validation(String param) {
        if (!param.equalsIgnoreCase("YES")) {
            throw new InvalidParamException("If there is a parameter, this parameter has to be equals ( yes or no ), it was :  " + param);
        }
    }

}
