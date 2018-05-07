namespace java one.show.pay.thrift.view

struct OrdersView{  
    1:i64 orderId 
    2:i64 uid 
    3:i32 payStatus
    4:i32 payType
    5:double payMoney
    6:i32 payTime
    7:i32 createTime
    8:string nickName
    9:double itemNum
    10:i32 itemId
    11:i32 itemType
    12:string did
    13:string receipt
    14:i32 platform
    15:string transactionId;
}
