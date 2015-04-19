package com.uniandes.stampidia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniandes.stampidia.model.StmpOrder;
import com.uniandes.stampidia.model.StmpPaymentType;
import com.uniandes.stampidia.repos.OrderRepository;
import com.uniandes.stampidia.repos.PaymentTypeRepository;
import com.uniandes.stampidia.services.PaymentTypeService;
import com.uniandes.stampidia.utilities.Constantes;
import com.uniandes.stampidia.utilities.Resultado;
import com.uniandes.stampidia.utilities.Status;
import com.uniandes.stampidia.utilities.enums.EStatusType;

@RestController
@RequestMapping(value="/rest")
public class PaymentTypeController {

	@Autowired
	private PaymentTypeService paymentTypeService;
	
    @Autowired
    private OrderRepository orderRepository;
    
	@Autowired
	private PaymentTypeRepository paymentTypeRepository;
    
	/**
	 * @desc Metodo que busca todos los medios de pago
	 * @author Lorena Salamanca
	 * @return
	 */
	@RequestMapping(value="/pay/methods",method=RequestMethod.GET)
	public Resultado getPaymentTypes(){
		Resultado ro = new Resultado();	
		List<StmpPaymentType> paymentTypes = paymentTypeService.getAllPaymentTypes();
		ro.setResultado(paymentTypes);
		ro.setMensajeConsulta("Este es el resultado!");
		ro.setTotalObjetos(paymentTypes.size());
		return ro;
	}
	
	/**
	 * @desc Metodo que realiza el pago por CashOnDelivery
	 * @author Lorena Salamanca
	 * @return
	 */
	@Secured("ROLE_BUYER")
	@RequestMapping(value="/pay/cash/{orderId}",method= RequestMethod.POST)
    public Resultado payByCashOnDelivery(@PathVariable("orderId")Integer orderId){
        Resultado resultado = new Resultado();
        //El id del metodo de pago CashOnDelivery es 1
        StmpPaymentType stmpPaymentType = paymentTypeRepository.findOne(1);
        if(orderId != null){
            StmpOrder order = orderRepository.findOne(orderId);
            
            order.setIdPaymentType(stmpPaymentType);
            order.setOrderStatus(true);
            order.setPaymentStatus(false);
            resultado.setResultado(orderRepository.save(order));
            resultado.setMensajeAccion(stmpPaymentType.getSuccessUrl());
            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
            resultado.setMensajeAccion(stmpPaymentType.getErrorUrl());
        }
        return resultado;
    }
	
	/**
	 * @desc Metodo que realiza el pago por PSE
	 * @author Lorena Salamanca
	 * @return
	 */
	@Secured("ROLE_BUYER")
	@RequestMapping(value="/pay/pse/{orderId}",method= RequestMethod.POST)
    public Resultado payByPSE(@PathVariable("orderId")Integer orderId){
        Resultado resultado = new Resultado();
        //El id del metodo de pago PSE es 2
        StmpPaymentType stmpPaymentType = paymentTypeRepository.findOne(2);
        if(orderId != null){
            StmpOrder order = orderRepository.findOne(orderId);
            
            order.setIdPaymentType(stmpPaymentType);
            order.setOrderStatus(true);
            order.setPaymentStatus(true);
            resultado.setResultado(orderRepository.save(order));
            resultado.setMensajeAccion(stmpPaymentType.getSuccessUrl());
            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
            resultado.setMensajeAccion(stmpPaymentType.getErrorUrl());
        }
        return resultado;
    }
	
	/**
	 * @desc Metodo que realiza el pago por CreditCard
	 * @author Lorena Salamanca
	 * @return
	 */
	@Secured("ROLE_BUYER")
	@RequestMapping(value="/pay/credit/{orderId}",method= RequestMethod.POST)
    public Resultado payByCreditCard(@PathVariable("orderId")Integer orderId){
        Resultado resultado = new Resultado();
        //El id del metodo de pago Credit Card es 3
        StmpPaymentType stmpPaymentType = paymentTypeRepository.findOne(3);
        if(orderId != null){
            StmpOrder order = orderRepository.findOne(orderId);
            
            order.setIdPaymentType(stmpPaymentType);
            order.setOrderStatus(true);
            order.setPaymentStatus(true);
            resultado.setResultado(orderRepository.save(order));
            resultado.setMensajeAccion(stmpPaymentType.getSuccessUrl());
            resultado.setEstado(new Status(EStatusType.OK, Constantes.SUCCESS_RESULT.getDescription()));
        }else {
            resultado.setEstado(new Status(EStatusType.ERROR, Constantes.INVALID_PARAMS_RESULT.getDescription()));
            resultado.setMensajeAccion(stmpPaymentType.getErrorUrl());
        }
        return resultado;
    }
}
