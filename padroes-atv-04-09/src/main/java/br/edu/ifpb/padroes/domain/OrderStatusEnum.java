package br.edu.ifpb.padroes.domain;

public enum OrderStatusEnum implements OrderStatusInterface {
	
	IN_PROGRESS{
		
		@Override
		public OrderStatusEnum setStatus(OrderStatusEnum enumState) {
			return enumState;
		}

		@Override
		public OrderStatusInterface getStatus() {
			return OrderStatusEnum.IN_PROGRESS;
		}

	},
	
	PAYMENT_SUCCESS{

		@Override
		public OrderStatusEnum setStatus(OrderStatusEnum enumState) {
			return enumState;
			
		}

		@Override
		public OrderStatusInterface getStatus() {
			return OrderStatusEnum.PAYMENT_SUCCESS;
		}

	},
	
	PAYMENT_REFUSED{

		@Override
		public OrderStatusEnum setStatus(OrderStatusEnum enumState) {
			return enumState;
			
		}

		@Override
		public OrderStatusInterface getStatus() {
			return OrderStatusEnum.PAYMENT_REFUSED;
		}


	},
	
	CANCELED{

		@Override
		public OrderStatusEnum setStatus(OrderStatusEnum enumState) {
			return enumState;
			
		}

		@Override
		public OrderStatusInterface getStatus() {
			return OrderStatusEnum.CANCELED;
		}

	}
}
