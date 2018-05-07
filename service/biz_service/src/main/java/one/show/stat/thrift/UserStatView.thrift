namespace java one.show.stat.thrift.view

struct UserStatView{  
    1:i64 uid  
    2:i32 fans
    3:i32 follow 
    4:i32 login 
    5:i32 videos 
    6:i32 viewed 
    7:double receive
    8:double spend
    9:double receiveExp
    10:double spendExp
}
