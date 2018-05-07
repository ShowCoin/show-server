namespace java one.show.stat.thrift.view

include "MonitorStatView.thrift"
struct MonitorStatListView{
	1:list<MonitorStatView.MonitorStatView> monitorStatList
	2:i32 count
}


