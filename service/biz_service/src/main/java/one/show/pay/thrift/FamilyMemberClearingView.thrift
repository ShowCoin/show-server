namespace java one.show.pay.thrift.view

struct FamilyMemberClearingView{
	1:i32 cid
	2:i64 familyId
	3:i64 userId
	4:i32 role
	5:i32 userZz
	6:double userIncome
	7:i32 userLiveDuration
	8:i32 userLiveEffectiveDays
	9:i32 createTime
	10:string userNickName
	11:string userPid
}