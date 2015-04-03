package com.uniandes.stampidia.controllers;

import com.uniandes.stampidia.model.StmpOrder;
import com.uniandes.stampidia.model.StmpShirt;
import com.uniandes.stampidia.services.CartService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/rest")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value="/cart/{orderId}/shirt/{shirtId}",method= RequestMethod.PUT)
    public Resultado addItemToCart(
            @PathVariable("orderId")Integer orderId,
            @PathVariable("shirtId")Integer shirtId){
        Resultado resultado = null;

        if(orderId != null && shirtId != null){
            //TODO :: traer la orden y la camiseta de BD

            StmpOrder order = new StmpOrder();
            order.setId(orderId);
            StmpShirt shirt = new StmpShirt();
            shirt.setId(shirtId);

            cartService.addItemToCart(shirt, order);

            resultado = new Resultado();
            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }
        // TODO :: implementar en caso de parametros invalidos

        return resultado;
    }
}
