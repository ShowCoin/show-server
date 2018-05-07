namespace java one.show.pay.thrift.iface

include "OrdersView.thrift"
include "StockView.thrift"
include "StockLogListView.thrift"
include "TransactionToView.thrift"
include "OrdersListView.thrift"
include "TransactionFromView.thrift"
include "NotEnoughException.thrift"
include "ItemView.thrift"
include "ExtractRmbView.thrift"
include "ExtractRmbListView.thrift"
include "GiftRankView.thrift"
include "PayConfigView.thrift"
include "ExtractBindView.thrift"
include "ExtractRmbView.thrift"
include "FamilyClearingView.thrift"
include "FamilyMemberClearingView.thrift"
include "FamilyClearingListView.thrift"
include "FamilyMemberClearingListView.thrift"
include "ChargeRecordView.thrift"
include "WithdrawRecordView.thrift"
include "WithdrawAddressView.thrift"

service PayServiceProxy{

	i64 getMaxBatchNo();

	void saveOrders(1:OrdersView.OrdersView ordersView);

	OrdersView.OrdersView getOrdersById(1:i64 orderId);
	
	OrdersView.OrdersView findOrderViewByReceipt(1:string md5_receipt);
	
	void updateOrdersById(1:i64 orderId, 2:map<string, string> paramMap);

	i32 updateOrdersByConditions(1:map<string, string> conditions, 2:map<string, string> paramMap);

	list<StockView.StockView> findStockByUidAndParam(1:i64 uid,2:map<string,string> params);
	
	StockView.StockView findStockByUidAndItem(1:i64 uid, 2:i32 itemType, 3:i32 itemId);
	
	StockLogListView.StockLogListView findStockLogByUidAndParam(1:i64 uid,2:map<string,string> params,3:i32 start,4:i32 count);
	list<TransactionToView.TransactionToView> findTransactionToUidList(1:map<string,string> params,2:i32 satrt,3:i32 pageCount);
	
	i32 findTransactionToUidCount(1:map<string,string> params);
	
	void saveTransactionToView(1:TransactionToView.TransactionToView TransactionToView);
	void saveTransactionFromView(1:TransactionFromView.TransactionFromView transactionFromView);

	OrdersListView.OrdersListView findOrdersListByParams(1:map<string,string> params,2:i32 start,3:i32 count);
	
	i32 findOrdersMoneyByParams(1:map<string,string> params);
	
	double getStockLogItemTotalByUid(1:i64 uid,2:map<string, string> paramMap);
	
	list<OrdersView.OrdersView> findOrdersViewsByUid(1:i64 uid,2:map<string,string> params,3:i32 start,4:i32 pageCount);
	
	list<TransactionFromView.TransactionFromView> findTransactionFromViewListByParams(1:map<string,string> params,2:i32 start,3:i32 pageCount);
	
	i32 findTransactionFromViewCountByParams(1:map<string,string> params);
	
	i64  findTransactionMoneyByParams(1:map<string, string> paramMap)

	i32 systemSend(1:i64 uid,2:ItemView.ItemView itemView);
	i32 send(1:i64 uid, 2:ItemView.ItemView itemView, 3:i64 liveId, 4:i64 tid);
	
	i32 consume(1:i64 uid,2:ItemView.ItemView itemView);
	
	i32 buy(1:i64 uid,2:ItemView.ItemView itemView);
	
	ExtractRmbView.ExtractRmbView getExtractRmbViewById(1:i64 id);
	
	list<ExtractRmbView.ExtractRmbView> getExtractRmbListByBatchNo(1:i64 batchNo);
	
	list<ExtractRmbView.ExtractRmbView> getExtractRmbListByStatus(1:i32 status, 2:i32 count);
	
	ExtractRmbListView.ExtractRmbListView getExtractRmbListByUid(1:map<string,string> paramMap, 2:i32 start, 3:i32 count);
	double getExtractRmbTotalByUid(1:i64 uid,2:string key, 3:map<string,string> paramMap);
	void updateExtractRmbById(1:i64 id, 2:map<string,string> paramMap);
	void saveExtractRmb(1:ExtractRmbView.ExtractRmbView extractRmbView);
	i32 redeemRmb(1:ExtractRmbView.ExtractRmbView extractRmbView);
	void charge(1:i64 uid,2:ItemView.ItemView itemView);
	
	
	list<GiftRankView.GiftRankView> findGiftRanksByUid(1:i64 uid,2:i32 type,3:i32 start,4:i32 count);
	list<GiftRankView.GiftRankView> findGiftRanksByVid(1:i64 vid,2:i32 start,3:i32 count);
	
	i32 findTotalReceiveByVid(1:i64 vid);
	
	list<PayConfigView.PayConfigView> findAllPayConfigs();
	
	
	void saveExtractBind(1:ExtractBindView.ExtractBindView extractBindView);
	
	ExtractBindView.ExtractBindView getExtractBindByUid(1:i64 uid);
	
	void updateExtractBindByUid(1:i64 uid, 2:string alipayAccount, 3:string alipayName);
	
	void freeze(1:i64 uid, 2:ItemView.ItemView itemView, 3:i32 actionValue,4:string actionDesc);
	
	void unfreeze(1:i64 uid, 2:ItemView.ItemView itemView, 3:i32 actionValue,4:string actionDesc);
	
	void reduce(1:i64 uid, 2:ItemView.ItemView item, 3:i32 actionId, 5:string actionDesc);
	
	double getExtractRmbTotalCount();
	
	
	i32 saveFamilyClearing(1:FamilyClearingView.FamilyClearingView familyClearingView);
	
	void saveFamilyMemberClearing(1:FamilyMemberClearingView.FamilyMemberClearingView familyMemberClearingView);
	
	FamilyClearingListView.FamilyClearingListView findFamilyClearingList(1:map<string,string> params,2:i32 start,3:i32 count);
	
	FamilyMemberClearingListView.FamilyMemberClearingListView findFamilyMemberClearingListByCidAndFamilyId(1:i32 cid, 2:i64 familyId, 3:i32 start, 4:i32 count);
	
	FamilyClearingView.FamilyClearingView getFamilyClearingViewById(1:i64 id);
	
	void updateFamilyClearingView(1:i64 id, 2:map<string,string> updateContent);
	
	list<StockView.StockView> findAllStock0(1:i32 tbid);
	
	list<StockView.StockView> findAllStock1(1:i32 tbid);
	
	void chargeRecord(1:ChargeRecordView.ChargeRecordView chargeRecordView);
	 
	void addWithdrawAddress(1:WithdrawAddressView.WithdrawAddressView withdrawAddress);
	 
	void updateWithdrawAddress(1:i32 id,2:map<string, string> updateContent);
	 
	void deleteWithdrawAddress(1:i32 id);
	 
	list<WithdrawAddressView.WithdrawAddressView> findWithdrawAddressList(1:i64 uid);
	
	i64 applyWithdraw(1:WithdrawRecordView.WithdrawRecordView withdrawRecordView);
	
	void updateWithdraw(1:i64 id,2:map<string,string> updateContent);
	
	void finishWithdraw(1:WithdrawRecordView.WithdrawRecordView withdrawRecordView);
	
}
