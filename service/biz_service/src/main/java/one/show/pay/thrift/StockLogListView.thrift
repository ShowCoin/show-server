namespace java one.show.pay.thrift.view

include "StockLogView.thrift"
struct StockLogListView{
	1:list<StockLogView.StockLogView> stockLogList
	2:i32 count
}


