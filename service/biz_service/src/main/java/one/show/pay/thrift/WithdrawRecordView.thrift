namespace java one.show.pay.thrift.view

struct WithdrawRecordView{  
    1:i64 id 
	2:string tradeNo
	3:string fromAddress
	4:string toAddress
	5:i64 uid
	6:i32 coinType
	7:string coinNumber
	8:double exchangeRate
	9:i32 finishTime
	10:i32 tradeTime
	11:i32 createTime
	12:i32 status
	13:string showNumber
	14:string beforeChange
	15:string afterChange
	16:string comment
	17:i32 updateTime
	18:string serviceFee
} 
