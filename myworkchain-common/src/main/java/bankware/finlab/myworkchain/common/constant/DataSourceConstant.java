package bankware.finlab.myworkchain.common.constant;

//TODO : Properties로 관리할 정보 처리
public class DataSourceConstant {
	
	//REST API
	public static final String REST_API_URL_TRANSACTION = "https://api.luniverse.io/tx/v1.0/transactions/";
	public static final String REST_API_URL_WALLET = "https://api.luniverse.io/tx/v1.0/wallets/";
	public static final String BEARER_API = "XVgsnDtJLUTZhVh112swjeKyqGQDDgWAL2rJTtSdD2PZhsypjifapM8nFZVWCV2J";
	
	//REST API POSTFIX
	public static final String POSTFIX_COMPANY_USER_LIST = "companyUserListV1"; //getEmployeeAddressList의 API PostFix
	public final static String POSTFIX_TRANSFER_TO_USER = "transfer2User";
	public final static String POSTFIX_GET_BALANCE = "/FT9754/R1908/balance";
	public final static String POSTFIX_CHECK_STAMP = "checkStampV2";
	public final static String POSTFIX_STAMP_LIST = "stampListV2";
	
	//Wallet Address
	public static final String COMPANY_ADDRESS = "0x69f2d1bdc2430a3a067620f617fec3100b892d54";
	
	//Work History 등록시 주는 리워드 토큰
	public static final int VALUE_AMOUNT = 100;
}
