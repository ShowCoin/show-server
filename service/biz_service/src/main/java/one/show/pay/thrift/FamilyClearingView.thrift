namespace java one.show.pay.thrift.view

struct FamilyClearingView{
	1:i32 id
	2:i64 familyId
	3:double userShowCoinTotal
	4:double userIncomeTotal
	5:i32 userLiveDurationTotal
	6:i32 effectiveUsers
	7:double familyClearingRatio
	8:double familyIncome
	9:i64 ownerId
	10:i32 status
	11:i32 createTime
	12:i32 finishTime
	13:string familyName
	14:double totalPayment
	15:string orderId
	16:string reason
}