namespace java one.show.pay.thrift.view

struct ExtractRmbView{  
    1:i64 id
    2:i64 uid
    3:i32 status
    4:double itemNumber
    5:double rmbNumber
    6:i32 createTime
    7:i32 updateTime
    8:double beforeChange
    9:double afterChange
    10:string reason
    11:string orderId
	12:string alipayAccount
	13:string alipayName
	14:i32 finishTime
	15:string comment
} 
