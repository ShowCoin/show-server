namespace java one.show.pay.thrift.view

struct ChargeRecordView{  
    1:i64 id 
	2:string tradeNo
	3:string fromAddress
	4:string toAddress
	5:i64 uid
	6:i32 coinType
	7:string coinNum
	8:double exchangeRate
	9:string showCoinNum
	10:i32 tradeTime
	11:i32 createTime
} 
