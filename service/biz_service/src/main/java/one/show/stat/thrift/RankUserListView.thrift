namespace java one.show.stat.thrift.view

include "RankUserDailyView.thrift"
struct RankUserListView{
	1:list<RankUserDailyView.RankUserDailyView> rankUserList
	2:i32 count
}


