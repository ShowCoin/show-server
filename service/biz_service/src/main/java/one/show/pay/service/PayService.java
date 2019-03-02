package one.show.pay.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.common.exception.StockNotEnoughException;
import one.show.pay.domain.ChargeRecord;
import one.show.pay.domain.ExtractRmb;
import one.show.pay.domain.GiftRank;
import one.show.pay.domain.Item;
import one.show.pay.domain.Orders;
import one.show.pay.domain.PayConfig;
import one.show.pay.domain.ReturnList;
import one.show.pay.domain.TransactionFrom;
import one.show.pay.domain.TransactionToUid;
import one.show.pay.domain.TransactionToVid;
import one.show.pay.domain.WithdrawAddress;
import one.show.pay.domain.WithdrawRecord;
import one.show.pay.thrift.view.OrdersView;


public interface PayService {
	
	public void saveOrders(Orders orders) throws ServiceException;

	public Orders getOrdersById(long orderId) throws ServiceException;
	
	public void updateOrdersById(long orderId,Map<String, String> paramMap) throws ServiceException;

	public int updateOrdersByConditions(Map<String, String> conditions, Map<String, String> paramMap) throws ServiceException;


	public ReturnList<Orders> getOrdersListByParams(Map<String, String> paramMap, int start, int count)throws ServiceException;
	
	public int getOrdersMoneyByParams(Map<String, String> paramMap)throws ServiceException;
	
	public void saveTransactionFrom(TransactionFrom transactionFrom) throws ServiceException;
	
	public List<TransactionFrom> findTransactionFromList(Map<String,String> params,int start,int end)throws ServiceException;
	
	public int findTransactionCountFromList(Map<String,String> params)throws ServiceException;
	
	public void saveTransactionTo(TransactionToUid transactionToUid) throws ServiceException;
	
	public List<TransactionToUid> findTransactionToUidList(Map<String,String>params,int start,int pageCount)throws ServiceException;
	
	public int findTransactionToUidCount(Map<String,String>params)throws ServiceException;
	
	public void saveTransactionToVid(TransactionToVid transactionToVid)throws ServiceException;
	
	public List<TransactionToVid>findTransactionToVid(String vid,Map<String,String> params)throws ServiceException;
	
	public List<Orders> findOrdersViewsByUid(long uid,Map<String,String> params,int start,int end) throws ServiceException;
	
	public void send(long uid, Item item,  long liveId, long tid) throws ServiceException, StockNotEnoughException;
	
	public void redeemRmb(ExtractRmb extractRmb)  throws ServiceException, StockNotEnoughException;
	
	
	public List<GiftRank> findGiftRanksByUid(long uid,int start,int count);
	
	public List<GiftRank> findGiftDayRanksByUid(long uid,int start,int count);
	
	public List<GiftRank> findGiftWeekRanksByUid(long uid,int start,int count);
	
	public List<GiftRank> findGiftMonthRanksByUid(long uid,int start,int count);
	
	public List<GiftRank> findGiftRanksByVid(long vid,int start,int count);
	
	public Integer findTotalReceiveByVid(long vid) throws ServiceException;
	
	public List<PayConfig> findAllPayConfigs() throws ServiceException;

	public OrdersView findOrderViewByReceipt(String md5_receipt) throws ServiceException;
	
	public Long findTransactionMoneyByParams(Map<String, String> paramMap) throws ServiceException ;

	public void chargeRecord(ChargeRecord chargeRecord) throws ServiceException;
	 
	public void addWithdrawAddress(WithdrawAddress withdrawAddress) throws ServiceException;
	 
	public void updateWithdrawAddress(int id,Map<String, String> updateContent) throws ServiceException;
	 
    public void sendHB(Long userId,BigDecimal amount,Integer count) throws ServiceException;

	public void spendHB(Long userId,BigDecimal amount) throws ServiceException;
	 
	public List<WithdrawAddress> findWithdrawAddressList(long uid) throws ServiceException;

	public long applyWithdraw(WithdrawRecord withdrawRecord) throws ServiceException, StockNotEnoughException;

	public void updateWithdrawRecord(long id, Map<String, String> updateContent) throws ServiceException;

	public void getWithdrawRecord(long id, Map<String, String> updateContent) throws ServiceException;

}
