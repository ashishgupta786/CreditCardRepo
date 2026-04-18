
   

CUSTOMER
---------
ID (PK)
NAME
EMAIL
PHONE_NO
SALARY
DOCUMENT_TYPE
DOCUMENT_NO
CREDIT_SCORE

        1
        |
        |
        M

CREDIT_CARD
-----------
ID (PK)
CARD_TYPE
CARD_LIMIT
CARD_NO
PIN
STATUS
EXPIRY_DATE
CUST_ID (FK)

Data Type:

CUSTOMER

ID               INT (PRIMARY KEY)
NAME             VARCHAR(100)
EMAIL            VARCHAR(100)
PHONE_NO         VARCHAR(15)
SALARY           DECIMAL(10,2)
DOCUMENT_TYPE    VARCHAR(50)
DOCUMENT_NO      VARCHAR(50)
CREDIT_SCORE     BIGINT


CREDIT_CARD

ID               INT (PRIMARY KEY)
CARD_TYPE        VARCHAR(50)
CARD_LIMIT       DECIMAL(10,2)
CARD_NO          VARCHAR(20)
PIN              INT
STATUS           VARCHAR(20)
EXPIRY_DATE      DATE
CUST_ID          INT (FOREIGN KEY)



Future enchancement:

There can be different table for Employment_info oin which we can company name, salary,employment_duration



API:


1.Customer Registration:

URI: /api/creditcard/v1/register

Method: post

Request: 

{
  name:"Vikas Shende",
  email:"abc@gmail.com',
  phone:"1235468712',
  salary:45123,
  doc_type:"aadhar",
  document_no:"4512",
  crdeit_score:0
}

Response:
{
 cust_id: 1234,
 message: "Register successfully",
 staus: "pending"
}


2. Customer Login:

URI:  /api/creditcard/v1/login
Method: POST
Request:
{ username:"abc",
  pass:"123@12
}

Response:
 {
  message: "Customer login successfully"
}

Credit card apply: 

/api/creditcard/apply

request:

{
	custId:12345

}

Response:
{
  custId:12345,
  message:"apply successfully",
  status:"pending",
 


}

Application status:

URI: /api/creditcard/status

Method: GET

Request: 
{
custId:12345,

}

Response:
{
custId:12345,
card_no:"451265325456",
message:"You are eliible for credit card",
status:"approve"
}

 

3. Credit Score

URL: /api/creditcard/creditscore/{custId}
Method: GET
Request: 
 {
  CustId: 12345,
  
}

Response:

 {
  custId: 12345,
  crdit_Score:300.
  status: "pending"
}

4. Credit Approval
URI: /api/creditcard/creditapproval/{custId}
Method: GET

Request:
 { 
   cust_id:12345
}

Response:
{

  custId:12345,
  staus:"success"
  creditCardNo:"451265325456"
}

