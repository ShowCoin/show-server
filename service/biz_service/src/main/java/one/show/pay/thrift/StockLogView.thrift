namespace java one.show.pay.thrift.view

struct StockLogView{  
    1:i32 id
    2:i64 uid
    3:i32 itemId
    4:string itemName
    5:i32 itemType
    6:string itemNumber
    
    7:i32 operate
    8:i32 actionTime
    9:i32 actionType
    
    10:string actionDesc
    11:string beforeChange
    12:string afterChange
} 
