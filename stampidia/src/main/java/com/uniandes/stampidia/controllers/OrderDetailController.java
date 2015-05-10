package com.uniandes.stampidia.controllers;

import com.uniandes.stampidia.model.StmpOrder;
import com.uniandes.stampidia.model.StmpOrderDetail;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SEBASTIAN on 09/05/2015.
 */
@RestController
@RequestMapping(value="/rest")
public class OrderDetailController {

    @RequestMapping(value="/cart/items",method= RequestMethod.PUT)
    public Resultado saveItems(
            @RequestBody List<StmpOrderDetail> items){
        Resultado resultado = new Resultado();

        if(!items.isEmpty() && items != null){

            //List<StmpOrderDetail> newItems = cartService.updateOrder(order);
            List<StmpOrderDetail> newItems = null;

            if(newItems != null){
                resultado.setResultado(newItems);
                resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
            }else {
                resultado.setEstado(new Status(EStatusType.ERROR, Constantes.ERROR_RESULT.getDescription()));
            }

        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
        }

        return resultado;
    }
}
