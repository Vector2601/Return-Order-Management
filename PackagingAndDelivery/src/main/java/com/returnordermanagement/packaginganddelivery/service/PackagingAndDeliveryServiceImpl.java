package com.returnordermanagement.packaginganddelivery.service;

import org.springframework.stereotype.Service;

import com.returnordermanagement.packaginganddelivery.constant.Constant;
import com.returnordermanagement.packaginganddelivery.dao.PackagingAndDeliveryService;
import com.returnordermanagement.packaginganddelivery.exception.ComponentTypeNotFound;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PackagingAndDeliveryServiceImpl implements PackagingAndDeliveryService {

	double packagingAndDeliveryCost;


	@Override
	public double getPackingAndDeliveryCharge(String componentType, int count) throws ComponentTypeNotFound {

		log.info("Calculating charges for packaging and delivery");
		log.debug(
				"getPackingAndDeliveryCharge() method invoked inside PackagingAndDelivery Microservice to get amount and pacakaging and delivery charge");

		if (componentType.equals(Constant.COMPONENT_INTEGRAL)) {
			packagingAndDeliveryCost = Constant.PROTECTIVE_SHEATH + Constant.INTEGRAL_ITEM_PACKING
					+ Constant.INTEGRAL_ITEM_DELIVERY;
			log.debug(
					"PackagingAndDeliveryServiceImpl Calculating charge for Integral Component {} ,packagingAndDeliveryCost");
			return (packagingAndDeliveryCost * count);
		}

		else if (componentType.equals(Constant.COMPONENT_ACCESSORY)) {
			packagingAndDeliveryCost = Constant.PROTECTIVE_SHEATH + Constant.ACCESSORY_PACKING
					+ Constant.ACCESSORY_DELIVERY;
			log.debug(
					"PackagingAndDeliveryServiceImpl Calculating charge for Accessory Component {} ,packagingAndDeliveryCost");
			return (packagingAndDeliveryCost * count);
		} else {
			log.info(
					"PackagingAndDeliveryServiceImpl Throwing Excetion for Component Not found Wrong Component Name given");

			throw new ComponentTypeNotFound("Component Type entered Wrong");
		}

	}
}