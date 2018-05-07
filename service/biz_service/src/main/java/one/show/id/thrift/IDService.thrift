namespace java one.show.id.thrift.iface

include "IDView.thrift"

service IDServiceProxy{
	i64 nextId();
	
	i64 nextPid();
	
	IDView.IDView nextIdAndPid();
}