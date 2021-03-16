package ch05.ch01.warehouse;

import ch05.ch01.BeanSupport;

public aspect WarehouseBeanParticipation 
{
	declare parents: ch05.ch01.warehouse.* implements BeanSupport;
}
