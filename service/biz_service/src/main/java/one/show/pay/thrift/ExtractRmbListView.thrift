namespace java one.show.pay.thrift.view

include "ExtractRmbView.thrift"
struct ExtractRmbListView{
	1:list<ExtractRmbView.ExtractRmbView> extractRmbList
	2:i32 count
}