namespace java one.show.pay.thrift.view

include "OrdersView.thrift"
struct OrdersListView{
	1:list<OrdersView.OrdersView> ordersList
	2:i32 count
}


