namespace java one.show.stat.thrift.view

struct MonitorStatView{  
	1:i64 id
    2:string name 
    3:i64 totalTime
    4:double avgTime 
    5:i32 succeedNum 
    6:i32 failNum 
    7:i32 totalNum 
    8:i32 type 
    9:i32 time 
    10:double failRatio
    
   
}
